package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class logAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed(); // 주 업무 추출
		
		long end = System.currentTimeMillis();
		String message = (end - start) + "시간만큼 걸렸습니다.";
		System.out.println(message);
		return result;
	}

}
