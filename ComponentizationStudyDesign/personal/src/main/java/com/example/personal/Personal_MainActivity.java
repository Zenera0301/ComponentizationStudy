package com.example.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.common.util.Cons;
import com.example.modular.annotation.ARouter;

@ARouter(path="/personal/Personal_MainActivity")
public class Personal_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);

        // 懒加载方式，跑到哪，加载哪个类
        // ParameterManager.getInstance().loadParameter(this);

        Log.i(Cons.TAG, "onCreate: common/Personal_MainActivity");

        if(getIntent() != null){
            Log.i(Cons.TAG, "personal:" + getIntent().getStringExtra("name"));
        }
    }

    public void jumpApp(View view){

    }
    

    public void jumpOrder(View view){

    }
}