package com.prabhash.java.exercises.stockportfolio;

import java.math.BigDecimal;

public class Holding {
	
	private String symbol; 
	private long numOfShares; 
	private BigDecimal cost;
	
	// need to initialize number of shares and cost public String getSymbol()
	public Holding(String symbol) {
		this.symbol = symbol;
	}
	
	public long getNumOfShares() {
		return numOfShares;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
//	// Increase the number of shares and recalculate cost
//	public void addToHolding(long numOfShares, BigDecimal sharePrice) {
//		this.cost = sharePrice.multiply(new BigDecimal(numOfShares));
//	}
//	
//	// Reduce the number of shares and recalculate cost
//	public void removeFromHolding(long numOfShares, BigDecimal sharePrice) // Before a sell-trade can be carried out, call this method to determine
//	Copyright © 2012 SciSpike
//	Page 16 of 18
//	// if there are enough shares.
//	public boolean canSell(long numOfSharesToSell) @Override public String toString()

}
