package download.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import download.model.EmpDto;

@Component
public class EmpView extends AbstractXlsView {
	
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("Content-Disposition", "attachment; filename=\"emps.xls\";");
		Sheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet, model);
		
		List<EmpDto> emps = (List<EmpDto>) model.get("emps");
		int rowNum = 1;
		for (EmpDto emp : emps) {
			createEmpRow(sheet, emp, rowNum++);
		}
		
	}
	
	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "emps");
		sheet.setColumnWidth(1, 256 * 20);
		
		return sheet;
	}
	
	private void createColumnLabel(Sheet sheet, Map<String, Object> model) {
		//String[] empColname = {"empno", "ename", "job", "mgr", "hiredata", "sal", "comm", "deptno"};
		String[] empColname = (String[]) model.get("cols");
		
		Row firstRow = sheet.createRow(0);
		Cell cell = null;
		
		for (int i = 0; i < empColname.length; i++) {
			cell = firstRow.createCell(i);
			cell.setCellValue(empColname[i]);
		}
	}
	
	private void createEmpRow(Sheet sheet, EmpDto emp, int rowNum) {
		Row row = sheet.createRow(rowNum);
		Cell cell = null;
		
		cell = row.createCell(0);
		cell.setCellValue(emp.getEmpno());
		
		cell = row.createCell(1);
		cell.setCellValue(emp.getEname());
		
		cell = row.createCell(2);
		cell.setCellValue(emp.getJob());
		
		cell = row.createCell(3);
		cell.setCellValue(emp.getMgr());
		
		cell = row.createCell(4);
		cell.setCellValue(emp.getHiredate());
		
		cell = row.createCell(5);
		cell.setCellValue(emp.getSal());
		
		cell = row.createCell(6);
		cell.setCellValue(emp.getComm());
		
		cell = row.createCell(7);
		cell.setCellValue(emp.getDeptno());
	}
}
