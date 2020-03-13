package spring.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionMain {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("DITest.xml");
		CollectionEx col = context.getBean("col", CollectionEx.class);
		//col.doCol();
		System.out.println(col.toString());
	}
}
