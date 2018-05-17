package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 注解@EnableConfigurationProperties的作用是启用了 一个可以把配置文件的属性装配到Bean对象属性中的  特性
 * @EnableConfigurationProperties 需要配合@ConfigurationProperties一起使用
 * @author Administrator
 *
 */
/*@SpringBootApplication*/
@ComponentScan
//@EnableAutoConfiguration实际上起作用的是@EnableConfigurationProperties这个注解
@EnableConfigurationProperties(value={TomcatConfig.class})
@Import(value={User.class,Person.class,BeanConfig.class})
public class App {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		for(int i=0; i<2; i++) {
			System.out.println();
		}

		System.out.println(context.getBean(TomcatConfig.class));
		System.out.println(context.getBean(User.class));
		System.out.println(context.getBean(Person.class));
		System.out.println(context.getBeansOfType(Runnable.class));
		
		for(int i=0; i<2; i++) {
			System.out.println();
		}
		
		context.close();
	}

}
