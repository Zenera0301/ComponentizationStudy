package com.example.order;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.common.util.Cons;
import com.example.modular.annotation.ARouter;
import com.example.modular.annotation.Parameter;
import com.example.modular.api.core.ParameterLoad;

import javax.security.auth.login.LoginException;

@ARouter(path="/order/Order_Activity")
public class Order_MainActivity extends AppCompatActivity {

    @Parameter
    String name;

    @Parameter(name="dindin")
    int age = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity_main);

        Log.i(Cons.TAG, "onCreate: common/Order_MainActivity");

        // 读取生成列表中的参数
        ParameterLoad parameterLoad = new Order_MainActivity$$Parameter();
        parameterLoad.loadParameter(this);

        if(getIntent() != null){
            // Log.i(Cons.TAG, "order:" + getIntent().getStringExtra("name"));
            Log.i(Cons.TAG, "order:" + "name >>> " + name + " / age >>> " + age);
        }
    }

    public void jumpApp(View view){

    }

    public void jumpPersonal(View view){

    }
}