package com.study.spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.study.spring.aop.timecalcul;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.study.spring.service" , "com.study.spring.base"})
public class appConf {
	@Bean
	public timecalcul tm() {
		return new timecalcul();
	}
//	@Bean
//	public mainService newInsert() {
//		return new mainService();
//	}
}
