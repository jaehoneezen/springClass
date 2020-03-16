package service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dao.MemberDao;
import data.dto.MemberDto;

@Service
public class InsertService {
	MemberDao memberDao;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public int insertMem(MemberDto mem) {
		return memberDao.insertMember(mem);
	}
}
