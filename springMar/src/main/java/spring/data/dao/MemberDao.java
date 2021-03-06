package spring.data.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.data.dto.MemberDto;

public class MemberDao extends SqlSessionDaoSupport {
	/*
	 * SqlSession session;
	 * 
	 * public void setSession(SqlSession session) { this.session = session; }
	 */
	
	public List<MemberDto> getAll() {
		// getSqlSession() - SqlSessionDaoSupport 에서 상속받음
		List<MemberDto> all = getSqlSession().selectList("member.selectAll");
		return all;
	}
	
	public MemberDto getOne(String id) {
		MemberDto m = getSqlSession().selectOne("member.selectOneById", id);
		return m;
	}
	
	public int updateMember(Map m) {
		int ret = getSqlSession().update("member.updateMemberName", m);
		return ret;
	}
	
	public int insertMember(MemberDto m) {
		int ret = getSqlSession().insert("member.insertMember", m);
		return ret;
	}
	
	public int deleteMember(String id) {
		int ret = getSqlSession().delete("member.deleteMember", id);
		return ret;
	}
	
	
}
