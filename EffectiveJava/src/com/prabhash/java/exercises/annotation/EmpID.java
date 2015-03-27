package com.prabhash.java.exercises.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Target(ElementType.METHOD)   //annotation is intended to be used for methods
@Retention(RetentionPolicy.RUNTIME)  //allows use of reflection to query annotation
@interface EmpID {      //defines annotation
	int id() default -1;   //defines attribute used with annotation
}
