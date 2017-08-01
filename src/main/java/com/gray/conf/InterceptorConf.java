package com.gray.conf;

import com.gray.framework.interceptors.DashboardInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器配置类
 * Created by leigang on 2017/7/29.
 */
@Configuration
public class InterceptorConf extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        //拦截Dashboard
        registry.addInterceptor(new DashboardInterceptor()).addPathPatterns("/dashboard/**");
    }
}
