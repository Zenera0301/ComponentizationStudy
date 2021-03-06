package com.example.componetaptjavapoet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.annotation.ARouter;

@ARouter(path="/app/OrderActivity")
public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Log.i("djtest", "OrderActivity...");
    }

    public void jump(View view){
        Class targetClass = PersonalActivity$$ARouter.findTargetClass("/app/PersonalActivity");
        startActivity(new Intent(this, targetClass));
    }
}