package com.study.spring.conf;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"com.study.spring.controller"})
@Import(appConf.class) // Configure 합체!
public class controllerConf implements WebMvcConfigurer{

//	@Bean
//	public HomeController hm() {
//		return new HomeController();
//	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource  messageSource = new ReloadableResourceBundleMessageSource ();
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Override
	public Validator getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
