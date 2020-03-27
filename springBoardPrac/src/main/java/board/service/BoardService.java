package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.model.command.WriteArticleCommand;
import board.model.dto.BoardDto;
import board.service.dao.BoardDao;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	public List<BoardDto> selectAll() {
		return dao.selectAll();
	}
	
	public BoardDto selectOne(int board_idx) {
		return dao.selectOne(board_idx);
	}
	
	public int insertArticle(WriteArticleCommand article) {
		return dao.insertArticle(article);
	}
	
	public int deleteArticle(int board_idx) {
		return dao.deleteAtricle(board_idx);
	}
}
