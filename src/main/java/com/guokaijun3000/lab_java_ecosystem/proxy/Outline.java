package com.guokaijun3000.lab_java_ecosystem.proxy;

import java.lang.reflect.Proxy;

import com.guokaijun3000.lab_java_ecosystem.proxy.guides.DebugProxy;
import com.guokaijun3000.lab_java_ecosystem.proxy.guides.Delegator;
import com.guokaijun3000.lab_java_ecosystem.proxy.guides.Foo;
import com.guokaijun3000.lab_java_ecosystem.proxy.guides.FooImpl;

/**
 * @author guokaijun
 * @date 2022/7/5
 */
public class Outline {
	// 知识点
//	静态代理：事先写好代理类，可以手工编写，也可以用工具生成。缺点是每个业务类都要对应一个代理类，非常不灵活。
//	动态代理：运行时自动生成代理对象。缺点是生成代理代理对象和调用代理方法都要额外花费时间。
//	JDK动态代理：基于Java反射机制实现，必须要实现了接口的业务类才能用这种办法生成代理对象。新版本也开始结合ASM机制。
//	cglib动态代理：基于ASM实现，通过生成业务类的子类作为代理类。
//	Java 发射机制的常见应用：动态代理（AOP、RPC）、提供第三方开发者扩展能力（Servlet容器，JDBC连接）、第三方组件创建对象（DI）……
}
