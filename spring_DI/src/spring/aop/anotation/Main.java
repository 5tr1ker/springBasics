package spring.aop.anotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.aop.entity.Exam;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Exam exam = ctx.getBean("exam" , Exam.class );
		System.out.println(exam.avg());
	}

}
