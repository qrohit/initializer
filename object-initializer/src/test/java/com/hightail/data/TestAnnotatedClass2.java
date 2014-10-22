package com.hightail.data;

import com.hightail.initializer.annotations.InitializeWithMap;

public class TestAnnotatedClass2 {
	@InitializeWithMap( usingKey = "field_1")
	private String field1;

	@Override
	public String toString() {
		return "TestAnnotatedClass2 [field1=" + field1 + "]";
	}
	
}
