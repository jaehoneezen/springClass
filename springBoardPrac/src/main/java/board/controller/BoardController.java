package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.command.WriteArticleCommand;
import board.model.dto.BoardDto;
import board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/board/list")
	public ModelAndView getArticleList() {
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDto> articles = boardService.selectAll();
		mav.addObject("articles", articles);
		return mav;
	}

	@RequestMapping("/board/read")
	public ModelAndView readArticle(int no) {
		ModelAndView mav = new ModelAndView("board/read");
		BoardDto article = boardService.selectOne(no);
		mav.addObject("article", article);
		return mav;
	}

	
	
	@ModelAttribute("article")
	public WriteArticleCommand articleCommand() {
		return new WriteArticleCommand();
	}
	
	@RequestMapping(path = "/board/write", method = RequestMethod.GET)
	public ModelAndView writeArticle(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("board/write");
		return mav;
	}

	@RequestMapping(path = "/board/write", method = RequestMethod.POST)
	public String writeArticle(HttpServletResponse response, HttpSession session, WriteArticleCommand article) throws IOException {
		// session.id 로 꺼내오면됨
		article.setId("ljh");
		System.out.println(article);
		try {
			boardService.insertArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list";
	}
	
	@RequestMapping(path = "/board/update", method = RequestMethod.GET)
	public ModelAndView updateForm() {
		ModelAndView mav = new ModelAndView("board/write");
		WriteArticleCommand article = new WriteArticleCommand();
		mav.addObject("article", article);
		return mav;
	}
	
	@RequestMapping(path = "/board/update", method = RequestMethod.POST)
	public String updateArticle() {
		return "a";
	}
	
	@RequestMapping("/board/delete")
	public String deleteArticle(int no, HttpSession session) {
		// id 동일한지 검사
		// int id = (int) session.getAttribute("id");
		
		boardService.deleteArticle(no);
		return "redirect:/board/list";
	}
}
