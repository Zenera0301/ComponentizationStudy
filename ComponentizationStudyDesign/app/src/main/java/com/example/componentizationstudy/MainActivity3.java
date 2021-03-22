package com.example.componentizationstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.modular.annotation.ARouter;
import com.example.modular.annotation.Parameter;

@ARouter(path = "/app/MainActivity3")
public class MainActivity3 extends AppCompatActivity {

    @Parameter
    String username;

    @Parameter
    boolean success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}