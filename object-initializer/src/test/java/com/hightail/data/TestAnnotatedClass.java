package com.hightail.data;

import com.hightail.initializer.annotations.InitializeNested;
import com.hightail.initializer.annotations.InitializeWithMap;

public class TestAnnotatedClass {
	@InitializeNested
	private TestAnnotatedClass2 obj;
	
	@Override
	public String toString() {
		return "TestAnnotatedClass [obj=" + obj + ", val1=" + val1 + "]";
	}
	@InitializeWithMap(usingKey = "val_1")
	private int val1;
}
