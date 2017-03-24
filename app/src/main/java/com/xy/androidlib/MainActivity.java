package com.xy.androidlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xy.androidlibrary.utils.NotificationUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationUtil util = new NotificationUtil();
        util.createSimpleNotification(this,1,R.mipmap.ic_launcher_round,"ContentTitle","ContextText",MainActivity.class);
        util.createSimpleNotification(this,2,R.mipmap.ic_launcher_round,"ContentTitle","ContextText",MainActivity.class);
    }
}
