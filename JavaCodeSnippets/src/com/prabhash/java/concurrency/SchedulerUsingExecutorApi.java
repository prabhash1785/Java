package com.prabhash.java.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/*
 * This class is written to execute a task at repeated intervals using ScheduledExecutorService API.
 * @author Prabhash Rathore 
 * 
 */
public class SchedulerUsingExecutorApi {	

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(3);
		
		final Runnable printMessage = new Runnable() {
			@Override
			public void run() {
				System.out.println("I love Amber!!");
			}
		};
		
		final ScheduledFuture<?> messageHandler = scheduledService.scheduleAtFixedRate(printMessage, 0, 5, TimeUnit.SECONDS);
		
		scheduledService.schedule(new Runnable() {
			public void run() {
				messageHandler.cancel(true);
			}
		}, 20, TimeUnit.SECONDS);

	}

}
