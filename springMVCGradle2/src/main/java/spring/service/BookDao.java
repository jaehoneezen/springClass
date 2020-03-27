package spring.service;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.BookDto;
import spring.model.BookSaleDto;

public class BookDao extends SqlSessionDaoSupport {
	public List<BookSaleDto> selectBooksOrderInfo(String bookname) {
		return getSqlSession().selectList("book.selectBooksOrderInfoByBookname", bookname);
	}
	
	public List<BookDto> selectBooksByOrderCustomerName(String cname) {
		return getSqlSession().selectList("book.selectBooksByOrderCustomerName", cname);
	}
}


