/**
 * @author pseemakurthi
 * I'm using my own business logic and it can be customized per your need
 */
/**
 * @author pseemakurthi
 */
package com.bellinfo.shoppingcart;

public class CheckingAccount {

	private int accountNumber;
	private double balance = 0;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setDeposit(double balance) {
		this.balance = balance;
	}
	
	/**
	 * 
	 * @param depositAmount
	 * @return
	 * 
	 * return true if the balance >0 after deposit else returns false
	 * 
	 */

	public boolean makeDeposit(int depositAmount){
		balance =depositAmount+ getBalance();
		System.out.println("Balance after deposit : " + getBalance());
		if(getBalance() > 0)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param amount
	 * @return boolean
	 * checks the balance and if balance is greater than price makes the transactions and deducts the cost from
	 * balance and returns true else returns false
	 */
	public boolean makePurchase(int price){
		if(balance >= price){
			balance -= price;
			System.out.println("Balance available after transaction  : " +getBalance());
			return true;
		}
		return false;
	}
}
