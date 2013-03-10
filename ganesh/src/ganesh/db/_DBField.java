/* Copyright (c) 2013 G.I.C Consultoria e Comunicação Ltda */
package ganesh.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface _DBField {

	String value();
}