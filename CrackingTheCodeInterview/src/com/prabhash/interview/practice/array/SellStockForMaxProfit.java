package com.prabhash.interview.practice.array;

/**
 * Given time series based Stock price data. Find the maximum profit which could be made by buying and selling these stocks
 * at specific prices.
 * 
 * @author Prabhash Rathore
 *
 */
public class SellStockForMaxProfit {
	
	/**
	 * Find maximum profit which could be made by trading a stock n times. 
	 * 
	 * Iterate through time series stock data and look for local minimum price as buyPrice and local maximum price for sell price. That
	 * will be one trade. Repeat this process for remaining stock prices.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param prices
	 * @return maxProfit
	 */
	public static int findMaxProfitByBuyingAndSellingNTimes(int[] prices) {
		if(prices == null || prices.length < 2) {
			throw new IllegalArgumentException();
		}
		
		int maxProfit = 0;
		int buyPrice = 0;
		int sellPrice = 0;
		for(int i = 0; i < prices.length; i++) {
			while(i + 1 < prices.length && prices[i] > prices[i + 1]) {
				++i;
			}
			
			buyPrice = prices[i];
			++i;
			
			if(i >= prices.length) {
				break;
			}
			
			while(i + 1 < prices.length && prices[i] < prices[i + 1]) {
				++i;
			}
			
			sellPrice = prices[i];
			
			System.out.println("Trade => BuyPrice = " + buyPrice + " :: SellPrice: " + sellPrice);
			maxProfit += sellPrice - buyPrice; 
		}
		
		return maxProfit;
	}
	
	/**
	 * Find max profit by trading your stock only once. Key part to find max profit is to keep track of minimum buy price. And update
	 * actual profit, buy and sell price only if for any i, (price - minBuy) > maxProfit.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * @param prices
	 * @return maxProfit
	 */
	public static int findMaxProfitByTradingStockOnce(int[] prices) {
		if(prices == null || prices.length < 2) {
			throw new IllegalArgumentException();
		}
		
		int maxProfit = 0;
		int buyPrice = 0;
		int sellPrice = 0;
		int minBuyPrice = Integer.MAX_VALUE;
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < minBuyPrice) {
				minBuyPrice = prices[i];
			}
			
			int profit = prices[i] - minBuyPrice;
			if(profit > maxProfit) {
				maxProfit = profit;
				buyPrice = minBuyPrice;
				sellPrice = prices[i];
			}
		}
		
		System.out.println("\nTrade Info =>  Buy Price = " + buyPrice + " :: Sell Price = " + sellPrice);
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] stockPrices = new int[] {
				10, 8, 5, 15, 20, 2, 1, 10, 8, 5
		};
		
		// Profit with n trades
		System.out.println("Max profit with n trades = " + findMaxProfitByBuyingAndSellingNTimes(stockPrices));
		
		// Profit with 1 trade
		System.out.println("Max profit with 1 trade = " + findMaxProfitByTradingStockOnce(stockPrices));
	}
}
