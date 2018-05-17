package com.springboot;

import org.springframework.context.annotation.Bean;

/**
 * 通过@Import进行装配
 * @author Administrator
 *
 */
public class BeanConfig {
	
	@Bean
	public Runnable createBean1() {
		return () -> {};
	}
	
	@Bean
	public Runnable createBean2() {
		return () -> {};
	}

}
