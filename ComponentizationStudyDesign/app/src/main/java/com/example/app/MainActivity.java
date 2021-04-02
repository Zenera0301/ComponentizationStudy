package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.annotation.ARouter;
import com.example.annotation.Parameter;
import com.example.common.base.BaseActivity;
import com.example.common.util.Cons;
import com.example.componentizationstudy.R;

@ARouter(path = "/app/MainActivity")
public class MainActivity extends BaseActivity {

    @Parameter
    String name;

    @Parameter
    int age;

    @Parameter
    boolean isSuccess;

    @Parameter(name = "netease")
    String object;

    @Parameter(name = "/order/getOrderBean")
    OrderAddress orderAddress;

    @Parameter(name = "/order/getDrawable")
    OrderDrawable orderDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (BuildConfig.isRelease) {
            Log.e(Cons.TAG, "当前为：集成化模式，除app可运行，其他子模块都是Android Library");
        } else {
            Log.e(Cons.TAG, "当前为：组件化模式，app/order/personal子模块都可独立运行");
        }
        // 懒加载方式，跳到哪加载哪个类
        ParameterManager.getInstance().loadParameter(this);

        // 测试接收传递参数
        Log.e(Cons.TAG, toString());

        int drawableId = orderDrawable.getDrawable();
        ImageView img = findViewById(R.id.img);
        img.setImageResource(drawableId);

        // 测试获取接口通信
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OrderBean orderBean = orderAddress.getOrderBean("aa205eeb45aa76c6afe3c52151b52160", "144.34.161.97");
                    Log.e("netease >>> ", orderBean.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void jumpOrder(View view) {
        RouterManager.getInstance()
                .build("/order/Order_MainActivity")
                .withString("username", "simon")
                .navigation(this, 163);
    }

    public void jumpPersonal(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("name", "simon");
        bundle.putInt("age", 35);
        bundle.putBoolean("isSuccess", true);
        bundle.putString("netease", "net163");

        RouterManager.getInstance()
                .build("/personal/Personal_MainActivity")
                .withString("username", "baby")
                .withBundle(bundle)
                .navigation(this, 163);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Log.e(Cons.TAG, data.getStringExtra("call"));
        }
    }

    @Override
    public String toString() {
        return "MainActivity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isSuccess=" + isSuccess +
                ", object='" + object + '\'' +
                '}';
    }


//    public void jumpOrder(View view){
////        Intent intent = new Intent(this, Order_MainActivity.class);
////        intent.putExtra("name", "simon");
////        startActivity(intent);
//
//        // 全局Map加载
////        Class<?> targetClass = RecordPathManager.getTargetClass("order", "Order_MainActivity");
////        if (targetClass == null) {
////            Log.e("djtest", "获取targetClass为空");
////        }
////        Intent intent = new Intent(this, targetClass);
////        intent.putExtra("name", "simon");
////        startActivity(intent);
//
//        ARouterLoadGroup loadGroup = new ARouter$$Group$$order();
//        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();
//        // app-order
//        Class<? extends ARouterLoadPath> clazz = groupMap.get("order");
//
//        // 类加载技术
//        try {
//            ARouterLoadPath path = clazz.newInstance();
//            Map<String, RouterBean> pathMap = path.loadPath();
//            // 获取/order/Order_MainActivity
//            RouterBean routerBean = pathMap.get("/order/Order_MainActivity");
//            if (routerBean != null) {
//                Intent intent = new Intent(this, routerBean.getClazz());
//                intent.putExtra("name", "dj");
//                intent.putExtra("dindin", 26);
//                startActivity(intent);
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    // 最终集成化模式，所有子模块APT生成的类文件都会打包到APK中
//    public void jumpPersonal(View view){
//        ARouterLoadGroup loadGroup = new ARouter$$Group$$personal();
//        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();
//        // app-personal
//        Class<? extends ARouterLoadPath> clazz = groupMap.get("personal");
//
//        // 类加载技术
//        try {
//            ARouterLoadPath path = clazz.newInstance();
//            Map<String, RouterBean> pathMap = path.loadPath();
//            // 获取/personal/Personal_MainActivity
//            RouterBean routerBean = pathMap.get("/personal/Personal_MainActivity");
//            if (routerBean != null) {
//                Intent intent = new Intent(this, routerBean.getClazz());
//                intent.putExtra("name", "simon");
//                startActivity(intent);
//            }
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//    }
}