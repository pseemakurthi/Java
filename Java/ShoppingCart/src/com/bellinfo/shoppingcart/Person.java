/**
 * @author pseemakurthi
 */
package com.bellinfo.shoppingcart;

public class Person {
	private String name;
	private CheckingAccount chkAct;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CheckingAccount getChkAct() {
		return chkAct;
	}
	public void setChkAct(CheckingAccount chkAct) {
		this.chkAct = chkAct;
	}
	
	/**
	 * 
	 * @param price
	 * @return boolean
	 * calling the methods in the Checking account class
	 */
	public boolean makePurchase(int price){
		return chkAct.makePurchase(price);
	}
	
	public boolean makeDeposit(int amount){
		return chkAct.makeDeposit(amount);
	}
}
