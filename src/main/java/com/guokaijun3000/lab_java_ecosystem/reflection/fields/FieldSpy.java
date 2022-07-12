package com.guokaijun3000.lab_java_ecosystem.reflection.fields;

import java.lang.reflect.Field;
import java.util.List;

// https://docs.oracle.com/javase/tutorial/reflect/member/fieldTypes.html
public class FieldSpy<T> {

	public static void main(String[] args) throws NoSuchFieldException {
		printClass(FieldSpy.class, "b");
		printClass(FieldSpy.class, "name");
		printClass(FieldSpy.class, "list");
		printClass(FieldSpy.class, "val");
		printClass(FieldSpy.class, "d");
	}

	public boolean[][] b = {{false, false}, {true, true}};

	public String name = "Alice";

	public List<Integer> list;  // 这里能拿到List泛型真实类型Integer（JVM加载了方法的签名）

	public T val; // 这里的T被擦除了

	public double d;

	public static <T> void printClass(Class<T> c, String fieldName) throws NoSuchFieldException {
		Field f = c.getField(fieldName);
		System.out.format("Type: %s%n", f.getType());
		System.out.format("GenericType: %s%n", f.getGenericType());
	}
}