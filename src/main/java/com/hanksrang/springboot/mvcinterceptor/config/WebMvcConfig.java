package com.hanksrang.springboot.mvcinterceptor.config;

import com.hanksrang.springboot.mvcinterceptor.interceptor.UrlInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author hanks rang
 * */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /*
     * 拦截器注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new UrlInterceptor()) // 添加拦截器
                .addPathPatterns("/**") // 拦截路径
                .excludePathPatterns("/login") // 添加排除拦截路径
                .order(0); //执行顺序
        super.addInterceptors(registry);
    }
}