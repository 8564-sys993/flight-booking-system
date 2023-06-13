package com.fares;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
//@EnableSwagger2
public class Application {
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	public Docket apis() {
//		return new Docket(DocumentationType.SWAGGER_2) .select()
//                .apis(RequestHandlerSelectors.basePackage("com.fares"))
//                .paths(PathSelectors.any())
//                .build();
//	}
	
	
	
}
