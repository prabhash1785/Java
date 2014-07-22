package com.prabhash.java.lang;

/**
 * Usage of clone and Copy Constructor
 * 
 * @author Prabhash Rathore
 *
 */
public class SampleCloning implements Cloneable { //implement clone for anyone to call get a clone of this method
	
	private int id;
	private String name;
	
	//Regular Constructor
	public SampleCloning(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//Copy Constructor - accepts the same object as that of current class
	public SampleCloning(SampleCloning temp) {
		this.id = temp.id;
		this.name = temp.name;
	}
	
	/** Returns a clone of current object */
	public SampleCloning tempMethod() {
		
		SampleCloning obj = null; //initialize object
		try {
			obj = (SampleCloning) this.clone(); //call clone method of object
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	@Override
	public String toString() {	
		return this.id + " : " + this.name;
	}

	public static void main(String[] args) {
		
		SampleCloning t = new SampleCloning(5, "Max");
		SampleCloning o = null;
		
		o = t.tempMethod();		
		
		System.out.println("HashCode of original object " + t.hashCode() + " : " + t);
		System.out.println("HashCode of cloned object " + o.hashCode() + " : " + o);

	}

}
