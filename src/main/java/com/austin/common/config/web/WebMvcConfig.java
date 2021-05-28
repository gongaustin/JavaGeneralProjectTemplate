package com.austin.common.config.web;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.text.ParseException;
import java.util.Locale;
import java.util.Properties;

/**
 * @Description:Web配置（跨域、拦截）
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //配置静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取操作系统
        String os = System.getProperty("os.name");
        //Swagger
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        //webjars
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        //静态资源
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 将前端空字符串设置为null,避免报错,swagger2测试传参遇到的坑
     * */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatterForFieldType(String.class, new Formatter<String>() {
            @Override
            public String parse(String text, Locale locale) throws ParseException {
                //如果Web传空字符串，直接返回null
                if(StringUtils.isBlank(text)){
                    return null;
                }
                return text;
            }

            @Override
            public String print(String object, Locale locale) {
                return object;
            }
        });
    }



    //跨域问题解决
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }


    /**
     * druid sql监视器
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        return new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
    }


    //通过FilterRegistrationBean实例注册过滤器
    @Bean
    public FilterRegistrationBean<WebStatFilter> DruidFilterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
    /*
     * 全局异常处理类,使用SimpleMappingExceptionResolver 做全局异常处理
     * 优点：直接在一个方法里对需要处理的异常跳转不同的视图，比较简单方便
     * 缺点：无法把错误信息传递到视图层
     * */
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties p = new Properties();  //集合
        /**
         * 参数一：异常的类型，注意必须是异常类型的全名
         * 参数二：视图名称
         * */
        p.setProperty("org.apache.shiro.authz.UnauthorizedException", "403");
        p.setProperty("org.apache.shiro.authz.UnauthenticatedException", "403");
        p.setProperty("org.apache.shiro.authz.LockedAccountException", "locked");
        resolver.setExceptionMappings(p);
        return resolver;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * 跨域过滤器
     *
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }


}
