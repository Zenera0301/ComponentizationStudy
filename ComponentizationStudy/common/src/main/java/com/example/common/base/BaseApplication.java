package com.example.common.base;

import android.app.Application;
import android.util.Log;

import com.example.common.util.Cons;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(Cons.TAG, "common/BaseApplication");
    }
}