package com.guokaijun3000.lab_java_ecosystem.proxy.guides;

import java.lang.reflect.Proxy;

/**
 * oracle教程的代码实践
 * https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html
 * @author guokaijun
 * @date 2022/7/19
 */
public class Main {

	public static void main(String[] args) {
		Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
		foo.bar(null);

		Class[] proxyInterfaces = new Class[] {Foo.class};
		// 生成一个代理对象，这个对象实现了方法传入时指定的接口。
		// 在调用接口中的方法时，具体的处理逻辑由InvocationHandler代理
		Object foo2 = Proxy.newProxyInstance(
				Foo.class.getClassLoader(),
				proxyInterfaces,
				new Delegator(proxyInterfaces, new Object[] {new FooImpl()})
		);
		String s = foo2.toString();
	}
}
