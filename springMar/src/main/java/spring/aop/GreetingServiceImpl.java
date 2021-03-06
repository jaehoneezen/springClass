package spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// targetObejct(핵심로직)
@Component("greetingTarget")
public class GreetingServiceImpl implements GreetingService {
	private String greeting;
	
	public GreetingServiceImpl() {}
	
	@Value("hello")
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public void sayHello(String name) {
		System.out.println("sayHello :: " + greeting  + " :: " + name);
	}
	
	@Override
	public void sayGoodBye(String name) throws Exception {
		System.out.println("sayGoodBye :: " + greeting  + " :: " + name);
		
		throw new Exception("강제 예외 발생");
	}

}
