package com.hightail.initializer;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.hightail.data.TestAnnotatedClass;

public class InitializerTest {
	@Test
	public void TestInitWithMap() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchMethodException, IntrospectionException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("field_1", "field1");
		map.put("val_1", 1);
		TestAnnotatedClass object = Initializer.instantiateWithMap(TestAnnotatedClass.class, map);
		System.out.println(object.toString());
	}

}
