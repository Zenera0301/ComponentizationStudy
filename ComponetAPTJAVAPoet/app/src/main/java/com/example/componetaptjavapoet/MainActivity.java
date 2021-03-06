package com.example.componetaptjavapoet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.annotation.ARouter;

@ARouter(path="/app/MainActivity")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("djtest", "MainActivity...");
    }

    public void jump(View view){
        Class targetClass = OrderActivity$$ARouter.findTargetClass("/app/OrderActivity");
        startActivity(new Intent(this, targetClass));
    }
}