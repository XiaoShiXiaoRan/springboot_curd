package com.example.springboot_curd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile({"dev"})
public class SwaggerConfig  {

    @Bean
    public Docket createRestApi() {

        return (new Docket(DocumentationType.SWAGGER_2)).pathMapping("/").
                select().apis(RequestHandlerSelectors.basePackage("com.example.springboot_curd")).
                paths(PathSelectors.any()).build()
                .apiInfo((new ApiInfoBuilder()).title("增删查改接口文档").description("详细信息").version("1.0").build());
    }

}