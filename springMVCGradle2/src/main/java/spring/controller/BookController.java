package spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import service.BookService;
import spring.model.BookSaleDto;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value = "/book/bookInfo.do")
	public String bookSearch() throws Exception {
		return "book/bookSearch";
	}
	
	
	@RequestMapping(value = "/book/bookSearch/{type}/{value}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String booksSearch(@PathVariable("type") String searchType, @PathVariable("value") String searchValue) throws Exception {
		List list = null;
		if (searchType.equals("cname")) {
			list = bookService.selectBooksByOrderCustomerName(searchValue);
		} else if (searchType.equals("bname")) {
			list = bookService.selectBooksOrderInfo(searchValue);
		}
		System.out.println(list);
		Gson json = new Gson();
		return json.toJson(list);
	}
}
