    package com.flightbooking;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private CreditCardService creditService= new CreditCardService();
	
//	public String getPersonFullName(){
//		return "Prasad Seemakurthi";
//	}
	
	public Boolean isPersonAcceptable(String userName){
		return creditService.isCreditCardBlanceAvailable(userName);
	}

	
}
