package com.guokaijun3000.lab_java_ecosystem.proxy;

public class FooImpl implements Foo {
    public Object bar(Object obj) throws RuntimeException {
        // ...
        return new Object();
    }
}