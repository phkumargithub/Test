package com.springbootcouchbase.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.springbootcouchbase" })
public class SpringBootEmpApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmpApp.class, args);
	}

}
