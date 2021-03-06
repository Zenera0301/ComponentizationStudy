package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.common.RecordPathManager;

public class Order_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
    }

    public void jumpApp(View view){
        // 类加载方式交互
//        try {
//            Class targetClass = Class.forName("com.example.componentizationstudy.MainActivity");
//            Intent intent = new Intent(this, targetClass);
//            intent.putExtra("name", "simon");
//            startActivity(intent);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        // 全局Map加载
        Class<?> targetClass = RecordPathManager.getTargetClass("app", "MainActivity");
        if (targetClass == null) {
            Log.e("djtest", "获取targetClass为空");
        }
        Intent intent = new Intent(this, targetClass);
        intent.putExtra("name", "simon");
        startActivity(intent);
    }

    public void jumpPersonal(View view){
        // 类加载方式交互
//        try {
//            Class targetClass = Class.forName("com.example.personal.Personal_MainActivity");
//            Intent intent = new Intent(this, targetClass);
//            intent.putExtra("name", "simon");
//            startActivity(intent);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        // 全局Map加载
        Class<?> targetClass = RecordPathManager.getTargetClass("personal", "Personal_MainActivity");
        if (targetClass == null) {
            Log.e("djtest", "获取targetClass为空");
        }
        Intent intent = new Intent(this, targetClass);
        intent.putExtra("name", "simon");
        startActivity(intent);
    }
}