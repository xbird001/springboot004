package com.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/*@Component*/
@ConfigurationProperties(prefix="tomcat")//要想把配置文件的属性绑定到这个类的属性里面，必须配合使用注解@EnableConfigurationProperties，否则不能将属性绑定进去
public class TomcatConfig {
	
	private String ip;
	
	private String port;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "TomcatConfig [ip=" + ip + ", port=" + port + "]";
	}
	

}
