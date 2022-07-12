package com.guokaijun3000.lab_java_ecosystem.reflection.fields;

import java.lang.reflect.Field;

public class FieldTroubleIllegalAccessException {
	public final boolean b = true;

	public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
		FieldTroubleIllegalAccessException ft = new FieldTroubleIllegalAccessException();
		Class<?> c = ft.getClass();
		Field f = c.getDeclaredField("b"); // access final member
//		f.setAccessible(true);  // solution
		f.setBoolean(ft, Boolean.FALSE);   // IllegalAccessException

		FieldTroubleAnotherClass another = new FieldTroubleAnotherClass();
		Field f2 = another.getClass().getDeclaredField("b"); // access another class's private member
//		f2.setAccessible(true);  // solution
		f2.setBoolean(another, Boolean.FALSE); // IllegalAccessException
	}
}
