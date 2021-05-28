package com.austin.common.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:实现HandlerExceptionResolver自定义异常处理
 * @Author: GongJun
 * @Date: Created in 18:31 2021/5/28
 */
//撤销@Configuration注释即可生效
//@Configuration
public class GlobalExceptionConfig implements HandlerExceptionResolver {
    @Nullable
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv=new ModelAndView();
        //判断是哪种错误
        if(e instanceof ArithmeticException){
            mv.setViewName("error1");
        }
        if(e instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error",e.toString());
        return mv;
    }
}
