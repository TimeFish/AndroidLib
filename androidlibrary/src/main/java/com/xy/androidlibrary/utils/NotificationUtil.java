package com.xy.androidlibrary.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.utils
 * 文件名:    NotificationUtil
 * 创建者:    XY
 * 创建时间:   2017/3/24 17:02
 * 描述:       简单的Notification
 */
public class NotificationUtil{
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

        PendingIntent resultPendingIntent = getRegularNotiPendingIntent(context, resultClass);
//        PendingIntent resultPendingIntent = getSingleNotiPendingIntent(context, resultClass);
        mBuilder.setContentIntent(resultPendingIntent);
        // Notifications are issued by sending them to the
// NotificationManager system service.
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        // Builds an anonymous Notification object from the builder, and
    // passes it to the NotificationManager
        // mId allows you to update the notification later on.
        mNotificationManager.notify(notificationId, mBuilder.build());
    }

    public void createExLayoutNotification(Context context,int notificationId,int icon,String contentTitle,String contextText,Class resultClass) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle("Event tracker")
                .setContentText("Events received");
        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        String[] events = new String[]{"aaaaa","bbbbb","cccccc","ddddd "};
// Sets a title for the Inbox in expanded layout
        inboxStyle.setBigContentTitle("Event tracker details:");
// Moves events into the expanded layout
        for (int i=0; i < events.length; i++) {

            inboxStyle.addLine(events[i]);
        }
// Moves the expanded layout object into the notification object.
        mBuilder.setStyle(inboxStyle);
// Issue the notification here.
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(notificationId, mBuilder.build());
    }

    public PendingIntent getRegularNotiPendingIntent(Context context,Class resultClass) {
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
        stackBuilder.addNextIntent(resultIntent);
// Gets a PendingIntent containing the entire back stack.
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        return resultPendingIntent;
    }

    public PendingIntent getSingleNotiPendingIntent(Context context,Class resultClass) {
// Creates an Intent for the Activity
        Intent notifyIntent =
                new Intent(Intent.makeMainActivity(new ComponentName(context, resultClass)));
// Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                Intent.FLAG_ACTIVITY_CLEAR_TASK);
// Creates the PendingIntent
        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        return pendingIntent;
    }

}
