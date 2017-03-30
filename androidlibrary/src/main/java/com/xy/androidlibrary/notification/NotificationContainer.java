package com.xy.androidlibrary.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.xy.androidlibrary.R;

import java.util.UUID;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.notification
 * 文件名:    NotificationContainer
 * 创建者:    XY
 * 创建时间:   2017/3/30 9:27
 * 描述:       TODO
 */
public class NotificationContainer {
    int SUMMARY_ID = 1;
    String groupKey = "group"+ UUID.randomUUID().toString();
    NotificationCompat.Builder builder ;
    NotificationManager manager;
    Context context;
    int count;
    int id;
    public NotificationContainer setTemplate(NotificationInterface template) {
        builder = template.getBuilder();
        context = template.getContext();
        manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        return this;
    }

    public NotificationContainer notifyNotification() {
        builder.setGroup(groupKey);
        manager.notify(getNotificationId(),builder.build());
        summary();
        Toast.makeText(context,"groupKey:"+groupKey+"\n id:"+id, Toast.LENGTH_SHORT).show();
        return this;
    }

    public void summary() {
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_notification)
                .setGroup(groupKey)
                .setGroupSummary(true);
        final Notification notification = builder.build();
        manager.notify(SUMMARY_ID,notification);
    }

    protected int getNotificationId() {
//        StatusBarNotification[] statusBarNotification = manager.getActiveNotifications();
        id = manager.getActiveNotifications().length;
        return id;
    }
}
