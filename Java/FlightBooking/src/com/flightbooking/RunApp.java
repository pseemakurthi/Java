package com.flightbooking;

import java.security.Provider.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunApp {
//	private FlightBookingService service = new FlightBookingService();
	
	public static void main(String... args){
//		RunApp application = new RunApp();
//		application.service.bookFlight("Prasad", "United");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); //initilizing spring
		
		FlightBookingService service = (FlightBookingService) context.getBean("flightBookingService");
		service.bookFlight("prasad", "UNITED");
	}
}
