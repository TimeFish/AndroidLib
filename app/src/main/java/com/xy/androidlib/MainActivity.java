package com.xy.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xy.androidlibrary.notification.NotificationContainer;
import com.xy.androidlibrary.notification.StandardNotificationTemplate;
import com.xy.androidlibrary.utils.NotificationUtil;

public class MainActivity extends AppCompatActivity {
    NotificationUtil util = new NotificationUtil();
    private Button mSecondBtn,mResultBtn,mSimpleNoti,mStyleNoti;
    StandardNotificationTemplate template1,template2;
    NotificationContainer container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        template1 = new StandardNotificationTemplate(MainActivity.this);
        template1.setContentText("text1").setContentTitle("Title1").setSmallIcon(R.mipmap.ic_launcher_round).setAutoCancel(false);
        template2 = new StandardNotificationTemplate(MainActivity.this);
        template2.setContentText("text2").setContentTitle("Title2").setSmallIcon(R.mipmap.ic_launcher_round).setAutoCancel(false);
        container = new NotificationContainer();
    }

    private void initView() {

        mSecondBtn = (Button) findViewById(R.id.btn_lanuch_second);
        mSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
        mResultBtn = (Button) findViewById(R.id.btn_lanuch_result);
        mResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegularResultActivity.class));
            }
        });
        mSimpleNoti = (Button) findViewById(R.id.btn_simple_noti);
        mSimpleNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                util.createSimpleNotification(MainActivity.this,1,R.mipmap.ic_launcher_round,"ContentTitle","ContextText",RegularResultActivity.class);

                container.setTemplate(template1).notifyNotification();
                container.setTemplate(template2).notifyNotification();
            }
        });
        mStyleNoti = (Button) findViewById(R.id.btn_style_noti);
        mStyleNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                util.createExLayoutNotification(MainActivity.this,2,R.mipmap.ic_launcher_round,null,null,null);
            }
        });
    }
}
