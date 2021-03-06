package spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Foo {
	
	Bar bar;
	
	// @Autowired
	// @Qualifier("second")
	// xml에서 Bar 생성하는 bean의 id가 같아야 사용가능?, @Resource annotation에 name 설정가능
	@Resource	
	public void setBar(Bar bar) {
		System.out.println("Foo Setter");
		this.bar = bar;
	}
	
	public void doFoo() {
		bar.doBar();
	}
	
	// 초기화시 실행 annotation
	@PostConstruct
	public void start() {
		System.out.println("foo 초기화");
	}
	
	// 소멸시 실행 annotation
	@PreDestroy
	public void stop() {
		System.out.println("foo 소멸");
	}

}
