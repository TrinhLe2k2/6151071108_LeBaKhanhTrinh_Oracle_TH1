package com.example.webrestapi.configuration;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket myApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.example.webrestapi"))
                .paths(regex("/rest.*"))
                .build()
                .apiInfo(apiEndPointInfo());
    }
    private ApiInfo apiEndPointInfo(){
        return new ApiInfoBuilder().title("SPRING BOOT + REST + JPA DATA + JACKSON")
                .description("Thuc Hanh Buoi 5 Rest Api")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();

    }
}
