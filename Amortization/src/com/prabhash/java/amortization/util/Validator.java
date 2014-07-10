package com.prabhash.java.amortization.util;

import com.prabhash.java.amortization.LoanInformationDO;

/**
 * This class has utility methods to validate request attributes.
 * 
 * @author Prabhash Rathore
 *
 */

public class Validator {
	
	private static final double[] borrowAmountRange = new double[] { 0.01d, 1000000000000d };
	private static final double[] aprRange = new double[] { 0.000001d, 100d };
	private static final int[] termRange = new int[] { 1, 1000000 };
	
	public static void validateLoanRequest(LoanInformationDO loanInformation) throws IllegalArgumentException, NullPointerException {

		if(loanInformation == null) {
			throw new NullPointerException();
		}
		
		if ((isValidBorrowAmount(loanInformation.getPrincipal()) == false) ||
				(isValidAPRValue(loanInformation.getAnnualInterestRate()) == false) ||
				(isValidTerm(loanInformation.getLoanTerm()) == false)) {
			throw new IllegalArgumentException();
		}
		
	}
	
	public static boolean isValidBorrowAmount(double amount) {
		double range[] = getBorrowAmountRange();
		return ((range[0] <= amount) && (amount <= range[1]));
	}
	
	public static boolean isValidAPRValue(double rate) {
		double range[] = getAPRRange();
		return ((range[0] <= rate) && (rate <= range[1]));
	}
	
	public static boolean isValidTerm(int years) {
		int range[] = getTermRange();
		return ((range[0] <= years) && (years <= range[1]));
	}
	
	public static final double[] getBorrowAmountRange() {
		return borrowAmountRange;
	}
	
	public static final double[] getAPRRange() {
		return aprRange;
	}

	public static final int[] getTermRange() {
		return termRange;
	}

}
