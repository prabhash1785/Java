API to calculate Amortization Schedule for a Mortgage Loan.

Project Details:
The program prompts the user for
  the amount he or she is borrowing,
	the annual percentage rate used to repay the loan,
	the term, in years, over which the loan is repaid.  
 
  The response includes:
    - payment number
    - Amount of the payment.
    - Amount paid to interest.
    - Current balance
    - Total payment amount
    - Interest paid fields.
 

Amortization Formula to get the Monthly Payment:
    M = P * (J / (1 - (Math.pow(1/(1 + J), N))));
 
Where:
 P = Principal
 I = Interest
 J = Monthly Interest in decimal form:  I / (12 * 100)
 N = Number of months of loan
 M = Monthly Payment Amount
 
Amortization table is created using a loop in the program and executing these steps:
1.      Calculate H = P x J, this is your current monthly interest
2.      Calculate C = M - H, this is your monthly payment minus your monthly interest, so it is the amount of principal you pay for that month
3.      Calculate Q = P - C, this is the new balance of your principal of your loan.
4.      Set P equal to Q and go back to Step 1: You thusly loop around until the value Q (and hence P) goes to zero.


This API can b called as follows:
AmortizationSchedule amortization = new AmortizationScheduleImpl();
AmortizationScheduleDO = amortization.getAmortizationSchedule(loanRequest);

  where, 
          AmortizationSchedule - Request comprising of Principal, Rate of Interest and Time
          AmortizationScheduleDO - Response from API containing the Amortized Schedule
          
It also provides a utiltiy method to print the Amortized Schedule in nice tabular format on console. This utility can be called
using:
Helper.printAmortizationChart(AmortizationScheduleDO);
  where, AmortizationScheduleDO - Amortized Schedule Response
  

Project Setup:
Download/clone this project.
Compile the java files or set up in Eclipse workspace.
Run this class (compiled class file) from console or eclipse:
com.prabhash.java.amortization.AmortizationClient.java

Technology Used:
JDK Version: jdk1.7.0_45
