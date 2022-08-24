package noticeboard.preferences;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeStamp {
	
	@Pointcut("execution(* noticeboard.dwaa2..*.*(..))")
	public void pointcut() {}
	
	@Around("pointcut()")
	public void around(ProceedingJoinPoint jp) {
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		
		System.out.println("---------TimeStamp--------");
		long beforeTime = System.currentTimeMillis();
		
		try {
			jp.proceed();
		} catch( Throwable e ) {
			System.out.println("TimeStamp Error : " + e);
			e.printStackTrace();
		} finally {
			long afterTime = System.currentTimeMillis();
			System.out.println("_______________________________________________________\n");
			System.out.println("대상 클래스 : " + className + " \n대상 메소드 : " + methodName + " \n측정 시간 : " + (afterTime - beforeTime) + "ms");
			System.out.println("_______________________________________________________");
		}
	}
}
