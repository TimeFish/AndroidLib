package com.xy.androidlibrary.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.xy.androidlibrary.R;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.utils
 * 文件名:    NotificationUtil
 * 创建者:    XY
 * 创建时间:   2017/3/24 17:02
 * 描述:       TODO
 */
public class NotificationUtil {
    /**
     *
     * @param context
     * @param notificationId 用于确认具体是哪一个通知，如果id相同，会认为是一个通知
     * @param icon
     * @param contentTitle
     * @param contextText
     * @param resultClass 用于点击通知后打开对应的Activity
     */
    public void createSimpleNotification(Context context,int notificationId,int icon,String contentTitle,String contextText,Class resultClass) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(icon)
                        .setContentTitle(contentTitle)
                        .setContentText(contextText);
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(context, resultClass);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(resultClass);
// Adds the Intent that starts the Activity to the top of the stack
        //   PendingIntent.FLAG_UPDATE_CURRENT 表示现在就更新
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(notificationId, mBuilder.build());
    }
}
