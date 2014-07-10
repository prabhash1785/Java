package com.prabhash.java.amortization;

import java.io.Serializable;
import java.util.List;

/**
 * This class comprises the fields needed to display the Amortization Schedule for a Loan. This response object will
 * be sent to any client when they will make a call to Amortization API.
 * 
 * The member fields are of List Data type because they will have multiple list of values added for each monthly payment. Values at each index in the list will
 * represent the Monthly Amortization data for that particular month.
 * 
 * paymentNumber
 * 		type - Integer
 * 		purpose - This will show the payment number starting from 1 to the last payment which will be (Terms * 12)
 * 
 * monthlyPaymentAmount
 * 		type - List<Double>
 * 		purpose - Monthly Payment Amount or installment which needs to be paid
 * 				  This amount includes the money paid towards principal + the interest paid on principal
 * 
 * currentMonthlyInterest
 * 		type - List<Double>
 * 		purpose - Interest Amount paid as part of the monthly payments
 * 
 * currentBalance
 * 		type - List<Double>
 * 		purpose - Remaining Principal amount which needs to be paid. This doesn't include the interest amount. 
 * 
 * totalAmountPaid
 * 		type - List<Double>
 * 		purpose - Total amount paid so far including the interest.
 * 
 * totalInterestPaid
 * 		type - List<Double>
 * 		purpose - Total interest amount paid so far.
 * 
 * @author Prabhash Rathore
 *
 */

public class AmortizationScheduleDO implements Serializable {
	
	private static final long serialVersionUID = -6832055544079452151L;
	
	private Integer paymentNumber;
	private List<Double> monthlyPaymentAmount;
	private List<Double> currentMonthlyInterest;
	private List<Double> currentBalance;
	private List<Double> totalAmountPaid;
	private List<Double> totalInterestPaid;
	/**
	 * @return the paymentNumber
	 */
	public Integer getPaymentNumber() {
		return paymentNumber;
	}
	/**
	 * @param paymentNumber the paymentNumber to set
	 */
	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	/**
	 * @return the monthlyPaymentAmount
	 */
	public List<Double> getMonthlyPaymentAmount() {
		return monthlyPaymentAmount;
	}
	/**
	 * @param monthlyPaymentAmount the monthlyPaymentAmount to set
	 */
	public void setMonthlyPaymentAmount(List<Double> monthlyPaymentAmount) {
		this.monthlyPaymentAmount = monthlyPaymentAmount;
	}
	/**
	 * @return the currentMonthlyInterest
	 */
	public List<Double> getCurrentMonthlyInterest() {
		return currentMonthlyInterest;
	}
	/**
	 * @param currentMonthlyInterest the currentMonthlyInterest to set
	 */
	public void setCurrentMonthlyInterest(List<Double> currentMonthlyInterest) {
		this.currentMonthlyInterest = currentMonthlyInterest;
	}
	/**
	 * @return the currentBalance
	 */
	public List<Double> getCurrentBalance() {
		return currentBalance;
	}
	/**
	 * @param currentBalance the currentBalance to set
	 */
	public void setCurrentBalance(List<Double> currentBalance) {
		this.currentBalance = currentBalance;
	}
	/**
	 * @return the totalAmountPaid
	 */
	public List<Double> getTotalAmountPaid() {
		return totalAmountPaid;
	}
	/**
	 * @param totalAmountPaid the totalAmountPaid to set
	 */
	public void setTotalAmountPaid(List<Double> totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
	/**
	 * @return the totalInterestPaid
	 */
	public List<Double> getTotalInterestPaid() {
		return totalInterestPaid;
	}
	/**
	 * @param totalInterestPaid the totalInterestPaid to set
	 */
	public void setTotalInterestPaid(List<Double> totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}	

}
