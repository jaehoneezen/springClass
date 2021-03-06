package spring.chap01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
	public static void main(String[] args) {
		// classPath = src 폴더 /main/resources
		Resource resource = new ClassPathResource("applicationContext.xml");
		// BeanFactory : 스프링 컨테이너
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		WriteArticleService articleService = (WriteArticleService) beanFactory.getBean("writeArticleService");
		//articleService.write(new Article());
		
		
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		WriteArticleService articleService2 = context.getBean("writeArticleService2", WriteArticleService.class);
		articleService2.write(new Article());
		
	}
}
