package download.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import download.model.EmpDto;
import download.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	@RequestMapping("/selectEmpAll")
	public ModelAndView selectAllEmp() {
		List<EmpDto> emps = empService.selectAll();
		String[] cols = empService.selectColumnName();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("empView");
		mav.addObject("emps", emps);
		mav.addObject("cols", cols);
		
		return mav;
	}

}
