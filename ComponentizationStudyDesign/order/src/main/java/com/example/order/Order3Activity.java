package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.modular.annotation.ARouter;

@ARouter(path="/order/Order3Activity")
public class Order3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order3);
    }
}