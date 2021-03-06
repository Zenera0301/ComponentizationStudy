package com.example.order.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.common.base.BaseActivity;
import com.example.common.util.Cons;
import com.example.order.R;

public class Order_DebugActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_debug_activity);
        Log.i(Cons.TAG, "order/Order_DebugActivity");
    }
}