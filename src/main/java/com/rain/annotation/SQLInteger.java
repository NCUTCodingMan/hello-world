package com.rain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SQLInteger {
	String name() default "";
	boolean primaryKey() default false;
	boolean uniqueKey() default false;
	boolean foreignKey() default false;
	int length() default 0;
}
