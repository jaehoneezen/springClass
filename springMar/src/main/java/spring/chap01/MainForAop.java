package spring.chap01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainForAop {
	public static void main(String[] args) {
		// String[] configLocations = new String[] {"applicationContext.xml", "commonConcern.xml"};
		String[] configLocations = new String[] {"annoApplicationContext.xml", "commonAnnoConcern.xml"};
		// 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext(configLocations);
		WriteArticleService articleService = (WriteArticleService) context.getBean("writeArticleService");
		articleService.write(new Article());
	}

}
