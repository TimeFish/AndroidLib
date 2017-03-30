package com.xy.androidlib;

import android.app.Notification;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Notification.Builder builder = new Notification.Builder(this);
        try {
            Notification.Action action = (Notification.Action) clone();

                    builder.setActions(action);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
