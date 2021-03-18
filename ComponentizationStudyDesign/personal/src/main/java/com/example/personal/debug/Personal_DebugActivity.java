package com.example.personal.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.common.base.BaseActivity;
import com.example.common.util.Cons;
import com.example.personal.R;

public class Personal_DebugActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_debug_activity);
        Log.i(Cons.TAG, "personal/Personal_DebugActivity");
    }


}