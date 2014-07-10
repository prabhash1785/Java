package com.prabhash.java.amortization.util;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

import com.prabhash.java.amortization.AmortizationScheduleDO;

/**
 * This class has some utility helper methods which can be reused throughout the application.
 * 
 * @author Prabhash Rathore
 *
 */

public class Helper {
	
	private static Console console = System.console();
	
	public static String readLine(String userPrompt) throws IOException {
		String line = "";
		
		if (console != null) {
			line = console.readLine(userPrompt);
		} else {
			// print("console is null\n");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

			print(userPrompt);
			line = bufferedReader.readLine();
		}
		line.trim();
		return line;
	}
	
	public static void print(String s) {
		printf("%s", s);
	}
	
	public static void printf(String formatString, Object... args) {
		
		try {
			if (console != null) {
				console.printf(formatString, args);
			} else {
				System.out.print(String.format(formatString, args));
			}
		} catch (IllegalFormatException e) {
			System.err.print("Error printing...\n");
		}
	}
	
	/**
	 * This utility method accepts the final Amortization Response and prints it in nice tabular format. This utility method can be called by clients 
	 * to print their output on console.
	 * 
	 * Output is presented as follows:
	 * The output should include:
	 * The first column identifies the payment number.
	 * The second column contains the amount of the payment.
	 * The third column shows the amount paid to interest.
	 * The fourth column has the current balance.  The total payment amount and the interest paid fields.
	 * 
	 * @param amortizationScheduleDO
	 * @throws NullPointerException
	 */
	public static void printAmortizationChart(AmortizationScheduleDO amortizationScheduleDO) throws NullPointerException {
		
		String formatString = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
		printf(formatString,
				"PaymentNumber", "PaymentAmount", "PaymentInterest",
				"CurrentBalance", "TotalPayments", "TotalInterestPaid");
		
		formatString = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";
		
		for(int i = 0; i <= amortizationScheduleDO.getPaymentNumber(); i++) {
			
			//Make sure amortizationScheduleDO and member list objects are not null
			if(amortizationScheduleDO != null && amortizationScheduleDO.getMonthlyPaymentAmount() != null && amortizationScheduleDO.getCurrentMonthlyInterest() != null && amortizationScheduleDO.getCurrentBalance() != null
					&& amortizationScheduleDO.getTotalAmountPaid() != null && amortizationScheduleDO.getTotalInterestPaid() != null) {
					
					printf(formatString, i,
							((double) amortizationScheduleDO.getMonthlyPaymentAmount().get(i)),
							((double) amortizationScheduleDO.getCurrentMonthlyInterest().get(i)),
							((double) amortizationScheduleDO.getCurrentBalance().get(i)),
							((double) amortizationScheduleDO.getTotalAmountPaid().get(i)),
							((double) amortizationScheduleDO.getTotalInterestPaid().get(i)));
						
		    } else {
				System.err.print("Null Response Object!!");
				throw new NullPointerException();
			}
			
		}		
		
	}

}
