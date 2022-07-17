package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class logAfterReturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("AfterReturningAdvicer 결과값 : " + returnValue + " method 이름 : " + method.getName());
	}

}
