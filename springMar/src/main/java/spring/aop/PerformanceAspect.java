package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
	
	//  @Pointcut("execution(public * spring.aop..*sayHello(..))")
	//  private void pointCut() {}
	
	//	@Around("pointCut()")
	//  표현식 그대로 써도됨
	@Around("execution(public * spring.aop..*sayHello(..))")
	public Object timeCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		// getSignature 실행된 method명 호출
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		long startTime = System.nanoTime();
		System.out.println("[LOG]METHOD Before: " + methodName + " time check start ");
		Object obj = null;
		
		try {
			// targetObject 실행, 후처리 전까지 대기
			obj = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println("[LOG]METHOD error: " + methodName);
		}
		
		// proceed()때문에 targetObject 실행후에 실행
		long endTime = System.nanoTime();
		System.out.println("[LOG]METHOD After: " + methodName + " time check end ");
		System.out.println("[LOG] " + methodName + " Processing time is " + (endTime - startTime) + "ns");
		
		return obj;
	}
}
