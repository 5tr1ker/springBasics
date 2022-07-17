package spring_DI.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring_DI.di.entity.Exam;
import spring_DI.di.entity.NewlecExam;

@ComponentScan("spring_DI.di")
@Configuration
public class NewlecDIConfig {
	
	@Bean
	public Exam exam1() { // ID���� ���� setExam �� ����.
		return new NewlecExam(10,20,30,40);
	}
	
	@Bean(initMethod = "init" , destroyMethod = "dest")
	@Qualifier("Test1")
	public Exam exam2() { // ID���� ���� setExam �� ����.
		return new NewlecExam(50,60,70,80);
	}
}
