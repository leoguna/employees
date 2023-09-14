package com.javatpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Component
@EntityScan("com.javatpoint.model")
public class SpringBootCrudOperationApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);
	}
}
