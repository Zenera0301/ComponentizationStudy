package com.example.personal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.modular.annotation.ARouter;

@ARouter(path="/personal/Personal3Activity")
public class Personal3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal3);
    }
}