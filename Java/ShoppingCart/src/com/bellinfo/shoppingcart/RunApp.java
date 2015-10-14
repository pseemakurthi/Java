/**
 * @author pseemakurthi 
 */
package com.bellinfo.shoppingcart;

public class RunApp {
	Person p = new Person();
	CheckingAccount act = new CheckingAccount();
	Iphone phone = new Iphone();
	
	String name = "";
	public String getName(){
		return name;
	}
	
	
	public static void main(String []args) {
		RunApp app = new RunApp();
		app.act.setAccountNumber(12345);
		app.act.setDeposit(10000);
		
		app.p.setName("Prasad");
		app.p.setChkAct(app.act);
		
		/**
		 *  checking if the deposit and transactions are successful
		 */
		boolean deposit = app.p.makeDeposit(10);
		if(deposit){
			System.out.println("Deposit is Successful");
		}else{
			System.out.println("Deposit is failure");
		}
		
		boolean transaction = app.p.makePurchase(Iphone.PRICE);
		if(transaction){
			System.out.println("Transaciton Successful");
		}else{
			System.out.println("transaction failed");
		}
		
	}
}
