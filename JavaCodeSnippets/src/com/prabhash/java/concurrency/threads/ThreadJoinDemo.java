package com.prabhash.java.concurrency.threads;

/**
 * This program will use multiple threads to update state of an object concurrently. Once all the threads complete their execution, we will
 * send the final response to originator method.
 * 
 * This same pattern could be used while calling multiple servivces parallely and updating each thread result in a common response object. Finally
 * this response object coukd be sent to clients.
 * 
 *  In this program, we will use Thread's join() method to detect if threads have completed the execution of their runnables.
 * 
 * @author prrathore
 *
 */
public class ThreadJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
