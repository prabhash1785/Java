package com.prabhash.java.concurrency.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
	
	private List<String> list;
	
	public ThreadJoinDemo() {
		list = new ArrayList<String>();
	}
	
	/**
	 * Method 1 uses Thread.join()
	 * 
	 * @return List<String>
	 */
	public List<String> updateList() {
		
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(list) {
					list.add("Thread1 -> San Francisco");
				}
			}
			
		}, "Thread1");
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(list) {
					list.add("Thread2 -> Chicago");
				}
			}
			
		}, "Thread2");
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized(list) {
					list.add("Thread3 -> Las Vegas");
				}
			}
			
		}, "Thread3");
		
		List<Thread> threadList = new ArrayList<Thread>();
		threadList.add(thread1);
		threadList.add(thread2);
		threadList.add(thread3);
		
		for(Thread thread : threadList) {
			thread.start();
		}
		
		for(Thread thread : threadList) {
			try {
				thread.join(); //wait until all three threads complete execution
			} catch(InterruptedException i) {
				i.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * Method 2 uses an Executor Service
	 * 
	 * @param args
	 */
	public List<String> updateListConcurrently() {
		
		final List<String> list = new LinkedList<String>();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 6; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					list.add("hello");
				}
			});
		}
		
		executor.shutdown();
		
		return list;
		
	}
	
	/**
	 * Parametrized Runnable Task
	 * 
	 * @param args
	 */
	private Runnable runnableTask(final String input) {
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				synchronized(list) {
					list.add(input);
				}
			}
		};
		
		return r;
		
	}

	public static void main(String[] args) {
		
		ThreadJoinDemo mainObject = new ThreadJoinDemo();
		
		//List<String> outputList = mainObject.updateList();
		
		List<String> outputList = mainObject.updateListConcurrently();
		
		for(String s : outputList) {
			System.out.println(s);
		}

	}

}
