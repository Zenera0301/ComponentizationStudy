package com.netease.modular.apt;

import com.netease.arouter.annotation.model.RouterBean;
import com.netease.arouter.api.core.ARouterLoadPath;
import com.netease.modular.order.Order_DetailActivity;
import com.netease.modular.order.Order_MainActivity;
import com.netease.modular.order.impl.OrderAddressImpl;
import com.netease.modular.order.impl.OrderDrawableImpl;
import com.netease.modular.order.impl.OrderUserImpl;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Path$$order implements ARouterLoadPath {
  @Override
  public Map<String, RouterBean> loadPath() {
    Map<String, RouterBean> pathMap = new HashMap<>();
    pathMap.put("/order/getOrderBean", RouterBean.create(RouterBean.Type.CALL, OrderAddressImpl.class, "/order/getOrderBean", "order"));
    pathMap.put("/order/getDrawable", RouterBean.create(RouterBean.Type.CALL, OrderDrawableImpl.class, "/order/getDrawable", "order"));
    pathMap.put("/order/getUserInfo", RouterBean.create(RouterBean.Type.CALL, OrderUserImpl.class, "/order/getUserInfo", "order"));
    pathMap.put("/order/Order_DetailActivity", RouterBean.create(RouterBean.Type.ACTIVITY, Order_DetailActivity.class, "/order/Order_DetailActivity", "order"));
    pathMap.put("/order/Order_MainActivity", RouterBean.create(RouterBean.Type.ACTIVITY, Order_MainActivity.class, "/order/Order_MainActivity", "order"));
    return pathMap;
  }
}
