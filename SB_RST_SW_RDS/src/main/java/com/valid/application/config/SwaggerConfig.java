package com.valid.application.config;

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
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.valid.application.controller")).paths(PathSelectors.any())
				.build().pathMapping("/").apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("Template SB_RST_SW_RDS")
				.description(
						"This is a template for Kubernetes: Spring Boot, Rest, Swagger with Redis.")
				.version("1.0.0").contact(getContact()).build();

	}

	private Contact getContact() {
		return new Contact("VALID SOLUCOES S/A", "https://www.valid.com", "");
	}

}