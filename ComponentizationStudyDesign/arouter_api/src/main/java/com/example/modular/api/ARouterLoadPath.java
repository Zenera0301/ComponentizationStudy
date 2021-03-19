package com.example.modular.api;

import com.example.modular.annotation.model.RouterBean;

import java.util.Map;

/**
 * Created by DingJing on 2021/3/18
 * Contact me: 847467911@qq.com
 * Describe: 路由组Group对应的详细Path加载数据接口
 * 如 app分组对应有哪些类需要加载
 */
public interface ARouterLoadPath {

    /**
     * 加载路由组Group中的Path详细数据
     * 如：app分组下有这些信息
     * key : "/app/MainActivity" value: MainActivity信息封装到RouterBean对象中
     *
     */
    Map<String, RouterBean> loadPath();
}
