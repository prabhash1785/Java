package com.prabhash.java.exercises.stockportfolio;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Immutable Class
 * 
 * Properties of Immutable Class:
 *  - Don’t provide any mutator methods
 *  - Ensure that the class can’t be extended
 *       - Generally accomplished by making the class final
 *  - Make all fields private final
 *  - Ensure exclusive access to any mutable components
 *     – If the class has any fields that refer to mutable objects, ensure that clients of the class cannot obtain references to these objects
 *     – Never initialize such a field to a client-provided object or return the object reference from an accessor
 * 
 * @author prrathore
 *
 */
public final class Trade {
	
	private final String symbol; //String is immutable
	private final TradeAction action; //TradeAction is Enum which is immutable
	private final BigDecimal price; //BigDecimal is immutable
	private final int numOfShares;
	private final Date tradeDate; //Date is mutable so return a clone instead of original object
	
	public Trade(String symbol, TradeAction action, BigDecimal price, int numOfShares, Date tradeDate) {
		this.symbol = symbol;
		this.action = action;
		this.price = price;
		this.numOfShares = numOfShares;
		this.tradeDate = tradeDate;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	
	public TradeAction getAction() {
		return action;
	}
	
	
	public BigDecimal getPrice() {
		return price;
	}
	
	
	public int getNumOfShares() {
		return numOfShares;
	}
	
	
	public Date getTradeDate() {
		Date dateCopy = (Date) tradeDate.clone();
		return dateCopy;
		
	}

}
