package com.myAnnotation;

/**
 *
 * @author RZ
 * @date 2020/5/27 1:32
 */
public @interface MyAnnotation {

//    String value();
    String value() default "默认值";
}
