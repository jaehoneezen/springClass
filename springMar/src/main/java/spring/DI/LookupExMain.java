package spring.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LookupExMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("DITest.xml");
		LookupEx l = context.getBean("lookupEx", LookupEx.class);
		l.doLookupEx();
	}
}
