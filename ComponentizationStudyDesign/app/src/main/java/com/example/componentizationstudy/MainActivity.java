package com.example.componentizationstudy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.componentizationstudy.test.ARouter$$Group$$order;
import com.example.componentizationstudy.test.ARouter$$Group$$personal;
import com.example.modular.annotation.ARouter;
import com.example.modular.annotation.model.RouterBean;
import com.example.modular.api.ARouterLoadGroup;
import com.example.modular.api.ARouterLoadPath;

import java.util.Map;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jumpOrder(View view){
//        Intent intent = new Intent(this, Order_MainActivity.class);
//        intent.putExtra("name", "simon");
//        startActivity(intent);

        // 全局Map加载
//        Class<?> targetClass = RecordPathManager.getTargetClass("order", "Order_MainActivity");
//        if (targetClass == null) {
//            Log.e("djtest", "获取targetClass为空");
//        }
//        Intent intent = new Intent(this, targetClass);
//        intent.putExtra("name", "simon");
//        startActivity(intent);

        ARouterLoadGroup loadGroup = new ARouter$$Group$$order();
        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();
        // app-order
        Class<? extends ARouterLoadPath> clazz = groupMap.get("order");

        // 类加载技术
        try {
            ARouterLoadPath path = clazz.newInstance();
            Map<String, RouterBean> pathMap = path.loadPath();
            // 获取/order/Order_MainActivity
            RouterBean routerBean = pathMap.get("/order/Order_MainActivity");
            if (routerBean != null) {
                Intent intent = new Intent(this, routerBean.getClazz());
                intent.putExtra("name", "simon");
                startActivity(intent);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    // 最终集成化模式，所有子模块APT生成的类文件都会打包到APK中
    public void jumpPersonal(View view){
        ARouterLoadGroup loadGroup = new ARouter$$Group$$personal();
        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();
        // app-personal
        Class<? extends ARouterLoadPath> clazz = groupMap.get("personal");

        // 类加载技术
        try {
            ARouterLoadPath path = clazz.newInstance();
            Map<String, RouterBean> pathMap = path.loadPath();
            // 获取/personal/Personal_MainActivity
            RouterBean routerBean = pathMap.get("/personal/Personal_MainActivity");
            if (routerBean != null) {
                Intent intent = new Intent(this, routerBean.getClazz());
                intent.putExtra("name", "simon");
                startActivity(intent);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}