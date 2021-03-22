package com.example.componentizationstudy.test;

import com.example.modular.annotation.model.RouterBean;
import com.example.modular.api.core.ARouterLoadPath;
import com.example.order.Order_MainActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DingJing on 2021/3/19
 * Contact me: 847467911@qq.com
 * Describe: 模拟路由器ARouter的组文件对应的路径
 */
public class ARouter$$Path$$order implements ARouterLoadPath {

    @Override
    public Map<String, RouterBean> loadPath() {
        Map<String, RouterBean> pathMap = new HashMap<>();
        pathMap.put("/order/Order_MainActivity",
                RouterBean.create(RouterBean.Type.ACTIVITY,
                        Order_MainActivity.class,
                        "/order/Order_MainActivity",
                        "order"));
        return pathMap;
    }
}
