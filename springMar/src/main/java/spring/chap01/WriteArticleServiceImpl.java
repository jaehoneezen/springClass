package spring.chap01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("writeArticleService")
public class WriteArticleServiceImpl implements WriteArticleService {
	// ArticleDao 구현 객체 받아오겠다?
	// ArticleDao articleDao = new ArticleDao 이런식으로 사용 x, 컨테이너에서 객체 생성
	private ArticleDao articleDao;
	
	// 생성자
	public WriteArticleServiceImpl() {
		System.out.println("기본 WriteArticleServiceImpl 생성자 실행");
	}
	
	// component로 bean객체 생성할때 기본생성자만사용?
	public WriteArticleServiceImpl(ArticleDao articleDao) {
		System.out.println("ArticleDao 받는 WriteArticleServiceImpl 생성자 실행");
		this.articleDao = articleDao;
	}
	
	// MySqlArticleDao 의 bean name은 mysqlArticleDao가 되기때문에 Autowired로 type으로 bean을 찾음
	// @Resource 속성으로 주입하기 위해서는 MySqlArticleDao의 bean name을 @Component("articleDao")로 지정해줘야함
	@Autowired
	public void setArticleDao(ArticleDao articleDao) {
		System.out.println("setArticleDao 실행");
		this.articleDao = articleDao;
	}
	
	
	public void write(Article article) {
		System.out.println("WriteArticleServiceImpl.write() 실행");
		// ArticleDao 에 의존
		articleDao.insert(article);
	}

}
