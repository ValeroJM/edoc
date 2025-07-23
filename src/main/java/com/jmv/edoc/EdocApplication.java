package com.jmv.edoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jmv.edoc")
public class EdocApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdocApplication.class, args);
	}

}
