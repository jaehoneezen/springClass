package spring.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain {
	public static void main(String[] args) {
		// ApplicationContext 종료기능이 없음
		//ApplicationContext container = new GenericXmlApplicationContext("DITest.xml");
		
		// getBean은 object type으로 꺼내오기때문에 casting 해줘야함  getBean(bean, bean.class) bean.class로 캐스팅해서 꺼내온다
		//Foo f = container.getBean("foo", Foo.class);
		//f.doFoo();
		
		//Foo f2 = container.getBean("foo2", Foo.class);
		//f2.doFoo2();
		
		//Foo fs = container.getBean("fooS", Foo.class);
		//fs.doFoo();
		//fs.doFoo2();
		
		//Foo f3 = container.getBean("foo3", Foo.class);
		
		//Foo fa = container.getBean("fooAuto", Foo.class);
		
		// 종료기능 있는 컨테이너
		AbstractApplicationContext abContainer = new GenericXmlApplicationContext("DITest.xml");
		Foo fa2 = abContainer.getBean("fooAuto", Foo.class);
		
		// 컨테이너 강제 종료
		abContainer.registerShutdownHook();
		//fa.doFoo();
		
	}
}

