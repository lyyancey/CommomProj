package com.yancey.mall2.config;

import io.swagger.annotations.ApiOperation;
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

/**
 * @ClassName Swagger2Config
 * @Description TODO
 * @Author Yancey
 * @Date 2022/6/7 9:59
 * @Version 1.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // create api document for all controller
                .apis(RequestHandlerSelectors.basePackage("com.yancey.mall2.controller"))
                // create api document for Controller which have @Api annotation
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                // create api document for method which have @ApiOperation annotation
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI API")
                .description("mall")
                .contact(new Contact("Yancey", "", ""))
                .version("1.0")
                .build();
    }
}
