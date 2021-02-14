package com.minila.miniapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.minila")
public class MiniapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniapiApplication.class, args);
	}

}
