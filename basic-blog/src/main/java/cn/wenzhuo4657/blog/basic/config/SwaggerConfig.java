package cn.wenzhuo4657.blog.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2 //开启swagger功能
public class SwaggerConfig {




    @Bean
    public Docket defaultDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo1())
                .groupName("Intuitive")
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("cn.wenzhuo4657.blog.basic.controller"))
                       .paths(PathSelectors.any()
                       ).build();
    }


    /**
     * 用于定义API主界面的信息，比如可以声明所有的API的总标题、描述、版本
     * @return
     */
    private ApiInfo apiInfo1() {
    
        Contact contact = new Contact(
                "藏剑", // 作者姓名
                "https://github.com/wenzhuo4657", // 作者网址
                "14783149521@163.com"); // 作者邮箱
                
        return new ApiInfoBuilder()
                .title("blog项目API") //  可以用来自定义API的主标题
                .version("1.0") // 可以用来定义版本
                .contact(contact)
                .build();
    }
}
