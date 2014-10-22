package com.hightail.initializer.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/**
 * Annotation when used for a field, the fields of class representing this fields will
 * also be initialized.
 * @author rohit.kumar
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InitializeNested {

}
