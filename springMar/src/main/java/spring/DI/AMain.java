package spring.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("A.xml");
		A a1 = context.getBean("a", A.class);
		A a2 = context.getBean("a2", A.class);
		A a3 = context.getBean("a3", A.class);
		
		a1.doA();
		a2.doA();
		a3.doA();
	}

}
