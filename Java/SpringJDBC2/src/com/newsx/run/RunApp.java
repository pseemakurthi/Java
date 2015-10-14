package com.newsx.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newsx.Domain.News;
import com.newsx.Domain.newsxconstants.NewsxConstants;
import com.newsx.service.NewService;


public class RunApp {
	public static void main(String []args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		NewService service = (NewService)  ctx.getBean("newsService");
		service.printNews(); 
		
		
		News n = new News(System.currentTimeMillis(),"headLines","mainStory","image.com","video.com",NewsxConstants.ENTERTAINMENT_TYPE);
		
		//service.saveNews(n);
		
		for(News n1 : service.getAllNews()){
			System.out.println(n1);
		}
	}
}
