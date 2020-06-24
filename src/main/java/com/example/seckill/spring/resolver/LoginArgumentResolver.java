package com.example.seckill.spring.resolver;

import com.example.seckill.model.UserSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;

/**
 * @Date 2020/6/24 16:38
 * @Author mawkun
 */
@Slf4j
public class LoginArgumentResolver<T extends UserSession> implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        log.info("登录解析器开始工作！");
        Annotation[] annotions = methodParameter.getParameterAnnotations();
        for(Annotation annotation : annotions) {

        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return null;
    }
}
