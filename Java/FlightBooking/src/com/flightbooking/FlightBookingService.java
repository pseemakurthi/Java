package com.flightbooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "fb")
public class FlightBookingService {
	@Autowired
	private PersonService personSerivce; //= new PersonService();
	
	@Autowired
	private AirlineService aSerive; // = new AirlineService();
	
	
	
	


	public String bookFlight(String userName, String airlineName){
		//Check User Balance 
		
		if(personSerivce.isPersonAcceptable(userName)){
			String flight  = aSerive.getAvailableFlight(airlineName);
			System.out.println("Now booking the flight for the user  " + userName + " with flight " + flight);
			return "Success";
		}
		return "Failed";
	}
}
