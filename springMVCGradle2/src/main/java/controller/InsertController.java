package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.dto.MemberDto;
import service.InsertService;

@Controller
@RequestMapping("/insert.do")
public class InsertController {
	@Autowired
	private InsertService insertService;
	
	public void setInsertService (InsertService inserService) {
		this.insertService = insertService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String insertForm() {
		return "insert/insertForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(MemberDto mem) {
		int i = insertService.insertMem(mem);
		ModelAndView mav = new ModelAndView();
		mav.addObject("i", i);
		mav.setViewName("insert/insertResult");
		return mav;
	}
	
}
