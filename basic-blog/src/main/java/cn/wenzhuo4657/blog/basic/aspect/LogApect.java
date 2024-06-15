package cn.wenzhuo4657.blog.basic.aspect;

import com.mysql.cj.log.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @Pointcut("@annotation(cn.wenzhuo4657.blog.basic.annotation.PrintLog)")
    public  void cut(){
        Class<? extends LogApect> aClass = new LogApect().getClass();
    }

}