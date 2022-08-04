package com.study.spring.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class mvcConf implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable(); // dispatcherServlet
	}
	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.jsp("/WEB-INF/view/" , ".jsp");
//	}
	
}
