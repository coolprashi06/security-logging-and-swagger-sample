package com.prashast.securityloggingandswaggersample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebSecurity
@EnableSwagger2
public class SecurityLoggingAndSwaggerSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityLoggingAndSwaggerSampleApplication.class, args);
	}

}
