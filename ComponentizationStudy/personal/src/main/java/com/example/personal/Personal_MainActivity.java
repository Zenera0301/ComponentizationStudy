package com.example.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Personal_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);
    }

    public void jumpApp(View view){
        // 类加载方式交互
        try {
            Class targetClass = Class.forName("com.example.componentizationstudy.MainActivity");
            Intent intent = new Intent(this, targetClass);
            intent.putExtra("name", "simon");
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void jumpOrder(View view){
        // 类加载方式交互
        try {
            Class targetClass = Class.forName("com.example.order.Order_MainActivity");
            Intent intent = new Intent(this, targetClass);
            intent.putExtra("name", "simon");
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}