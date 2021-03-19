package com.example.componentizationstudy;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.componentizationstudy.test.ARouter$$Group$$order;
import com.example.modular.annotation.ARouter;
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

    }

    // 最终集成化模式，所有子模块APT生成的类文件都会打包到APK中
    public void jumpPersonal(View view){
        ARouterLoadGroup loadGroup = new ARouter$$Group$$order();
        Map<String, Class<? extends ARouterLoadPath>> groupMap = loadGroup.loadGroup();
        // app-personal
        groupMap.get("")
    }
}