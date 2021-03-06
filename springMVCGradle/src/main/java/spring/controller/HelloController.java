package spring.controller;

import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	// handler mapping
	// 404 1. controller mapping이 없는경우, .jsp를 못찾는경우
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		//view name
		mav.setViewName("hello"); 
		// map을 상속받고있음 key, value
		// ("greeting", "점심식사")
		mav.addObject("greeting", getGreeting());
		// dispatcher servlet으로 return
		// dispatcher 는 viewName을 view resolver 구현객체를 찾아서 보냄
		return mav;
	}

	private String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 6 && hour <= 10) {
			return "좋은 아침입니다.";
		} else if (hour >= 12 && hour <= 15) {
			return "점심 식사는 하셨나요?";
		} else if (hour >= 18 && hour <= 22) {
			return "좋은 밤 되세요";
		}
		return "안녕하세요";
	}

}
