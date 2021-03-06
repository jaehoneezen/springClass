package spring.chap01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnoMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("annoApplicationContext.xml");
		WriteArticleService articleService = context.getBean("writeArticleService", WriteArticleService.class);
		articleService.write(new Article());
	}
}
