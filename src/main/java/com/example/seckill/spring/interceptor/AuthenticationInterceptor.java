package com.example.seckill.spring.interceptor;

import com.example.seckill.model.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器拦截请求获取用户信息存放request里，后续参数解析器会从request中获取用户信息放在注解上
 * @Date 2020/7/7 14:03
 * @Author mawkun
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        Object obj = redisTemplate.opsForValue().get(token);
        request.setAttribute("session", obj);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
