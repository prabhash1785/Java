package com.prabhash.java.amortization;

import java.util.ArrayList;
import java.util.List;

import com.prabhash.java.amortization.util.Validator;

/**
 * This class implements the AmortizationSchedule Interface.
 *   
 * @author Prabhash Rathore
 *
 */

public class AmortizationScheduleImpl implements AmortizationSchedule {
	
	private LoanInformationDO loanInformationDO; //Request Object
	private AmortizationScheduleDO amortizationScheduleDO; //Response Object
	
	private final double monthlyInterestDivisor = 12d * 100d;
	private double monthlyInterest = 0d;
	private long monthlyPaymentAmount = 0;	// in cents
	
	/** Default constructor needed for future inheritance or, serialization needs */
	public AmortizationScheduleImpl() {
		loanInformationDO = new LoanInformationDO();
		amortizationScheduleDO = new AmortizationScheduleDO();
	}
	
	/**
	 * This method accepts the Loan Request from clients and generate the Amortization table based on the values of Principal Amount, Interest Rate and
	 * Loan Term.
	 * 
	 * Following calculations are done:
	 * 1.      Calculate H = P x J, this is your current monthly interest
	 * 2.      Calculate C = M - H, this is your monthly payment minus your monthly interest, so it is the amount of principal you pay for that month
	 * 3.      Calculate Q = P - C, this is the new balance of your principal of your loan.
	 * 4.      Set P equal to Q and go back to Step 1: You thusly loop around until the value Q (and hence P) goes to zero.
	 * 
	 * @param loan
	 * @return AmortizationScheduleDO
	 * @throws IllegalArgumentException
	 * 	
	 */
	@Override
	public AmortizationScheduleDO getAmortizationSchedule(LoanInformationDO loan) throws IllegalArgumentException {
		
		processRequest(loan); //validate and massage request properties
		
		//List objects which will store the generated monthly amortization values, this will get saved in final response object and sent to the clients
		List<Double> monthlyPaymentAmountList = new ArrayList<Double>();
		List<Double> currentMonthlyInterestList = new ArrayList<Double>();
		List<Double> currentBalanceList = new ArrayList<Double>();
		List<Double> totalAmountPaidList = new ArrayList<Double>();
		List<Double> totalInterestPaidList = new ArrayList<Double>();

		long balance = loanInformationDO.getPrincipal();
		int paymentNumber = 0;
		long totalPayments = 0;
		long totalInterestPaid = 0;

		amortizationScheduleDO.setPaymentNumber(paymentNumber++);
		monthlyPaymentAmountList.add(0d);
		currentMonthlyInterestList.add(0d);
		currentBalanceList.add(loanInformationDO.getPrincipal() / 100d);
		totalAmountPaidList.add(totalPayments / 100d);
		totalInterestPaidList.add(totalInterestPaid / 100d);

		final int maxNumberOfPayments = loanInformationDO.getLoanTerm() + 1;
		while ((balance > 0) && (paymentNumber <= maxNumberOfPayments)) {
			// Calculate H = P x J, this is your current monthly interest
			long curMonthlyInterest = Math.round(((double) balance) * monthlyInterest);

			// the amount required to payoff the loan
			long curPayoffAmount = balance + curMonthlyInterest;

			// the amount to payoff the remaining balance may be less than the calculated monthlyPaymentAmount
			long curMonthlyPaymentAmount = Math.min(monthlyPaymentAmount, curPayoffAmount);

			/** 
			 * it's possible that the calculated monthlyPaymentAmount is 0, or the monthly payment only covers the interest payment - i.e. no principal
			 * so the last payment needs to payoff the loan 
			 */
			if ((paymentNumber == maxNumberOfPayments) &&
					((curMonthlyPaymentAmount == 0) || (curMonthlyPaymentAmount == curMonthlyInterest))) {
				curMonthlyPaymentAmount = curPayoffAmount;
			}

			/**
			 * Calculate C = M - H, this is your monthly payment minus your monthly interest, 
			 * so it is the amount of principal you pay for that month 
			 */
			long curMonthlyPrincipalPaid = curMonthlyPaymentAmount - curMonthlyInterest;

			// Calculate Q = P - C, this is the new balance of your principal of your loan.
			long curBalance = balance - curMonthlyPrincipalPaid;

			totalPayments += curMonthlyPaymentAmount;
			totalInterestPaid += curMonthlyInterest;

			//set the calculated amortized values in the List to be set in final response object
			amortizationScheduleDO.setPaymentNumber(paymentNumber++);
			monthlyPaymentAmountList.add(curMonthlyPaymentAmount / 100d);
			currentMonthlyInterestList.add(curMonthlyInterest / 100d);
			currentBalanceList.add(curBalance / 100d);
			totalAmountPaidList.add(totalPayments / 100d);
			totalInterestPaidList.add(totalInterestPaid / 100d);

			// Set P equal to Q and go back to Step 1: You thusly loop around until the value Q (and hence P) goes to zero.
			balance = curBalance;
		}

		//set all the List Objects to final Amortization Response object to be returned
		amortizationScheduleDO.setMonthlyPaymentAmount(monthlyPaymentAmountList);
		amortizationScheduleDO.setCurrentMonthlyInterest(currentMonthlyInterestList);
		amortizationScheduleDO.setCurrentBalance(currentBalanceList);
		amortizationScheduleDO.setTotalAmountPaid(totalAmountPaidList);
		amortizationScheduleDO.setTotalInterestPaid(totalInterestPaidList);

		return amortizationScheduleDO;
	}
	
	/**
	 * Method to massage the request properties and do validation on monthly payments
	 * 
	 */
	private void processRequest(LoanInformationDO loan) {

		//validate Request
		Validator.validateLoanRequest(loan);

		loanInformationDO.setPrincipal(Math.round(loan.getPrincipal() * 100));
		loanInformationDO.setAnnualInterestRate(loan.getAnnualInterestRate());
		loanInformationDO.setLoanTerm(loan.getLoanTerm() * 12);

		//calculate monthly payment
		monthlyPaymentAmount = calculateMonthlyPayment();

		/** 
		 * the following shouldn't happen with the available valid ranges for borrow amount, apr, and term;
		 * however, without range validation, monthlyPaymentAmount as calculated by calculateMonthlyPayment() may yield 
		 * incorrect values with extreme input values 
		 */
		if (monthlyPaymentAmount > this.loanInformationDO.getPrincipal()) {
			throw new IllegalArgumentException();
		}

	}
	
	/**
	 * Calculate Monthly Payment
	 * 
	 * M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
	 * Where:
	 * P = Principal
	 * I = Interest
	 * J = Monthly Interest in decimal form:  I / (12 * 100)
	 * N = Number of months of loan
	 * M = Monthly Payment Amount
	 *  
	 * @return long
	 */
	private long calculateMonthlyPayment() {
		
		// calculate J
		monthlyInterest = loanInformationDO.getAnnualInterestRate() / monthlyInterestDivisor;
		
		// this is 1 / (1 + J)
		double tmp = Math.pow(1d + monthlyInterest, -1);
		
		// this is Math.pow(1/(1 + J), N)
		tmp = Math.pow(tmp, loanInformationDO.getLoanTerm());
		
		// this is 1 / (1 - (Math.pow(1/(1 + J), N))))
		tmp = Math.pow(1d - tmp, -1);
		
		// M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
		double rc = loanInformationDO.getPrincipal() * monthlyInterest * tmp;
		
		return Math.round(rc);
	}

}

