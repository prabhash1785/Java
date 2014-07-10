package com.prabhash.java.amortization;

import java.io.IOException;

import com.prabhash.java.amortization.util.Helper;
import com.prabhash.java.amortization.util.Validator;

/**
 * This is the client which will accept input from end user for calculating the Amortization Schedule. To calculate
 * the Amortization Schedule, it will use interface AmortizationSchedule.
 * 
 * @author Prabhash Rathore
 *
 */

public class AmortizationClient {
	
	public static void main(String[] args) {
		
		String[] userPrompts = {
				"Please enter the amount you would like to borrow: ",
				"Please enter the annual percentage rate used to repay the loan: ",
				"Please enter the term, in years, over which the loan is repaid: "
		};
		
		String line = "";
		
		double amount = 0; //Principal
		double apr = 0; //Annual Rate
		int years = 0; //Loan Term
		
		//Prompt user to enter the Loan details on console
		for (int i = 0; i< userPrompts.length; ) {
			String userPrompt = userPrompts[i];
			try {
				line = Helper.readLine(userPrompt);
			} catch (IOException e) {
				Helper.print("An IOException was encountered. Terminating program.\n");
				return;
			}
			
			boolean isValidValue = true;
			try {
				switch (i) {
				case 0:
					amount = Double.parseDouble(line);
					if (Validator.isValidBorrowAmount(amount) == false) {
						isValidValue = false;
						double range[] = Validator.getBorrowAmountRange();
						Helper.print("Please enter a positive value between " + range[0] + " and " + range[1] + ". ");
					}
					break;
				case 1:
					apr = Double.parseDouble(line);
					if (Validator.isValidAPRValue(apr) == false) {
						isValidValue = false;
						double range[] = Validator.getAPRRange();
						Helper.print("Please enter a positive value between " + range[0] + " and " + range[1] + ". ");
					}
					break;
				case 2:
					years = Integer.parseInt(line);
					if (Validator.isValidTerm(years) == false) {
						isValidValue = false;
						int range[] = Validator.getTermRange();
						Helper.print("Please enter a positive integer value between " + range[0] + " and " + range[1] + ". ");
					}
					break;
				}
			} catch (NumberFormatException e) {
				isValidValue = false;
			}
			if (isValidValue) {
				i++;
			} else {
				Helper.print("An invalid value was entered.\n");
			}
		}
		
		//form the request object to call Amortization API
		LoanInformationDO loanRequest = new LoanInformationDO();
		loanRequest.setPrincipal(Math.round(amount));
		loanRequest.setAnnualInterestRate(apr);
		loanRequest.setLoanTerm(years);
		
		AmortizationSchedule amortization = new AmortizationScheduleImpl();
		AmortizationScheduleDO amortizationResponse = null;
		
		try {			
			amortizationResponse = amortization.getAmortizationSchedule(loanRequest);			
			if(amortizationResponse != null) {
				Helper.printAmortizationChart(amortizationResponse); //print amortization data in a nice tabular format
			} else {
				System.err.print("Empty Response from Amortization API!!");
			}			
		} catch (IllegalArgumentException e) {
			Helper.print("Unable to process the values entered. Terminating program.\n");
		} catch(Exception exception) {
			Helper.print("Some unknown exception occurred. Terminating the program.\n");
		}

	}	

}