package com.guokaijun3000.lab_java_ecosystem.reflection.fields;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.guokaijun3000.lab_java_ecosystem.reflection.fields.Book.setFields;
import static java.lang.System.out;

enum Tweedle {DEE, DUM}

public class SetField {
	public static void main(String... args) throws NoSuchFieldException, IllegalAccessException {
		setFields();
	}

}

class Book {
	public long chapters = 0;

	public String[] characters = {"Alice", "White Rabbit"};

	public Tweedle twin = Tweedle.DEE;

	public static void setFields() throws NoSuchFieldException, IllegalAccessException {
		Book book = new Book();
		String fmt = "%6S:  %-12s = %s%n";

		Class<?> c = book.getClass();

		// 反射设置值。慎用
		// 1. 违背类的设计原则 2. 性能不好（跳过了编译器优化、还有像安全检查之类的额外开销）
		// 设置值是原子操作
		Field chap = c.getDeclaredField("chapters");
		out.format(fmt, "before", "chapters", book.chapters);
		chap.setLong(book, 12);
		out.format(fmt, "after", "chapters", chap.getLong(book));

		Field chars = c.getDeclaredField("characters");
		out.format(fmt, "before", "characters",
				Arrays.asList(book.characters));
		String[] newChars = {"Queen", "King"};
		chars.set(book, newChars);
		out.format(fmt, "after", "characters",
				Arrays.asList(book.characters));

		Field t = c.getDeclaredField("twin");
		out.format(fmt, "before", "twin", book.twin);
		t.set(book, Tweedle.DUM);
		out.format(fmt, "after", "twin", t.get(book));

	}
}
  