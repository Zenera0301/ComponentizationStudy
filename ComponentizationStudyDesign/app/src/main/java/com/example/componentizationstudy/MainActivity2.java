package com.example.componentizationstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.modular.annotation.ARouter;
import com.example.modular.annotation.Parameter;

@ARouter(path = "/app/MainActivity2")
public class MainActivity2 extends AppCompatActivity {

    @Parameter
    String password;

    @Parameter
    int gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}