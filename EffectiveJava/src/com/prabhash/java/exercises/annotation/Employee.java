package com.prabhash.java.exercises.annotation;

public class Employee {

	private int empId;
	private String empFirstName;
	private String empLastName;
	private double empSalary;
	private String empHireDate;
	private String empDeptId;

	public Employee() {
	   empId = -1;
	   empFirstName = null;
	   empLastName = null;
	   empSalary = 0.0;
	   empHireDate = null;
	   empDeptId = null;
	}

	@EmpID (id = 5)    //annotation with attribute defined
	public void setEmpId(int id) {
	   empId = id;
	}

	public void setEmpFirstName(String fn) {
	   empFirstName = fn;
	}

	public void setEmpLastName(String ln) {
	   empLastName = ln;
	}

	public void setEmpSalary(double sal) {
	   empSalary = sal;
	}

	public void setEmpHireDate(String date) {
	   empHireDate = date;
	}

	public void setEmpDeptId(String id) {
	   empDeptId = id;
	}

	public int getEmpId() {
	   return empId;
	}

	public String getEmpFirstName() {
	   return empFirstName;
	}

	public String getEmpLastName() {
	   return empLastName;
	}

	public double getEmpSalary() {
	   return empSalary;
	}

	public String getEmpHireDate() {
	   return empHireDate;
	}

	public String getEmpDeptId() {
	   return empDeptId;
	}

	public String toString() {
	   String retVal = "Empid: " + empId + "\n" +
	   		   "EmpFirstName: " + empFirstName + "\n" +
	   		   "EmpLastName: " + empLastName + "\n" +
	   		   "EmpSalary: " + empSalary + "\n" +
	   		   "EmpHireDate: " + empHireDate + "\n" +
	   		   "EmpDeptId: " + empDeptId + "\n";
	   return retVal;
	}
}
