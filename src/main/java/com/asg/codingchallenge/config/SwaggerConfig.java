package com.asg.codingchallenge.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.asg.codingchallenge"))
          .build()
          .apiInfo(getApiInfo());
    }

	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"Telecom Phone API",
				"API details for phone related operations",
				"1.0",
				"Test use only",
				null,
				"Unlicensed",
				"",
				Collections.emptyList());
	}

}