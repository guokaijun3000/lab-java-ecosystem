package com.guokaijun3000.lab_java_ecosystem.annotations;


import java.util.Arrays;

@MyAnnotation(
        seqNo = 1,
        fieldNames = {}
)
public class AnnotatedClass {

    public static void main(String[] args) {
        // TODO 利用反射获取注解以及成员变量
        Class<AnnotatedClass> clazz = AnnotatedClass.class;
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            System.out.println("seqNo : " + annotation.seqNo());
            System.out.println("name : " + annotation.name());
            System.out.println("fieldNames : " + Arrays.toString(annotation.fieldNames()));
        }
    }

}
