package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) { 
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aopAnnoConfig.xml");
		//ApplicationContext ctx = new GenericXmlApplicationContext("aopAnnoConfig.xml");
		GreetingService g = ctx.getBean("greetingTarget", GreetingService.class);
		g.sayHello("ezen");
		
		try {
			g.sayGoodBye("ezen");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
