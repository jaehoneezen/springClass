package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.BookDto;
import spring.model.BookSaleDto;
import spring.service.BookDao;

@Service
public class BookService {
	@Autowired
	BookDao dao;

	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	
	public List<BookSaleDto> selectBooksOrderInfo(String bookname) {
		bookname = '%' + bookname + '%';
		return dao.selectBooksOrderInfo(bookname);
	}
	
	public List<BookDto> selectBooksByOrderCustomerName(String cname) {
		return dao.selectBooksByOrderCustomerName(cname);
	}
}
