package com.example.app.test;

import com.example.modular.api.core.ARouterLoadGroup;
import com.example.api.core.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DingJing on 2021/3/19
 * Contact me: 847467911@qq.com
 * Describe: 模拟路由器ARouter的组文件
 */
public class ARouter$$Group$$app implements ARouterLoadGroup {

    @Override
    public Map<String, Class<? extends ARouterLoadPath>> loadGroup() {
        Map<String, Class<? extends ARouterLoadPath>> groupMap = new HashMap<>();
        groupMap.put("app", ARouter$$Path$$app.class);
        return groupMap;
    }
}