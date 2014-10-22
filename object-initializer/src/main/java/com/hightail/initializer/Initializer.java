package com.hightail.initializer;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import com.hightail.initializer.annotations.InitializeNested;
import com.hightail.initializer.annotations.InitializeWithMap;

/**
 * Abstract class Initializer.
 * Initializes given class name or field from a map of keys.
 * @author rohit.kumar
 *
 */
public abstract class Initializer {
	public static <ClassName> ClassName instantiateWithMap( Class<ClassName> className, Map<? extends String, Object> map) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException, IntrospectionException{
		ClassName object = className.newInstance();
		initializeFields(object, map);
		return object;
	}
	public  static void initializeFields(Object o, Map<? extends String, Object> p) throws IntrospectionException, InvocationTargetException, IllegalAccessException, IllegalArgumentException, InstantiationException, SecurityException, NoSuchMethodException
	{
		
	    Field fields[] = o.getClass().getDeclaredFields();
	    for(Field field: fields){
	    	boolean isAccessible = field.isAccessible();
			field.setAccessible(true);
	    	InitializeWithMap initializeWithMap = field.getAnnotation(InitializeWithMap.class);
	    	String key = (initializeWithMap!=null)?initializeWithMap.usingKey():field.getName();
	    	Object value = p.get(key);
	    	if(value!=null){
	    		field.set(o, value);
	    	}
	    	InitializeNested initializeNested = field.getAnnotation(InitializeNested.class);
	    	if(initializeNested != null){
	    		Object nestedValue = field.get(o);
	    		if(nestedValue == null){
	    			field.set(o, instantiateWithMap(field.getType(), p));
	    			
	    		} else {
	    			initializeFields(nestedValue, p);
	    		}
	    	}
	    	field.setAccessible(isAccessible);
	    }
	}
	
}
