package cn.wenzhuo4657.blog.basic.Filter.logback;



import cn.wenzhuo4657.blog.basic.Application;
import cn.wenzhuo4657.blog.basic.Enum.HttpCode;
import cn.wenzhuo4657.blog.basic.Enum.HttpEnum;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class logfilter implements Filter {

//获取具有唯一性的traceid，用于在日志中标识http请求

    public logfilter() {
        super();
    }
    private  String MDC_TRACE_ID= HttpEnum.traceId;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MDC.setContextMap(HttpCode.copyOfContextMap);
        MDC.put(MDC_TRACE_ID,String.valueOf( Thread.currentThread().getId()));
        chain.doFilter(request, response);
        MDC.clear();
    }

        private String getMdcTreaceID() {
        long currentTime=System.nanoTime();
        return  String.join("_",MDC_TRACE_ID,String.valueOf(currentTime));
    }


}