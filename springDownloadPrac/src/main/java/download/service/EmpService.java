package download.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import download.model.EmpDto;

@Service
public class EmpService {
	@Autowired
	EmpDao dao;
	
	public void setDao(EmpDao dao) {
		this.dao = dao;
	}
	
	public List<EmpDto> selectAll() {
		return dao.selectAll();
	}
	
	public String[] selectColumnName() {
		return dao.selectAllColumnName();
	}
}
