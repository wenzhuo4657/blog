package cn.wenzhuo4657.blog.basic.aspect;

import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import com.alibaba.fastjson.JSON;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @className: LogApect
 * @author: wenzhuo4657
 * @date: 2024/6/14 15:52
 * @Version: 1.0
 * @description:
 */
@Aspect
@Component
public class LogApect {
    private Logger log= LoggerFactory.getLogger(LogApect.class);

    @Pointcut("@annotation(cn.wenzhuo4657.blog.basic.annotation.PrintLog)")
    public  void cut(){

    }

    @Before("cut()")
    public void before(JoinPoint point){

        ServletRequestAttributes requestA =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestA.getRequest();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String traceId = MDC.get(HttpEnum.traceId);
        log.info("======start");
        log.info("请求url: "+request.getRequestURI()+"  请求方式： "+request.getMethod());
        log.info("访问IP    : {}"+"   请求类名   : {}",request.getRemoteHost(),point.getSignature().getDeclaringTypeName(),((MethodSignature) point.getSignature()).getName());
        log.info("传入参数   : {}", JSON.toJSONString(point.getArgs()));
    }

    @AfterReturning(value = "cut()",returning = "result")
    public void after(Object result){
        try {
            log.info("response   : {}", JSON.toJSONString(result));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}