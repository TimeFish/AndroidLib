package com.xy.androidlibrary.notification;

import android.support.v4.app.NotificationCompat;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.notification
 * 文件名:    NotificationTemplate
 * 创建者:    XY
 * 创建时间:   2017/3/30 10:27
 * 描述:       TODO
 */
public abstract class NotificationTemplate {

    public abstract NotificationTemplate setContentTitle(String contentTitle);

    public abstract NotificationTemplate setContentText(String contentText);

    public abstract NotificationTemplate setSmallIcon(int smallIconId);

    public abstract NotificationTemplate setAutoCancel(boolean autoCancel);
}
