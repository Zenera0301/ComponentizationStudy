package com.example.personal;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.common.util.Cons;

public class Personal_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_activity_main);


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