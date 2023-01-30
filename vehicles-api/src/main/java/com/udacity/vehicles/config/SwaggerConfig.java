package com.udacity.vehicles.config;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
        "Vehicle REST API",
        "This document lists the available Vehicle REST APIs.",
        "1.0",
        "http://www.udacity.com/tos",
        new Contact("Udacious Student", "www.udacity.com", "myeaddress@udacity.com"),
        "License of API", "http://www.udacity.com/license", Collections.emptyList());
  }
}