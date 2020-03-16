package data.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import data.dto.MemberDto;

public class MemberDao extends SqlSessionDaoSupport {
	public int insertMember(MemberDto mem) {
		int res = 0;
		try {
			res = getSqlSession().insert("member.insertMember", mem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
