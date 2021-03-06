package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Order_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);
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

    public void jumpPersonal(View view){
        // 类加载方式交互
        try {
            Class targetClass = Class.forName("com.example.personal.Personal_MainActivity");
            Intent intent = new Intent(this, targetClass);
            intent.putExtra("name", "simon");
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}