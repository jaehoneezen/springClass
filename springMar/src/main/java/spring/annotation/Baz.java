package spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
// @Configuration 없어도 @Bean이 실행되긴하는데 짝처럼 그냥씀?
@Configuration
public class Baz {
	String name;

	@Value("winter")
	public void setName(String name) {
		System.out.println("Baz setName() ::" + name);
		this.name = name;
	}
	
	
	// wBar를 name 으로 갖는 bean 생성
	@Bean(name="wBar")
	public Bar getBar () {
		Bar b = new Bar();
		b.setName(name);
		System.out.println(b.getName());
		return b;
	}

}
