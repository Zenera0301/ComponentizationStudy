package com.example.modular.annotation.model;

import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;

/**
 * Created by DingJing on 2021/3/18
 * Contact me: 847467911@qq.com
 * Describe: PathBean对象的升级版
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
        }
    }
}
