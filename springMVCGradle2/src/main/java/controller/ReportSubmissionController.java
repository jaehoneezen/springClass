package controller;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {
	
	@RequestMapping(value="/report/submission.do", method=RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}
	
	@RequestMapping(value="/report/submitReport1.do", method=RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report) {
		printInfo(studentNumber, report);
		return "report/submissionComplete";
	}
	
	
	public void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber + "가 업로드 한 파일: " + report.getOriginalFilename());
	}
	
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) {
			String studentNumber = request.getParameter("studentNumber");
			MultipartFile report = request.getFile("report");
			printInfo(studentNumber, report);
			return "report/submissionComplete";
	}
	
	// 많이 사용하는 패턴
	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand) {
			printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
			return "report/submissionComplete";
	}
	
	@RequestMapping(value = "/report/submitReport4.do", method = RequestMethod.POST)
	public String submitReport4(ReportCommand reportCommand) {
		String fileOriginName = reportCommand.getReport().getOriginalFilename();
		//String fileEx = fileOriginName.substring(fileOriginName.lastIndexOf("."));
		//String fileNewName = System.currentTimeMillis() + ((int) (Math.random() * 10000)) + fileEx;
		//String fileDest = "d:/item/" + fileNewName;
		String fileDest = "d:/item/" + reportCommand.getStudentNumber();
		File folder = new File("d:/item/" + reportCommand.getStudentNumber());
		
		
		if (!folder.exists()) {
			folder.mkdirs();
			System.out.println("학번으로 폴더생성됨");
		} else {
			System.out.println("존재하는 폴더");
		}	
		
		File file = new File(fileDest + "/" + fileOriginName);
		if (!file.exists()) {
			try { 
				  reportCommand.getReport().transferTo(file);
				  System.out.println("파일저장 성공");
			  } catch (Exception e) {
				  System.out.println("파일저장 실패");
				  e.printStackTrace();
			  }
		} else {
			System.out.println("중복파일 있음");
		}
		
		return "report/submissionComplete";
	}
}
