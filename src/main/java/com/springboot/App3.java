package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 手动装配Bean，然后托管给Spring容器，因为手动装配Bean，所以可以操作整个装配的过程
 * @author Administrator
 *
 */
@ComponentScan
@Import(value={MyImportBeanDefinitionRegistrar.class})
public class App3 {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App3.class, args);
		for(int i=0; i<2; i++) {
			System.out.println();
		}
		
		System.out.println(context.getBean(User.class));
		System.out.println(context.getBean(Person.class));
		
		for(int i=0; i<2; i++) {
			System.out.println();
		}
		
		context.close();
	}
}
