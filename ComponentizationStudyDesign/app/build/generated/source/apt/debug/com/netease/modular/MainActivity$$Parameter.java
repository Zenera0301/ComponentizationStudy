package com.netease.modular;

import com.netease.arouter.api.RouterManager;
import com.netease.arouter.api.core.ParameterLoad;
import com.netease.common.order.OrderAddress;
import com.netease.common.order.drawable.OrderDrawable;
import java.lang.Object;
import java.lang.Override;

public class MainActivity$$Parameter implements ParameterLoad {
  @Override
  public void loadParameter(Object target) {
    MainActivity t = (MainActivity)target;
    t.name = t.getIntent().getStringExtra("name");
    t.age = t.getIntent().getIntExtra("age", t.age);
    t.isSuccess = t.getIntent().getBooleanExtra("isSuccess", t.isSuccess);
    t.object = t.getIntent().getStringExtra("netease");
    t.orderAddress = (OrderAddress) RouterManager.getInstance().build("/order/getOrderBean").navigation(t);
    t.orderDrawable = (OrderDrawable) RouterManager.getInstance().build("/order/getDrawable").navigation(t);
  }
}
