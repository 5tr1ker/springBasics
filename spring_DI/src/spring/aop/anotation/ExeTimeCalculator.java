package spring.aop.anotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeCalculator {

	//@Pointcut("execution(public * spring.aop.entity..*(..))") // 해당 기능을 적용할 대상
	@Pointcut("execution(public float spring.aop.entity..avg())")
	//@Pointcut("execution(public * spring.aop.advice..*(..))")
	//@Pointcut("execution(public void a())")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()") // Around Advice로 지정 , 주 업무는 publicTarget() 이 된다.
	public Object measure(ProceedingJoinPoint joinpoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinpoint.proceed(); // 주 업무를 실행한다.
			return result;
		} finally {
			long finish = System.nanoTime();
			// Signature sig = (Signature) joinpoint.getSignature();
			System.out.print("실행시간 : " + (finish - start) + "\n");
		}
	}

}
