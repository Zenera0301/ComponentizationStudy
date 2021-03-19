package com.example.modular.api;

import java.util.Map;

/**
 * Created by DingJing on 2021/3/18
 * Contact me: 847467911@qq.com
 * Describe: 路由组Group对外提供加载数据接口
 */
public interface ARouterLoadGroup {

    /**
     * 加载路由组Group数据
     * 如："app", ARouter$$Path$$app.class（实现了ARouterLoadPath接口）
     */
    Map<String, Class<? extends ARouterLoadPath>> loadGroup();

}
