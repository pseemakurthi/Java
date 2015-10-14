package com.spring.jdbc;

import javax.xml.crypto.Data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Runapp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		DataService data = (DataService) context.getBean("dataService");
		data.printNews();
		
	}

}
