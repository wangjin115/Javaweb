package com.wj.aop;

import com.alibaba.fastjson.JSONObject;
import com.wj.mapper.OperateLogMapper;
import com.wj.pojo.OperateLog;
import com.wj.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author wj
 * @version 1.0
 */
@Slf4j
@Component
@Aspect
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;


    @Around("@annotation(com.wj.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

               String jwt = request.getHeader("token");
               Claims claims = JwtUtils.parseJWT(jwt);
               Integer operateUser = (Integer) claims.get("id");
         //操作时间
               LocalDateTime operateTime = LocalDateTime.now();

         //操作类名
               String className = joinPoint.getTarget().getClass().getName();
         //操作方法名
               String methodName = joinPoint.getSignature().getName();

         //操作方法参数
               Object[] args = joinPoint.getArgs();
               String methodParams = Arrays.toString(args);
               long begin = System.currentTimeMillis();
        //调用原始目标方法运行
               Object result = joinPoint.proceed();
               long end = System.currentTimeMillis();
        //方法返回值
               String returnValue = JSONObject.toJSONString(result);
        //操作耗时
               Long costTime = end - begin;

        OperateLog operateLog = new OperateLog(null,operateUser,
                operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);
        log.info("AOP记录操作日志: {}" , operateLog);

        return result;

    }
}
