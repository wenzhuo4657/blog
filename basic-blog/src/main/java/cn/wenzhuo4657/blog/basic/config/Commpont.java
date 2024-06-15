package cn.wenzhuo4657.blog.basic.config;

import cn.wenzhuo4657.blog.basic.Application;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;
import static java.util.concurrent.ThreadPoolExecutor.*;

/**
 * @className: Commpont
 * @author: wenzhuo4657
 * @date: 2024/6/15 17:21
 * @Version: 1.0
 * @description:
 */
@Configuration
public class Commpont {
    @Bean
    public Server server(){
        Server server = new Server();

        return server;
    }



    @Bean
    public ServerConnector serverConnector(Server server) {
        ServerConnector serverConnector = new ServerConnector(server);
//  wenzhuo TODO 2024/6/15 : 此处可以设置线程池，待完善


    }


}