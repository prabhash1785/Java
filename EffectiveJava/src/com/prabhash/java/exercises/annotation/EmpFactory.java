package com.prabhash.java.exercises.annotation;

import java.lang.reflect.*;

/*
 * This class utilizes a singleton Employee object reference.
 * It also provides a Static Factory Method(SFM) to access the 
 * singleton Employee object.
 */
public class EmpFactory {

	private static Employee emp;
	
	private EmpFactory() {
			emp = new Employee();
	}
	
	public static Employee getEmployee() {
		if (emp == null)
			emp = new Employee(); 
		// Use reflection to examine annotated method
		Class empClass = emp.getClass();  
		Method[] methods = empClass.getMethods();
		int id = -1;
		//Loop through all the Employee methods and determine the
		//method that is annotated.
		for (Method method : methods) {
			if (method.isAnnotationPresent(EmpID.class)) {
				//Retrieve the annotation object
				EmpID empId = method.getAnnotation(EmpID.class);
				//Retrieve the attribute value that is set in the annotation
				id = empId.id();
				break;
			}
		}
		emp.setEmpId(id);
		emp.setEmpFirstName("Ray");
		emp.setEmpLastName("Mears");
		
		return emp;
	}
	
	public static void main(String[] args) {
		Employee emp = EmpFactory.getEmployee();
		System.out.println(emp);
	}

}
