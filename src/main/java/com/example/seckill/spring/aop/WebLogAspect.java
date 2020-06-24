package com.example.seckill.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @Date 2020/6/24 11:31
 * @Author mawkun
 */
@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    public WebLogAspect() {
        this.logger.info("<WebLogAspect> AOP init....");
    }

    @Pointcut("execution(public * com.example.seckill.controller..*.*(..))")//切入点描述 这个是controller包的切入点
    public void controllerLog(){}//签名，可以理解成这个切入点的一个名称

    @Before("controllerLog()") //在切入点的方法run之前要干的
    public void logBeforeController(JoinPoint joinPoint) {
        this.logger.info("=======================================<WebLogAspect>=======================================");
        this.startTime.set(System.currentTimeMillis());
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        // 记录下请求内容
        this.logger.info("<WebLogAspect> URL : " + request.getRequestURL().toString());
        this.logger.info("<WebLogAspect> HTTP_METHOD : " + request.getMethod());
        this.logger.info("<WebLogAspect> IP : " + request.getRemoteAddr());
        this.logger.info("<WebLogAspect> CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        this.logger.info("<WebLogAspect> ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret){
        if(this.logger.isInfoEnabled()) {
            this.logger.info("<WebLogAspect> RESPONSE : " + ret);
            this.logger.info("<WebLogAspect> SPEND TIME : " + (System.currentTimeMillis() - this.startTime.get()));
            long endTime = System.currentTimeMillis();
            this.startTime.get();
            this.logger.info("<WebLogAspect> 运行时间: " + (endTime - this.startTime.get()) / 1000);
        }
    }

}
