package com.example.componentizationstudy.base;

import com.example.common.RecordPathManager;
import com.example.common.base.BaseApplication;
import com.example.componentizationstudy.MainActivity;
import com.example.order.Order_MainActivity;
import com.example.personal.Personal_MainActivity;

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        RecordPathManager.joinGroup("app", "MainActivity", MainActivity.class);
        RecordPathManager.joinGroup("order", "Order_MainActivity", Order_MainActivity.class);
        RecordPathManager.joinGroup("personal", "Personal_MainActivity", Personal_MainActivity.class);
    }
}
