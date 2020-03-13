package spring.chap01;

import org.springframework.stereotype.Component;

@Component
public class MySQLArticleDao implements ArticleDao {
	public void insert(Article article) {
		System.out.print("MySQLArticleDao.insert() 실행");
	}
}
