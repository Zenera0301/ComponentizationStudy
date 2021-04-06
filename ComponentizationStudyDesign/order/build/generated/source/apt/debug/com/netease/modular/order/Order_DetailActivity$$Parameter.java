package com.netease.modular.order;

import com.netease.arouter.api.core.ParameterLoad;
import java.lang.Object;
import java.lang.Override;

public class Order_DetailActivity$$Parameter implements ParameterLoad {
  @Override
  public void loadParameter(Object target) {
    Order_DetailActivity t = (Order_DetailActivity)target;
    t.username = t.getIntent().getStringExtra("username");
  }
}
