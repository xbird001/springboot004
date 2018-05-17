package com.springboot;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 这个地方采用ImportBeanDefinitionRegistrar进行导入主要是为了能手动的装配bean到spring的容器中，以便能传入相关的参数
 * 而采用ImportSelector进行导入，只是把类全名告诉Spring，然后spring在去装配Bean，那么这个过程我们就不能传入相关的参数
 * @author Administrator
 *
 */
public class MyLogImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	
	private List<String> packages;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//1、获取对应注解上传递过来的包名参数
		Map<String,Object> attriMap = importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName());
		String[] packagesArr = (String[])attriMap.get("packages");
		packages = Arrays.asList(packagesArr);
		
		//2、配置Bean
		BeanDefinitionBuilder sdb = BeanDefinitionBuilder.rootBeanDefinition(MyLogBeanPostProcessor.class);
		sdb.addPropertyValue("packages", packages);
		
		//3、将特定的类动态的托管到Spring容器中
		registry.registerBeanDefinition(MyLogBeanPostProcessor.class.getName(), sdb.getBeanDefinition() );
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

}
