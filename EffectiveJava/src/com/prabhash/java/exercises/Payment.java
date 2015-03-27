package com.prabhash.java.exercises;

import java.util.Date;

/**
 * Immutable Class:  An immutable class is simply a class whose instances cannot be modified. These are Thread-Safe.
 * E.g., String, BigInteger, Integer and all other wrapper classes.
 * 
 * Here are the properties of an Immutable Class:
 *  - Don’t provide any mutator methods
 *  - Ensure that the class can’t be extended
 *       - Generally accomplished by making the class final
 *  - Make all fields private final
 *  - Ensure exclusive access to any mutable components
 *     – If the class has any fields that refer to mutable objects, ensure that clients of the class cannot obtain references to these objects
 *     – Never initialize such a field to a client-provided object or return the object reference from an accessor
 * 
 * 
 * @author prrathore
 *
 */
public final class Payment {
	
	private final float amount;
	private final Date paymentDate; //Do not return original Date object, it will break immutability of this class. Always send a copy.
	
	public Payment(float amount, Date paymentDate) {
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	
	public float getAmount() {
		return this.amount;
	}
	
	public Date getPaymentDate() {
		Date dateCopy = (Date) this.paymentDate.clone();
		return dateCopy;
	}
	
	public Payment adjusyPaymentAmount(float amount) {
		Date dateCopy = (Date) paymentDate.clone(); //clone the Date as you can't provide a mutable object from an immutable class
		return new Payment(amount, dateCopy);
	}
	
	public static void main(String[] args) {
		
		Payment p1 = new Payment(200.74f, new Date());
		
		Payment p2 = new Payment(300.45f, new Date());
		
		System.out.println("Is p1 and p2 are equal: " + (p1 == p2)); //compare references and see if two references point to same object
		
		Float a = p1.getAmount(); //Since Float is an immutable class, it returns new object
		Float b = a.valueOf(23.8f);
		
		System.out.println("Is a == b: " + (a == b)); //false
		
		Date d1 = p2.getPaymentDate();
		
		System.out.println("Is d1 == p2.getPaymentDate: " + (d1 == p2.getPaymentDate()) + "\n"); //false
		// assert d1 == p2.getPaymentDate();
		
	}

}
