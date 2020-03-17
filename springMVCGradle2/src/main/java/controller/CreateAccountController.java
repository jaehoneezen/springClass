package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Address;
import spring.model.MemberInfo;
import validator.MemberInfoValidator;

@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {
	
	@ModelAttribute("command")
	public MemberInfo formBacking(HttpServletRequest request) {
		// 요청방식 가져와서 대소문자 무시하고 get방식인지 확인
		if (request.getMethod().equalsIgnoreCase("GET")) {
			MemberInfo mi = new MemberInfo();
			Address address = new Address();
			address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
			mi.setAddress(address);
			return mi;
		} else {
			// post일때 command이름으로 MemberInfo객채 생성
			return new MemberInfo();
		}
	}
	
	private String autoDetectZipcode(String remoteAddr) {
		return "00000";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "account/creationForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	//BindingResult는 사용하려는 파라미터 바로옆에
	public String submit(@ModelAttribute("command") MemberInfo memberInfo, BindingResult result) {
		// memberInfod에 문제가 있으면 result객체에 저장
		new MemberInfoValidator().validata(memberInfo, result);
		if(result.hasErrors() ) {
			return "account/creationForm";
		}
		return "account/created";
	}

}
