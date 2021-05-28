package com.austin.common.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:MybatisPlus配置bean
 * @Author: GongJun
 * @Date: Created in 16:56 2021/1/18
 */

@Configuration
public class MyBatisPlusConfig {
    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        // 设置数据库类型
        page.setDialectType("mysql");
        return page;
    }
}
