package org.deep.bitsbytes.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration implements WebMvcConfigurer {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}
