# dbms说明


## mysql





![image.png](http://obimage.wenzhuo4657.cn/20240611111943.png)

utf8mb4:

mysql8.0默认字符集，兼容utf8，但比传统的utf8支持更多的字符。

utf8mb4_bin:

字符串每个字符串用二进制数据编译存储。区分大小写，而且可以存二进制的内容.
bin指字符比较时采用二进制进行比较。当将字符串视为二进制进行比较时，会将字符串中的每个字符视为一组字节（或比特）的序列，而不考虑字符的语义、语言、大小写或重音符号等特征。在进行二进制比较时，只比较字符的字节表示，而不考虑字符本身的含义。



### 表说明

采用RBAC权限模型，关联表采用外键约束

![](http://obimage.wenzhuo4657.cn/image-20240611124435116.png)





# log选择

这里我选用了logback日志，原因是好用，提供了多种输出，而且也是我第一个了解的日志框架，

三个模块的说明

logback-core：其他两个模块的基础模块

logback-classic：是log4j的一个改良版本，完整的实现了日志门面slf4j,并且可以很方便的切换成其他日志系统

logback-access：提供通过 Http 来访问日志的功能





# 功能模块





# 问题解决

## 1，注解开发

初步想法是spring的aop，但是是否可以将cglib动态代理和jdk的动态代理代理融入呢？





**为什么类可以动态的生成？**

Java虚拟机类加载过程主要分为五个阶段：加载、验证、准备、解析、初始化。其中加载阶段需要完成以下3件事情：

1. 通过一个类的全限定名来获取定义此类的二进制字节流
2. 将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
3. 在内存中生成一个代表这个类的 `java.lang.Class` 对象，作为方法区这个类的各种数据访问入口





需要注意的是，代理并不会改变原本的方法，仅仅是执行前、执行后，

静态代理：编码时生成固定的类，

动态代理：根据接口或目标对象，计算出代理类的字节码，然后再加载到JVM中使用。







### 代理选择



以下具体查看demo

https://github.com/wenzhuo4657/demo/tree/main/JDKAndCglib

#### cglib

cglib包下，spring依赖中已经存在，

核心代码

```

  Object proxy = Enhancer.create(target.getClass(), new MethodInterceptor(){});

```

参数分别为

字节码对象

增强方法实现的处理器



区别于jdk，这里并没有要求传入所实现接口的数组，实际中，所生成的字节码文件代表着被代理类的继承子类，也就是说，通过重写方法的形式增强方法，对于java特性多态来说，这属于向上转型，子类型实例指向父类引用，被重写的方法通过动态链接指向子类方法。

  

#### jdk动态代理



实际上jdk.lang包下的api，以下为重点方法

```


   stu proxy= (cn.wenzhuo4657.stu) Proxy.newProxyInstance(classLoader,interfaces【】,jdk);

```

三个参数分别代表：

类加载器

被代理类所实现的接口

代理方法的处理逻辑 



其返回的代理类只能转换为其实现的接口，同时由于java的多态特性，其可访问的字段和方法也就确定的。







进一步了解到

Spring中默认用JDK动态代理 判断目标类是否实现接口，如果实现了接口就用JDK动态代理，否则就使用CGLIB动态代理

在SpringBoot2.x版本后默认是使用CgLib作为默认的动态代理实现。



对于注解开发，代理模式就选择spring的aop代理，但是代理之后实现呢？对于注解的级别问题

### 实现

#### 元注解

@Target：表示注解的使用范围，具体可以使用使查阅

@Retention：注解的生命周期

| RetentionPolicy.SOURCE  | 编译时被丢弃，不包含在类文件中                   |
| ----------------------- | ------------------------------------------------ |
| RetentionPolicy.CLASS   | JVM加载时被丢弃，包含在类文件中，默认值          |
| RetentionPolicy.RUNTIME | 由JVM 加载，包含在类文件中，在运行时可以被获取到 |

对于一般使用，特别使用到反射reflect相关api，其关键性类class表示字节码文件在jvm加载阶段装配，jvm运行时使用，所以如果使用了反射api，其注解的生命周期一定为RetentionPolicy.RUNTIME



@Inherited：注解的继承继承，它用于指示一个注解类是否可以被继承。当 `@Inherited` 被应用到自定义注解类上时，其所有直接注解子类和间接注解子类都继承了该注解所有属性。

这和java类中的单继承，在子类中通过关键字extends是相反的模式，前者是在父类中表示继承，后者是在子类中表示继承。

@Documented：表明该注解标记的元素可以被Javadoc 或类似的工具文档化





至此，由于目前自定义注解仅仅起到打印方法执行信息的作用，所以选用

@Retention（RetentionPolicy.RUNTIME）

@Target（ElementType.TYPE）

并且使用反射获取相关数据进行打印，



### 注解开发



#### PrintLog注解

@Aroud：支持自动传入ProceedingJoinPoint point

@Before、@After：支持JoinPoint point

但是Joinpoint无法获取方法的响应结果，经过查阅找到注解

@AfterReturning(value = "cut()",returning = "result") 



最终实现



```


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
```



## log输出问题

### 注解打印

在自定义注解打印方法执行的过程中，希望将相关信息输出到某个文件中进行集中管理，便于查看和追踪问题，



日志可简单分为日志门面和日志框架（也加日志的具体实现），无论是其中具体哪些搭配，在应用场景中都不可避免的遇到多线程和多用户的场景，那么就很容易造成混乱，对此就需要某些唯一标识来区分，具体有以下三种方式

MDC ( Mapped Diagnostic Contexts ) 是一个[线程安全](https://so.csdn.net/so/search?q=线程安全&spm=1001.2101.3001.7020)的存放诊断日志的容器。MDC是slf4j提供的适配其他具体日志实现包的工具类，目前只有logback和log4j支持此功能。此处是将mdc存储在键值对中。

NDC：NDC或者嵌套诊断上下文（Nested Diagnostic Context）是基于栈的思想，信息可以被放到栈上或者从栈中移除。 而栈中的值可以被Logger访问，并且Logger无需显示想日志方法中传入任何值。

ThreadContext：*Log4j版本2中将MDC和NDC合并到一个单独的组件中，这个组件被称为ThreadContext(线程上下文)。*ThreadContext可以看成是NDC和MDC的结合体，它分别用`Thread Context Stack`和`Thread Context Map`来表示`NDC`和`MDC`。



这里最终仍旧选用slf4j+logback作为日志模块

参考文章

[Slf4j MDC使用和基于Logback的实现分析 – wanziの遇笺 (zhangyuyu.github.io)](https://zhangyuyu.github.io/log-slf4j-mdc-usage-and-logback-impl/)



这里涉及到了唯一标识，需要了解一下Spring Boot对web开发目前有两种解决方案：

1. 传统的web框架基于Spring MVC + Tomcat，

   **使用spring-boot-starter-web启动器，开始web支持，内嵌一个Tomcat，添加了对于SpringMVC的支持。Spring Boot默认servlet容器为tomcat。**

   Tomcat支持三种运行模式（BIO, NIO, APR），大致流程均是：

   当客户端向服务器建立TCP连接，发送请求，服务器操作系统将该连接放入accept队列，Tomcat在accept队列中接收连接；在连接中获取请求的数据，生成request；调用servlet容器处理请求；返回response，完成一次HTTP会话。在Tomcat 8.0前默认使用BIO，Tomcat在accept队列中接受TCP连接并获得HTTP Request，从线程池中取出空闲的线程来处理请求，如果无空闲线程则阻塞。Tomcat 8.0起默认启用NIO模式，在从accept获得request之后，注册到nio.Selector中后不阻塞继续获取连接，Tomcat遍历找到selector中可用的request，再从线程池中取出空闲的线程来处理请求。Tomcat相关的配置参数有：

   1. acceptCount，当accept队列中连接的个数达到acceptCount时，队列满，进来的请求一律被拒绝。
   2. maxConnections，当Tomcat接收的连接数达到maxConnections时，accept队列中的线程会一直阻塞着。
   3. maxThreads，线程池线程的最大数量。

   所以无论是BIO，还是NIO，当请求数量大于acceptCount，接收的连接数大于maxConnection时，Tomcat都不会分配线程服务。

   

   经测试，

   

2. Spring 5新增的web-reactive框架基于Spring Webflux + Netty。









##  认证和授权

由于数据选用了rbac权限模型，所以必然会涉及的登录和授权，此处选用了Spring Security进行，过滤器链查询如下，

![](http://obimage.wenzhuo4657.cn/20240616142316.png)









其中关于认证的核心过滤器，也就是需要自定义分别为：

**UsernamePasswordAuthenticationFilter**;

关键方法

```

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (this.postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		String username = obtainUsername(request);
		username = (username != null) ? username : "";
		username = username.trim();
		String password = obtainPassword(request);
		password = (password != null) ? password : "";
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}
```

其中这两个语句为关键语句，根据请求中的request找到username和password封装UserDetails

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);


return  this.getAuthenticationManager().authenticate(authRequest);其文档注释为

尝试验证传递的Authentication对象，如果成功则返回完全填充的Authentication对象（包括授予的权限）。



其内部调用关键方法public UserDetails loadUserByUsername(String username) ，查询相关信息并封装为UserDetails中，



除此之外还有密码的校验方式，调用bean ：PasswordEncoder，且注意，是bean，这意味着可以在springboot中进行装配，该校验方式的选择仅仅是查阅后推荐使用，

```

    @Bean
    //把官方的PasswordEncoder密码加密方式替换成BCryptPasswordEncoder
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
```





假设程序一直运行，那么上述流程的执行顺序是：













至此我们已经完成了从数据库获取信息进行认证的流程，那么如何使会话持续时间更长呢?默认状况下springSecurity采用Httpsession创建`SecurityContext`，其生命周期就是会话的生命周期，所以引入了token这个概念，

优点有，

1，摆脱session跨域验证的限制，

2，认证的存活时间由程序决定，而不是浏览器的会话周期

3，服务端不需要维护session，减少了负担，

4，便于和其他服务集成，因为是无状态的



对此，有一个关键性类SecurityContext：

定义与当前执行线程关联的最小安全信息的接口，安全上下文存储在`SecurityContextHolder`中，`SecurityContext`从`SecurityContextHolder`获取，并包含当前经过身份验证的用户的`Authentication`。



对应管理这个类的是SecurityContextHolder，查看源码注释得知，其作用是将给定的SecurityContext与当前执行线程关联，内部使用ThreadLocal变量来保存当前线程的安全上下文。

关于创建SecurityContext的方式：Spring Security会在每个HTTP请求开始时创建一个新的SecurityContext，尝试在Httpsession中获取并在请求结束时清除它





目前想要实现的是从请求头中获取token，然后从redis中解析出UserDetals中存入SecurityContext中，







# 报错

## org.slf4j.impl.StaticLoggerBinde

logback+slf4j导入，并配置了logback-spring.xml，却仍旧先没有绑定slf4j的实现。

问题解决，由于在了解logback时，其存在三个模块，一次性导入全部导入了，但日常使用仅仅需要core和classis，如果将access添加进去，由于其功能似乎需要额外的实现？另外，很奇怪的是，去除掉一次access后，springboot似乎可以找到实现了，再将其添加进去就日志配置正常执行了。



此外，其余依赖也存在slf4j，以及slf4j和logback在控制台混合输出的问题，这里注意到了是因为在logback中配置了输出样式，

![](http://obimage.wenzhuo4657.cn/20240616125242.png)



于是，选用日志依赖版本为以下，并排除了springboot以及其他依赖中的slf4j

```java

  <dependency>
            <artifactId>slf4j-api</artifactId>
            <groupId>org.slf4j</groupId>
            <version>1.7.30</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
            <version>1.1.7</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.1.7</version>
        </dependency>
```





## For Jackson Kotlin classes support please add com.fasterxml.jackson.module:jackson-module-kotlin to the classpath

提示使用jackson序列化kotlin类，但是没有对应依赖jackson-module-kotlin，

本项目遇到问题是没有kotlin类，但依旧warn了，且注意，这仅仅是报警，而不是error，可以忽略也可以添加，





## tomcat解析http请求，使用mdc追踪日志，但并未在日志中解析出存入的键值对



尝试在logback-spring.xml通过标签关闭，无效

````

    <logger name="org.apache.catalina" level="OFF"/>
    <logger name="org.apache.coyote" level="OFF"/>
    <logger name="org.apache.tomcat.util" level="OFF"/>
````

发现tomcat版本和jdk版本不对应，尝试调整,该配置会影响springboot的版本管理，

```
  <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <tomcat.version>8.5.69</tomcat.version>
    </properties>
```



放弃解决，一经过tomcat,日志就丢失，logback也没办法捕捉到经过tomcat的请求的日志，其内部不会传递给logback，总结来说问题有两点

1，tomcat处理请求是新建子线程导致mdc丢失，

![](http://obimage.wenzhuo4657.cn/image-20240615161901186.png)



2，tomcat会内部处理请求的警告，不会传递给logback日志。



尝试jetty，仅仅是替换了服务器，

进一步了解后发现

![](http://obimage.wenzhuo4657.cn/image-20240615163325636.png)

响应请求时，此处并没有打印日志，且依旧新建线程处理请求，尝试报错后发现其报警传递到logback中处理，并且可以获取到mdc，

![](http://obimage.wenzhuo4657.cn/image-20240615163943119.png)

但是在日志中查看依旧没有成功获取到mdc键值对，此处只能尝试去解决。

![](http://obimage.wenzhuo4657.cn/image-20240615164958715.png)



Jetty Server 就是由多个 Connector（连接器）、多个 Handler（处理器），以及一个线程池组成。

很显然，对于本次问题的重点，就是重写线程池新建线程的策略，并注入jetty容器中，对此tomcat在 Tomcat 中每个连接器都有自己的线程池，而在 Jetty 中所有的 Connector 共享一个全局的线程池。





Jetty 的线程策略

传统的nio，其核心是Selector 模型，内部会 I/O 事件的侦测和请求的处理分别用不同的线程处理，这样做的好处是分工明确，但深入到cpu和内存层面，会导致读操作和数据缓存可能不在一个cpu核中，但读操作的线程不会去其他cpu核中去寻找，而是到缓存中寻找，基于这一点损失，jetty做出了这样的改变，

**把 I/O 事件的生产和消费放到同一个线程来处理，使其可以完全使用cpu中的缓存**





查阅很多文章，没有找到替换新建线程池的办法，但是在其官方文档了解到其默认线程池实现是[`QueuedThreadPool`]，尝试注入bean，



```



```

服了,发现原来是配置文件输出字段写错了，但是依旧了解到ServerConnector连接器可以设置线程池，



遗留问题，无论是tomcat还是jetty,springboot都无法捕获到其内部的日志，查阅资料得知两者都属于嵌入式服务器，

查阅发现，原来是日志设置不对，控制台中没有输出，是因为设置springboot日志为slf4j和logback，但是在其配置文件中并没有指定内嵌服务器的输出，



在logback-spring.xml文件中可以这样设置，

```


    <logger name="org.eclipse.jetty" level="DEBUG"/>
    
```

但问题又回到了上面，可以成功输出日志，但由于是内嵌服务器，且jetty启动在springboot之前，其线程不受springboot监管，也就是不在我编写java代码管理范围内，最终选择放弃内嵌服务器的日志，一方面是在控制台中输出会很多，另一方面，我的问题是为什么调用了请求，没有在控制台输出日志直接打印了请求方法的内容，这似乎是因为日志记录时间的触发原因的原因？、

当我使用log.info时成功触发了日志记录在控制台输出，

````

@RestController
@Slf4j
public class test {

    @RequestMapping(value = "/hello")
    public  void print(){
        log.info("这是测试");
    }
}
````



扩展：

- `log.info` 是 SLF4J（Simple Logging Facade for Java）接口的一部分，通常配合 Logback 或 Log4j 等日志框架使用。SLF4J 提供了一个抽象层，允许你在不修改代码的情况下切换底层的日志实现。

- 而System.out.println是java原生语法，无条件输出到控制台，

  这也就以为这，System.out.println不会触发日志事件，log.info是日志门面的一部分，其底层实现会触发logback的控制台输出。