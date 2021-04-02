package com.example.app.test;

import com.example.app.MainActivity;
import com.example.modular.annotation.model.RouterBean;
import com.example.api.core.ARouterLoadPath;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DingJing on 2021/3/19
 * Contact me: 847467911@qq.com
 * Describe: 模拟路由器ARouter的组文件对应的路径
 */
public class ARouter$$Path$$app implements ARouterLoadPath {

    @Override
    public Map<String, RouterBean> loadPath() {
        Map<String, RouterBean> pathMap = new HashMap<>();
        pathMap.put("/app/MainActivity",
                RouterBean.create(RouterBean.Type.ACTIVITY,
                        MainActivity.class,
                        "/app/MainActivity",
                        "app"));
        return pathMap;
    }
}
