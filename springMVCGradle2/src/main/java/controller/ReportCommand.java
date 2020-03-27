package controller;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ReportCommand {
	private String studentNumber;
	private String fileDest;
	private MultipartFile report;
	
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	public String getFileDest() {
		return fileDest;
	}
	public void setFileDest(String fileDest) {
		this.fileDest = fileDest;
	}
	
	
}
