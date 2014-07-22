package com.prabhash.java.concurrency;

import com.prabhash.java.concurrency.InMemoryCache.Employee;

/*
 * This is a daemon thread implementation which uses Cache class API to run the tasks as a thread.
 * @author Prabhash Rathore
 * 
 */
public class DaemonThread implements Runnable {
	
	@Override
	public void run() {
		
		System.out.println("First create the data source..");
		InMemoryCache.createDataSource();
		
		//add some data to cache..
		InMemoryCache inMemoryCache = new InMemoryCache();
		Employee e1 = inMemoryCache.new Employee(1, "Barb Green", "New Jersey, US");
		Employee e2 = inMemoryCache.new Employee(2, "Jim Green Senior", "North Carolina, US");
		inMemoryCache.addToCache(e1);
		inMemoryCache.addToCache(e2);
		
		System.out.println("Cache data before refresh:");
		InMemoryCache.printFromCache();
		
		System.out.println("Going to refresh the cache..");
		InMemoryCache.refreshCache();
		System.out.println("Cache is refreshed, now will print the content from cache..");
		InMemoryCache.printFromCache();
				
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true);		
		thread.start();
		try {
			Thread.sleep(10000); //putting the thread to sleep so that Daemon thread can run before main thread terminates
		} catch(InterruptedException ei) {
			ei.printStackTrace();
		}
		
	}	

}
