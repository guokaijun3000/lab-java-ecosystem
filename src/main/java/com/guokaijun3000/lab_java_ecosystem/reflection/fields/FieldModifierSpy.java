package com.guokaijun3000.lab_java_ecosystem.reflection.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static java.lang.System.out;

enum Spy {BLACK, WHITE}

public class FieldModifierSpy {
	public static void main(String[] args) {
		fieldModifierSpy(FieldModifierSpy.class, "volatile");
		fieldModifierSpy(Spy.class, "public");
		fieldModifierSpy(Inner.class, "public");
		fieldModifierSpy(Spy.class, "private", "static", "final");
	}

	volatile int share;

	int instance;

	class Inner {
	}

	public static void fieldModifierSpy(Class<?> c, String... args) {
		int searchMods = 0x0;
		for (int i = 0; i < args.length; i++) {
			searchMods |= modifierFromString(args[i]);
		}

		Field[] flds = c.getDeclaredFields();
		out.format("Fields in Class '%s' containing modifiers:  %s%n",
				c.getName(),
				Modifier.toString(searchMods));
		boolean found = false;
		for (Field f : flds) {
			int foundMods = f.getModifiers();
			// Require all of the requested modifiers to be present
			if ((foundMods & searchMods) == searchMods) {
				out.format("%-8s [ synthetic=%-5b enum_constant=%-5b ]%n",
						f.getName(),
						f.isSynthetic(), // 是否编译器生成
						f.isEnumConstant() // 是否枚举
				);
				found = true;
			}
		}

		if (!found) {
			out.format("No matching fields%n");
		}
	}

	private static int modifierFromString(String s) {
		int m = 0x0;
		if ("public".equals(s)) m |= Modifier.PUBLIC;
		else if ("protected".equals(s)) m |= Modifier.PROTECTED;
		else if ("private".equals(s)) m |= Modifier.PRIVATE;
		else if ("static".equals(s)) m |= Modifier.STATIC;
		else if ("final".equals(s)) m |= Modifier.FINAL;
		else if ("transient".equals(s)) m |= Modifier.TRANSIENT;
		else if ("volatile".equals(s)) m |= Modifier.VOLATILE;
		return m;
	}
}