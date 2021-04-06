package com.netease.modular.apt;

import com.netease.arouter.api.core.ARouterLoadGroup;
import com.netease.arouter.api.core.ARouterLoadPath;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class ARouter$$Group$$order implements ARouterLoadGroup {
  @Override
  public Map<String, Class<? extends ARouterLoadPath>> loadGroup() {
    Map<String, Class<? extends ARouterLoadPath>> groupMap = new HashMap<>();
    groupMap.put("order", ARouter$$Path$$order.class);
    return groupMap;
  }
}
