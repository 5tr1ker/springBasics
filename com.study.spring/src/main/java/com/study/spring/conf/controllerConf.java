package com.study.spring.conf;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.study.spring.controller"})
@Import(appConf.class) // Configure 합체!
public class controllerConf {

//	@Bean
//	public HomeController hm() {
//		return new HomeController();
//	}
}
