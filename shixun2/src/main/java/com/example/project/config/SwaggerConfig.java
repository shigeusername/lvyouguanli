package com.example.project.config;

import io.swagger.annotations.Api;
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

import java.security.Timestamp;

/**
 * 通过该配置类实现swaggerg工具的注入
 * 通过一些注解，让类能够被框架管理，被使用
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //扫描
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //过滤
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(Timestamp.class, String.class);

    }

    //基本信息的配置，信息会在api文档上显示
    private ApiInfo apiInfo() {
        Contact contact = new Contact("addd", "http://localhost:8080", "noway");
        return new ApiInfoBuilder()
                .title("addd-group-接口文档")
                .version("1.0")
                .description("addd-接口的文档")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(contact)
                .build();
    }
}
