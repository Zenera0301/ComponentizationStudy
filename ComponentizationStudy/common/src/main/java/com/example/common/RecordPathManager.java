package com.example.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局路径记录器（根据子模块分组）
 */
public class RecordPathManager {
    // key : "order"组
    // value：order子模块下，对应所有的Activity路径信息
    private static Map<String, List<PathBean>> groupMap = new HashMap<>();

    public static void joinGroup(String groupName, String pathName, Class<?> clazz){
        List<PathBean> list = groupMap.get(groupName);
        if (list == null) {
            list = new ArrayList<>();
            list.add(new PathBean(pathName, clazz));
            groupMap.put(groupName, list);
        } else{
            for (PathBean pathBean : list) {
                if(!pathName.equalsIgnoreCase(pathBean.getPath())){
                    list.add(new PathBean(pathName, clazz));
                    groupMap.put(groupName, list);
                }
            }
        }
    }

    /**
     * 根据组名和路径名获取类对象，达到跳转目的
     * @param groupName 组名
     * @param pathName 路径名
     * @return 跳转目标的class类对象
     */
    public static Class<?> getTargetClass(String groupName, String pathName){
        List<PathBean> list = groupMap.get(groupName);
        if (list == null) {
            return null;
        }
        for (PathBean pathBean : list) {
            if(pathName.equalsIgnoreCase(pathBean.getPath())){
                return pathBean.getClazz();
            }
        }
        return null;
    }
}
