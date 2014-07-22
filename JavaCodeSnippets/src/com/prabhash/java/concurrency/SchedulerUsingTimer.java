package com.prabhash.java.concurrency;

import java.util.Timer;
import java.util.TimerTask;

/*
 * This class will use java.util.Timer class to create a scheduler which will run every 3 seconds.
 * Task to be run can be created by extending the TimerTask class and then implementing the abstract run() method.
 * @author Prabhash Rathore
 * 
 */
public class SchedulerUsingTimer extends TimerTask {

	@Override
	public void run() {
		System.out.println("Amber I love you...");
	}
	
	public static void main(String[] args) {
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new SchedulerUsingTimer(), 0, 3000);

	}

}
