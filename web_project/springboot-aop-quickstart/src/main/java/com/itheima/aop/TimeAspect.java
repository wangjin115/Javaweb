package com.itheima.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @version 1.0
 */
@Slf4j
@Component
@Aspect
public class TimeAspect {
    @Around("execution(* com.itheima.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin =System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end =System.currentTimeMillis();

        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms",end-begin);

        return result;

    }
}
