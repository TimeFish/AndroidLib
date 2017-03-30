package com.xy.androidlibrary.notification;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.notification
 * 文件名:    StandardNotificationTemplate
 * 创建者:    XY
 * 创建时间:   2017/3/30 9:29
 * 描述:       TODO
 */
public class StandardNotificationTemplate extends NotificationTemplate implements NotificationInterface {
    private NotificationCompat.Builder builder;
    private Context context;
    public StandardNotificationTemplate(Context context) {
        this.context = context;
        builder = new NotificationCompat.Builder(context);
    }

    public StandardNotificationTemplate setContentTitle(String contentTitle) {
        builder.setContentTitle(contentTitle);
        return this;
    }

    public StandardNotificationTemplate setContentText(String contentText) {
        builder.setContentText(contentText);
        return this;
    }

    public StandardNotificationTemplate setSmallIcon(int smallIconId) {
        builder.setSmallIcon(smallIconId);
        return this;
    }


    @Override
    public NotificationCompat.Builder getBuilder() {
        return builder;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public StandardNotificationTemplate setAutoCancel(boolean autoCancel) {
        return this;
    }
}
