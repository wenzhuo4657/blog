package cn.wenzhuo4657.blog.basic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @className: PrintLog
 * @author: wenzhuo4657
 * @date: 2024/6/14 15:52
 * @Version: 1.0
 * @description:
 * 打印注解，获取方法参数、响应结果打印在控制台，便于调试
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PrintLog {


}