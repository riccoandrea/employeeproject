package com.employee;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.models.Contact;

@SpringBootApplication
@EnableSwagger2
public class EmployeeApplication{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration(){
	   return new Docket(DocumentationType.SWAGGER_2)
	         .select()
	         .apis(RequestHandlerSelectors.basePackage("com.employee"))
	         .paths(PathSelectors.any())
	         .build()
	         .apiInfo(this.apiInfo())
	         .useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
	   ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
	   apiInfoBuilder.title("Employee Management");
	   apiInfoBuilder.description("API to manage employeest");
	   apiInfoBuilder.contact("Andrea Ricco");
	   apiInfoBuilder.version("1.0.0");
	   apiInfoBuilder.license("GNU GENERAL PUBLIC LICENSE, Version 3");
	   apiInfoBuilder.licenseUrl("https://www.gnu.org/licenses/gpl-3.0.en.html");
	   return apiInfoBuilder.build();
	}
	
}
