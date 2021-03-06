package spring.annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("annotationTest.xml");
		Foo f = context.getBean("foo", Foo.class);
		f.doFoo();
		
		// Bar를 container가 다시 bean으로 등록하면서 property를 다시 세팅함
		Bar b = context.getBean("wBar", Bar.class);
		b.doBar();
		// container 강제종료
		context.registerShutdownHook();
	}

}
