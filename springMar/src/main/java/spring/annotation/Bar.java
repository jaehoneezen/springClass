package spring.annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bar {
	String name;
	SubBar subBar;
	
	
	//@Required
	//@Value("fall")
	public void setName(String name) {
		System.out.println("Bar setName() ::" + name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//?
	public void setSubBar(SubBar subBar) {
		this.subBar = subBar;
	}
	
	public void doBar() {
		System.out.println("Bar name :: " + name);
	}

}
