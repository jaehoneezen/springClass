package download.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import download.model.EmpDto;

public class EmpDao  extends SqlSessionDaoSupport {
	
	public List<EmpDto> selectAll() {
		return getSqlSession().selectList("emp.selectAll");
	}
	
	public String[] selectAllColumnName() {
		List<HashMap> cols = getSqlSession().selectList("emp.selectAllColumnName");
		System.out.println(cols);
		String[] names = new String[cols.size()];
		for (int i = 0; i < names.length; i++) {
			names[i] = (String) cols.get(i).get("COLUMN_NAME");
		}
		return names;
	}

}
