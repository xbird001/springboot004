package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 返回类全名，然后由Spring自动装配，无法介入装配Bean的过程
 * @author Administrator
 *
 */
@Import(value={MyImportSelector.class})//代替@Import(value={User.class,Person.class,BeanConfig.class})进行使用
public class App2 {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App2.class, args);
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
