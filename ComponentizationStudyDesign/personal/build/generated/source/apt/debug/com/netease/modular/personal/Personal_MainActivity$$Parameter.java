package com.netease.modular.personal;

import com.netease.arouter.api.RouterManager;
import com.netease.arouter.api.core.ParameterLoad;
import com.netease.common.user.IUser;
import java.lang.Object;
import java.lang.Override;

public class Personal_MainActivity$$Parameter implements ParameterLoad {
  @Override
  public void loadParameter(Object target) {
    Personal_MainActivity t = (Personal_MainActivity)target;
    t.iUser = (IUser) RouterManager.getInstance().build("/app/getUserInfo").navigation(t);
    t.username = t.getIntent().getStringExtra("username");
  }
}
