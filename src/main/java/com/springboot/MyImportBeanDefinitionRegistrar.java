package com.springboot;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,BeanDefinitionRegistry registry) {

		registry.registerBeanDefinition(User.class.getName(), BeanDefinitionBuilder.rootBeanDefinition(User.class).getBeanDefinition());
		
		registry.registerBeanDefinition(Person.class.getName(), BeanDefinitionBuilder.rootBeanDefinition(Person.class).getBeanDefinition());
	}

}
