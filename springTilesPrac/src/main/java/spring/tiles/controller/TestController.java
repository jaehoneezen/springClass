package spring.tiles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RequestMapping("/hello.do")
public class TestController {	
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		System.out.println("==================hello==================");
		return "hello";
	}

}
