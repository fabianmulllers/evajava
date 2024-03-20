//package com.example.evajava.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spi.DocumentationType;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {    
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//        		.apiInfo(this.usersApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.evajava.controllers"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//    
//    
//	private ApiInfo usersApiInfo() {
//		return new ApiInfoBuilder().title("evaluacion Services")
//								.version("1.0")
//								.license("Apache License Version 2.0")
//								.build();
//	}
//}