package com.netease.modular.order;

import com.netease.arouter.api.RouterManager;
import com.netease.arouter.api.core.ParameterLoad;
import com.netease.common.user.IUser;
import java.lang.Object;
import java.lang.Override;

public class Order_MainActivity$$Parameter implements ParameterLoad {
  @Override
  public void loadParameter(Object target) {
    Order_MainActivity t = (Order_MainActivity)target;
    t.iUser = (IUser) RouterManager.getInstance().build("/app/getUserInfo").navigation(t);
    t.username = t.getIntent().getStringExtra("username");
  }
}
