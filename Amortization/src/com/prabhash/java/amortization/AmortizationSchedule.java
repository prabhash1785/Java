/*
 * Interface Defintion for the Amortization Schedule Generator API.
 * 
 * @author Prabhash Rathore
 * 
 */

package com.prabhash.java.amortization;

/**
 * This is the Amortization API contract which will be exposed to any client using this API to calculate Amortization
 * schedule.
 * 
 * @param loan
 * @return AmortizationScheduleDO
 * @throws IllegalArgumentException 
 *
 */

public interface AmortizationSchedule {
	
	public AmortizationScheduleDO getAmortizationSchedule(LoanInformationDO loanInformation) throws IllegalArgumentException;	

}
