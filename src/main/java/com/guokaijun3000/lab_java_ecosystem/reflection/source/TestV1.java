package com.guokaijun3000.lab_java_ecosystem.reflection.source;
// v1版本
import java.lang.reflect.Method;

public class TestV1 {
  public static void target(int i) {
    new Exception("#" + i).printStackTrace();
  }

  public static void main(String[] args) throws Exception {
    Class<?> klass = Class.forName("TestV1");
    Method method = klass.getMethod("target", int.class);
    for (int i = 0; i < 20; i++) {
      method.invoke(null, i);
    }
  }
}

//# 使用-verbose:class打印加载的类
//$ java -verbose:class TestV1
//...
//java.lang.Exception: #14
//        at TestV1.target(TestV1.java:5)
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke0(Native Method)
//        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke(NativeMethodAccessorImpl.java:62)
//        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl .invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//        at TestV1.main(TestV1.java:12)
//[0.158s][info][class,load] ...
//...
//[0.160s][info][class,load] jdk.internal.reflect.GeneratedMethodAccessor1 source: __JVM_DefineClass__
//java.lang.Exception: #15
//       at TestV1.target(TestV1.java:5)
//       at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke0(Native Method)
//       at java.base/jdk.internal.reflect.NativeMethodAccessorImpl .invoke(NativeMethodAccessorImpl.java:62)
//       at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl .invoke(DelegatingMethodAccessorImpl.java:43)
//       at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//       at TestV1.main(TestV1.java:12)
//java.lang.Exception: #16
//       at TestV1.target(TestV1.java:5)
//       at jdk.internal.reflect.GeneratedMethodAccessor1 .invoke(Unknown Source)
//       at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl .invoke(DelegatingMethodAccessorImpl.java:43)
//       at java.base/java.lang.reflect.Method.invoke(Method.java:564)
//       at TestV1.main(TestV1.java:12)
//...