package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.service.ArticleService;
import spring.service.NewArticleCommand;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	@Autowired
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// @RequestMapping 메서드의 리턴 타입이 String => return값을 viewname으로 사용
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "article/newArticleForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	// client request post 요청 
	// dispatcher servlet 에서 mapping되어있는 method를 찾고 해당 method 매개변수로 있는 type의 class를 찾는다
	// 2. requestMapping 은 해당 매개변수class의 변수와 parameter 이름이 같으면 setter 찾아서 set
	
	// return 하는 string 은 viewname , model은 map<"command", command객체>  ModelAndView 객체 다시 dispatcher로 전달
	// 1. 파라미터 == 변수명 이면 set, 2. get mapping, 3. model 데이터 추가/ 이름을 지정 안하면 type의 첫글자만 소문자로변경한 이름으로 전달
	// @ModelAttribute는 model데이터 이름만 변경해준다
	public String submit(NewArticleCommand command, @ModelAttribute("command2") NewArticleCommand command2) {
		articleService.writeArticle(command);
		articleService.writeArticle(command2);
		return "article/newArticleSubmit";
	}
	

}
