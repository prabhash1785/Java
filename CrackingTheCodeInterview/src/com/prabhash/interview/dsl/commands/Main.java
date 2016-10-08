package com.prabhash.interview.dsl.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Standard input is a DSL of commands. See the below sample input.
 * First line represents number of commands. Second and third line represents creation of services. Fourth and fith line represents
 * registration of services. Sixth and seventh line represents addition of users. For this DSL input, the out is shown as follows.  
 * 
 * Sample Input:
 * 6
 * service s1
 * service s2
 * register s1 s2
 * register s2 s1
 * add s1 tina 1
 * add s2 tom 2
 * 
 * Expected Output:
 * service s1
 * tina 1
 * tom 2
 * service s2
 * tina 1
 * tom 2
 * 
 * Following DSL commands are supported:
 * service serviceName - Create service
 * add serviceName userName userID - add userName with given id to service
 * delete serviceName userName userID - delete userName with ID from service
 * register service1 service2 - Register service2 with service1. After registeration, all operations on service2 will also happen for service1
 * deregister service1 service - Unregister service2 from service1 

 * @author Prabhash Rathore
 *
 */
public class Main {
	public static void main(String[] args) {
		List<UserService> services = new ArrayList<>();
		Map<String, UserService> serviceLookup = new HashMap<>();
		
		Scanner scanner = new Scanner(System.in); //This will block until you provide input on console
		int commands = scanner.nextInt();
		String serviceName, userName, serviceName1, serviceName2;
		int userId;
		UserService us, service1, service2;
		for (int c = 0; c < commands; c++) {
			String command = scanner.next();
			switch (command) {
			case "add":
				serviceName = scanner.next();
				userName = scanner.next();
				userId = scanner.nextInt();
				us = serviceLookup.get(serviceName);
				us.addUser(new User(userName, userId));
				break;
			case "delete":
				serviceName = scanner.next();
				userName = scanner.next();
				userId = scanner.nextInt();
				us = serviceLookup.get(serviceName);
				us.deleteUser(new User(userName, userId));
				break;
			case "service":
				serviceName = scanner.next();
				us = new UserService(serviceName);
				services.add(us);
				serviceLookup.put(serviceName, us);
				break;
			case "register":
				serviceName1 = scanner.next();
				serviceName2 = scanner.next();
				service1 = serviceLookup.get(serviceName1);
				service2 = serviceLookup.get(serviceName2);
				service1.registerListener(service2);
				break;
			case "deregister":
				serviceName1 = scanner.next();
				serviceName2 = scanner.next();
				service1 = serviceLookup.get(serviceName1);
				service2 = serviceLookup.get(serviceName2);
				service1.deregisterListener(service2);
				break;
			}
		}
		
		scanner.close(); // close the scanner resource
		
		for (UserService s : services) {
			System.out.println("service " + s);
			for (User u : s.getUsers()) {
				System.out.println(u);
			}
		}
	}
}