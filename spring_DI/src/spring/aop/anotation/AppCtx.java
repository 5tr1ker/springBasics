package spring.aop.anotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;

@Configuration
@EnableAspectJAutoProxy // AOP를 적용하기위해 @Bean 중에서 @Aspect 를 탐색한다.
public class AppCtx {

	@Bean
	public ExeTimeCalculator exeTimeCalculator() {
		return new ExeTimeCalculator();
	}
	
	@Bean
	public Exam exam() {
		return new NewlecExam(20,30,40,50);
	}

}
