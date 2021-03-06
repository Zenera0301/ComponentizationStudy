package com.example.componentizationstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.common.RecordPathManager;
import com.example.order.Order_MainActivity;
import com.example.personal.Personal_MainActivity;

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
        Class<?> targetClass = RecordPathManager.getTargetClass("order", "Order_MainActivity");
        if (targetClass == null) {
            Log.e("djtest", "获取targetClass为空");
        }
        Intent intent = new Intent(this, targetClass);
        intent.putExtra("name", "simon");
        startActivity(intent);
    }

    public void jumpPersonal(View view){
//        Intent intent = new Intent(this, Personal_MainActivity.class);
//        intent.putExtra("name", "simon");
//        startActivity(intent);

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