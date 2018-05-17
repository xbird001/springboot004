package com.springboot;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyLogBeanPostProcessor implements BeanPostProcessor {
	
	private List<String> packages;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		for(String pac : packages) {
			if(bean.getClass().getName().startsWith(pac)) {
				System.out.println("--------------------------Log Begin---------------------------------------");
				System.out.println("----------------" + bean.getClass().getName() + "----------------");
				System.out.println("--------------------------Log End---------------------------------------");
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
	
	

}
