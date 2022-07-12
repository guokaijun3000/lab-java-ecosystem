package com.guokaijun3000.lab_java_ecosystem.reflection.classes;

import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

/**
 * https://docs.oracle.com/javase/tutorial/reflect/class/classNew.html
 */
public class HowToGetClass {

	// getClass()
	public static void retrievingClass1() {
		// 普通对象
		Class<? extends String> aClass = "string".getClass();
		// 枚举
		Class<? extends SortOrder> sortOrderClass = SortOrder.UNSORTED.getClass();
		// 数组
		byte[] bytes = new byte[1024];
		Class<? extends byte[]> arrayClass = bytes.getClass();
		// 泛型的类型擦除
		Set<String> s = new HashSet<>();
		Class<? extends Set> genericClass = s.getClass();
	}

	// .class
	public static void retrievingClass2() {
		Class<Boolean> booleanClass = boolean.class;
		Class<HowToGetClass> aClassClass = HowToGetClass.class;
		Class<int[][][]> _3dArrayClass = int[][][].class;
		Class<String[]> arrayClass = String[].class;
	}

	// Class#forName
	public static void retrievingClass3() throws ClassNotFoundException {
		Class<?> aClass;
//		aClass = Class.forName(boolean.class.getName()); // 原子类型不能用Class#forName
		aClass = Class.forName(HowToGetClass.class.getName());
		aClass = Class.forName(int[].class.getName());
		aClass = Class.forName(String[].class.getName());
	}

	//
	public static void typeFieldForPrimitiveTypeWrappers() {
		Class<Double> type = Double.TYPE;
		Class<Double> doubleClass = double.class;
		System.out.println(type == doubleClass); // true
		Class<Void> voidType = Void.TYPE;
		Class<Void> voidClass = void.class;
		System.out.println(voidType == voidClass); // true
	}

	//
	public static void extendGetClass() {
		Class<?>[] c1 = Character.class.getClasses(); // 成员类型的class
		Class<?>[] c2 = Character.class.getDeclaredClasses(); // 返回所有被该类声明的类
		Class<?> c3 = Thread.State.class.getDeclaringClass(); // 返回把该类声明的类
	}


	public static void main(String[] args) throws ClassNotFoundException {
		retrievingClass1();
		retrievingClass2();
		retrievingClass3();
		typeFieldForPrimitiveTypeWrappers();
		extendGetClass();
	}
}
