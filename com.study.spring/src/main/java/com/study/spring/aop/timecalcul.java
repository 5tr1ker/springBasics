package com.study.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class timecalcul {
	
	@Pointcut("execution(public * com.study.spring.service..*.*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Object obj = jp.proceed();
			return obj;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.printf("실행 시간 : %sms \n" , finish - start);
		}
		
	}
}
