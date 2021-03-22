package com.example.componentizationstudy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.common.util.Cons;
import com.example.componentizationstudy.test.ARouter$$Group$$order;
import com.example.componentizationstudy.test.ARouter$$Group$$personal;
import com.example.modular.annotation.ARouter;
import com.example.modular.annotation.Parameter;
import com.example.modular.annotation.model.RouterBean;
import com.example.modular.api.core.ARouterLoadGroup;
import com.example.modular.api.core.ARouterLoadPath;

import java.util.Map;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Parameter
    String name;

    @Parameter(name="dindin")
    int age = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }

        name = getIntent().getStringExtra("name");
        age = getIntent().getIntExtra("dindin", age);
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
                intent.putExtra("name", "dj");
                intent.putExtra("dindin", 26);
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