package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableLog(packages={"com.springboot.domain","com.springboot.service"})
public class App4 {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App4.class, args);
		for(int i=0; i<2; i++) {
			System.out.println();
		}

		
		for(int i=0; i<2; i++) {
			System.out.println();
		}
		
		context.close();
	}
}
