package com.netease.modular.apt;

import com.netease.arouter.annotation.model.RouterBean;
import com.netease.arouter.api.core.ARouterLoadPath;
import com.netease.modular.personal.Personal_MainActivity;
import com.netease.modular.personal.user.PersonalUserImpl;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Path$$personal implements ARouterLoadPath {
  @Override
  public Map<String, RouterBean> loadPath() {
    Map<String, RouterBean> pathMap = new HashMap<>();
    pathMap.put("/personal/Personal_MainActivity", RouterBean.create(RouterBean.Type.ACTIVITY, Personal_MainActivity.class, "/personal/Personal_MainActivity", "personal"));
    pathMap.put("/personal/getUserInfo", RouterBean.create(RouterBean.Type.CALL, PersonalUserImpl.class, "/personal/getUserInfo", "personal"));
    return pathMap;
  }
}
