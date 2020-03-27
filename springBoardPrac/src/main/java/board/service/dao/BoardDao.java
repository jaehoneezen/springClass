package board.service.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import board.model.command.WriteArticleCommand;
import board.model.dto.BoardDto;

public class BoardDao extends SqlSessionDaoSupport {
	
	public List<BoardDto> selectAll() {
		return getSqlSession().selectList("selectAll");
	}
	
	public BoardDto selectOne(int board_idx) {
		return getSqlSession().selectOne("selectOne", board_idx);
	}
	
	public void updateViewCount(int board_idx) {
		
	}
	
	public int insertArticle(WriteArticleCommand command) {
		return getSqlSession().insert("insertArticle", command);
	}
	
	public int deleteAtricle(int board_idx) {
		return getSqlSession().delete("deleteArticle", board_idx);
	}
	
	

}
