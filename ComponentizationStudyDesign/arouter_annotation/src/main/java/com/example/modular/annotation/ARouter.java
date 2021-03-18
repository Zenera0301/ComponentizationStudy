package com.example.modular.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Activity使用的布局文件注解
 *
 * @Target(ElementType.TYPE) 接口、类、枚举、注解
 * @Target(ElementType.FIELD) 属性、枚举的常量
 * @Target(ElementType.METHOD) 方法
 * @Target(ElementType.PARAMETER) 方法参数
 * @Target(ElementType.CONSTRUCTOR) 构造函数
 * @Target(ElementType.LOCAL_VARIABLE) 局部变量
 * @Target(ElementType.ANNOTATION_TYPE) 该注解使用在另一个注解上
 * @Target(ElementType.PACKAGE) 包
 * @Retention(RetentionPolicy.RUNTIME) 该注解会在class字节码文件中存在，jvm加载时可以通过反射获取到该注解的内容
 *
 *
 * 生命周期 SOURCE < CLASS < RUNTIME
 * 1.一般如果需要在运行时去动态获取注解信息，用RUNTIME注解
 * 2.要在编译时进行一些预处理操作，如ButterKnife，用CLASS注解，注解会在class文件中存在，但是在运行时会被丢弃
 * 3.要做一些检查性的工作，如@Override，用SOURCE源码注解，注解仅存在源码级别，在编译的时候丢弃该注解
 *
 */
@Target(ElementType.TYPE)  // 作用在类上
@Retention(RetentionPolicy.CLASS)  // 没有执行run之前，在编译期的预编译操作
public @interface ARouter {
    // 详细路由路径（必填），如"/app/MainActivity"
    String path();
    // 从path中截取出来，规范开发者的编码
    String group() default "";
}
