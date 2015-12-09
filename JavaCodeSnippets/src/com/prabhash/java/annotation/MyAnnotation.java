package com.prabhash.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention (RetentionPolicy.SOURCE)
@interface MyAnnotation {
	
	String firstName() default "Prabhash";
	String lastName() default "Rathore";
	String date();
	String company();

}
