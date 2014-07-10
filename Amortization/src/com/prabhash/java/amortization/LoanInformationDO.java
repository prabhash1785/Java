package com.prabhash.java.amortization;

import java.io.Serializable;

/**
 * This class has all the attributes needed to calculate the Amortization schedule for a Loan.
 * 
 * principal
 * 		type - long
 * 		purpose - This is the Loan Amount taken from a Bank.
 * 
 * annualInterestRate
 * 		type - double
 * 		purpose - this will hold the value of Annual Interest Rate.
 * 
 * loanTerm
 * 		type - int
 * 		purpose - time period in years for which the loan is taken
 * 
 * @author Prabhash Rathore
 *
 */

public class LoanInformationDO implements Serializable {
	
	private static final long serialVersionUID = 6707074216470724875L;
	
	private long principal;
	private double annualInterestRate;
	private int loanTerm;
	/**
	 * @return the principal
	 */
	public long getPrincipal() {
		return principal;
	}
	/**
	 * @param principal the principal to set
	 */
	public void setPrincipal(long principal) {
		this.principal = principal;
	}
	/**
	 * @return the annualInterestRate
	 */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	/**
	 * @param annualInterestRate the annualInterestRate to set
	 */
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	/**
	 * @return the loanTerm
	 */
	public int getLoanTerm() {
		return loanTerm;
	}
	/**
	 * @param loanTerm the loanTerm to set
	 */
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}	

}
