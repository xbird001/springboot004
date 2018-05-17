1、Enable*注解的使用原理
	1.1、@Import注解的使用：可以动态的把一个bean对象装配到spring的容器中去
	1.2、1.1可以注入对象、配置对象、实现了ImportSelector接口的实现类、实现了ImportBeanDefinitionRegistrar接口的实现类
	1.3、@Enable*可以借助@Import注解的作用，可以动态的将一些具有 特殊功能 的类注册到spring容器中(比如实现某接口，然后就具
			备钩子函数，spring容器会回调)，那么注册进去之后，就可以行驶个数的功能（比如事务功能），言外之意就是具备了某种功能，
			比如@EnableTransactionManagement，就是具备了事务功能，
	
2、ImportSelector接口和ImportBeanDefinitionRegistrar接口实现类的区别
	2.1、ImportSelector接口的实现类时通过返回 类全名 给spring，然后让spring容器自动装配,无法对装配的Bean进行属性赋值
	2.2、ImportBeanDefinitionRegistrar接口的实现类是通过BeanDefinitionRegistry手动装配Bean到spring容器中
		那么在手动装配的过程中，我们就可以给这个装配的bean进行属性赋值，既然可以属性赋值，就可以接受参数，可以通过@Enable*
		注解接受参数，然后配合@Import注解动态的装配Bean到Spring的容器中，因为ImportBeanDefinitionRegistrar可以手动装配，
		所以我们可以在手动装配的过程中将@Enable*属性获取的属性传递给ImportBeanDefinitionRegistrar接口的实现类，然后再装配
		Bean的时候，将这个传递过来的属性传递给这个装配的Bean
	
3、给定需求如下：自定义一个@Enable注解，使给定的包名下的所有类都能有日志输出
	具体参见App4.class的使用，例子可以参见：com.springboot.EnableLog.class
	
4、@EnableConfigurationProperties注解有两个作用
	4.1、动态的将注解了@ConfigurationProperties的类注册到spring的容器中，E.G：@EnableConfigurationProperties(value={TomcatConfig.class})，
		此时的TomcatConfig.class类上面没有用@Component进行注解，只用了@ConfigurationProperties这个注解
	4.2、支持将配置文件中的属性绑定到注解了@ConfigurationProperties的类的属性中
	4.3、注解@EnableAutoConfiguration也有@EnableConfigurationProperties注解的作用，但是不限于此作用