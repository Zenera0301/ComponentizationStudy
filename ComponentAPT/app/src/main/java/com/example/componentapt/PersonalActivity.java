package com.example.componentapt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.annotation.ARouter;

@ARouter(path = "/app/PersonalActivity")
public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Log.i("djtest", "PersonalActivity");
    }

    public void jump(View view){
        Class<?> targetClass = MainActivity$$ARouter.findTargetClass("/app/MainActivity");
        startActivity(new Intent(this, targetClass));
    }
}