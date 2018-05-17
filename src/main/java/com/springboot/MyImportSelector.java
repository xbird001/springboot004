package com.springboot;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	/**
	 * 可以根据importingClassMetadata里面提供的信息(也就是外层@Enable*注解输入的信息)来逻辑判断是否输出哪些类全名
	 */
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"com.springboot.User","com.springboot.Person"};
	}

}
