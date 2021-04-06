package com.netease.modular.apt;

import com.netease.arouter.annotation.model.RouterBean;
import com.netease.arouter.api.core.ARouterLoadPath;
import com.netease.modular.MainActivity;
import com.netease.modular.user.IUserImpl;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Path$$app implements ARouterLoadPath {
  @Override
  public Map<String, RouterBean> loadPath() {
    Map<String, RouterBean> pathMap = new HashMap<>();
    pathMap.put("/app/MainActivity", RouterBean.create(RouterBean.Type.ACTIVITY, MainActivity.class, "/app/MainActivity", "app"));
    pathMap.put("/app/getUserInfo", RouterBean.create(RouterBean.Type.CALL, IUserImpl.class, "/app/getUserInfo", "app"));
    return pathMap;
  }
}
