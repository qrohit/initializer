package com.hightail.initializer.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation when used on a field, the field will be initalized using a map with key represented by us
 * usingKey
 * @author rohit.kumar
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InitializeWithMap {

	public String usingKey();

}
