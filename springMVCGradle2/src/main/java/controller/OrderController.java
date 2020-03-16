package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	// request controller 에서 return 값이 string이면 viewname으로 사용
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "order/orderForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("order") OrderCommand orderCommand) {
		return "order/orderCompletion";
	}
	

}
