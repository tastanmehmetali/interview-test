package com.travix.medusa.busyflights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * This class is responsible for configuring the Swagger API
 * </p>
 * 
 * @author Mehmet Ali Tastan
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * to visit all path for given base package
	 * 
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.travix.medusa.busyflights")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Travix Flight API", "This is a project skeleton for the Travix Medusa team interview test. BusyFlights is a flights search solution which aggregates flight results initially from 2 different suppliers (CrazyAir and ToughJet).", "version-0.0.1", "Terms of service",
				new Contact("Mehmet Ali TAŞTAN", "API Descriptions", "tastan.mehmetali@gmail.com"), "License of API",
				null);
	}
}
