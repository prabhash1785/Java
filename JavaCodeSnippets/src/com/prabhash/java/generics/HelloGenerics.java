package com.prabhash.java.generics;

import java.util.ArrayList;
import java.util.List;

public class HelloGenerics {

	public static void main(String[] args) {
		
		List<Animal> list1 = new ArrayList<Animal>(); //in this case object types have to be same, we can't use sub-classes
		list1.add(new Animal());
		list1.add(new Animal());
		list1.add(new Dog());
		
		for(Animal a : list1) {
			System.out.println(a.toString());
		}
		
		List<Dog> list2 = new ArrayList<Dog>(); //in this case object types have to be same, we can't use sub-classes
		//list2.add(new Animal());
		//list2.add(new Animal());
		list2.add(new Dog());
		list2.add(new Dog());
		
		for(Animal a : list2) {
			System.out.println(a.toString());
		}
		
				
		//Using Generics with extends, this will allow to use child class as an object for a super class reference
		List<? extends Animal> list3 = new ArrayList<Animal>();
		//list2.add(new Animal());
		
		
		
		

	}

}

