package com.example.modular.annotation.model;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

/**
 * Created by DingJing on 2021/3/18
 * Contact me: 847467911@qq.com
 * Describe: PathBean对象的升级版
 *           设计模式：构建者模式
 */
public class RouterBean {

    public enum Type{
        ACTIVITY
    }

    // 枚举类型
    private Type type;
    // 类节点
    private Element element;
    // 被ARouter注解的类对象
    private Class<?> clazz;
    // 路由的组名
    private String group;
    // 路由的地址
    private String path;

    private RouterBean(Builder builder) {
        this.element = builder.element;
        this.path = builder.path;
        this.group = builder.group;
    }

    private RouterBean(Type type, Class<?> clazz, String path, String group) {
        this.type = type;
        this.clazz= clazz;
        this.path = path;
        this.group = group;
    }

    // 对外还提供了一种简单的实例化方法
    public static RouterBean create(Type type, Class<?> clazz, String path, String group){
        return new RouterBean(type, clazz, path, group);
    }

    private final static class Builder{
        // 类节点
        private Element element;
        // 路由的组名
        private String group;
        // 路由的地址
        private String path;

        public Builder setElement(Element element) {
            this.element = element;
            return this;
        }

        public Builder setGroup(String group) {
            this.group = group;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }

        // 最后的build或者create方法，往往是做参数的校验或者初始化工作
        public RouterBean build(){
            if(path == null || path.length() == 0){
                throw new IllegalArgumentException("path必填项为空，如/app/MainActivity");
            }
            return new RouterBean(this);
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
