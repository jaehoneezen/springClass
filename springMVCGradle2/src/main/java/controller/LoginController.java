package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.AuthenticationException;
import service.Authenticator;
import service.LoginCommand;
import validator.LoginCommandValidator;

@Controller
@RequestMapping("login/login.do")
public class LoginController {
	
	private String formViewName = "login/form";
	
	private Authenticator authenticator;
	
	@Autowired 
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
	
	// 컨트롤러 요청이 들어오면 가장 처음
	// 매개변수는 WebDataBinder 고정, Validator지정
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	
	
	// 별도로 이름지정하지 않으면 type으로 이름지정 - loginCommand
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	// LoginCommand를 위에서 ModelAttribute로 생성 했기때문에 가져다쓴다.
	// model 객체를 매개변수로 만들때 같은이름으로 model 데이터가 있으면 가져다쓰고 없으면 생성
	@RequestMapping(method = RequestMethod.POST)
	// @Valid annotation 사용시 기본으로 설정한 validator 사용
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {
		if (result.hasErrors()) return formViewName; 
		
		try {
			// id pass 비교
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		} catch (AuthenticationException e) {
			// BindingResult reject() - global error추가
			// reject(errorcode, string[], default)
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId()}, null);
			return formViewName;
		}
	}
}
