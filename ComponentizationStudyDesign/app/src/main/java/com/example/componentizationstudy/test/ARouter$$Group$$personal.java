package com.example.componentizationstudy.test;

import com.example.modular.api.ARouterLoadGroup;
import com.example.modular.api.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DingJing on 2021/3/19
 * Contact me: 847467911@qq.com
 * Describe: 模拟路由器ARouter的组文件
 */
public class ARouter$$Group$$personal implements ARouterLoadGroup {

    @Override
    public Map<String, Class<? extends ARouterLoadPath>> loadGroup() {
        Map<String, Class<? extends ARouterLoadPath>> groupMap = new HashMap<>();
        groupMap.put("personal", ARouter$$Path$$personal.class);
        return groupMap;
    }
}
