package com.xy.androidlibrary.notification;

import android.content.Context;
import android.support.v4.app.NotificationCompat;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.notification
 * 文件名:    NotificationInterface
 * 创建者:    XY
 * 创建时间:   2017/3/30 9:36
 * 描述:       TODO
 */
public interface NotificationInterface {
    NotificationCompat.Builder getBuilder();

    Context getContext();
}
