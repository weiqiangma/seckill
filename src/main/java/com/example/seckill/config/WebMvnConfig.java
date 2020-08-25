package com.example.seckill.config;

import com.example.seckill.model.UserSession;
import com.example.seckill.spring.interceptor.AuthenticationInterceptor;
import com.example.seckill.spring.resolver.LoginArgumentResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @Date 2020/7/7 13:28
 * @Author mawkun
 */
@Slf4j
@Configuration
public class WebMvnConfig extends WebMvcConfigurationSupport {

    @Bean
    public AuthenticationInterceptor loginRequiredInterceptor() {
        return new AuthenticationInterceptor();
    }

    /**
     * 注册参数解析器
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        log.info("mvc参数解析器");
        argumentResolvers.add(new LoginArgumentResolver<UserSession>());
    }

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginRequiredInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
        super.addInterceptors(registry);
    }
}
