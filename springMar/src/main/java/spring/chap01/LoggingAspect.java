package spring.chap01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
// Aspect - 공통관심사항
@Component("logging")
@Aspect
public class LoggingAspect {
	@Pointcut("execution(* *..*Service.*(..))")
	private void servicePointcut() {}
	
	// 어떤클래스에 대한 log인지 getClass - spring.chap01.LoggingAspect
	private Log log = LogFactory.getLog(getClass());
	// ProceedingJoinPoint 앞뒤로 logging 처리하기 위해 필요(around)
	
	// @Around("execution(* *..*Service.*(..))")
	@Around("servicePointcut()")
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("기록시작");
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start();
			// 핵심로직 실행후 return값 받아서 저장, return값 없으면 null
			Object retValue = joinPoint.proceed();
			return retValue;
		} catch (Throwable e) {
			throw e;
		} finally {
			stopWatch.stop();
			log.info("기록 종료");
			// method명 출력
			log.info(joinPoint.getSignature().getName() + "실행 시간 : " + stopWatch.getTotalTimeMillis());
		}
	}
}
