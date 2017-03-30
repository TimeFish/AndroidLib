package com.xy.androidlibrary.notification;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

/**
 * 项目名:    AndroidLib
 * 包名:      com.xy.androidlibrary.utils
 * 文件名:    NotificationContentIntent
 * 创建者:    XY
 * 创建时间:   2017/3/27 9:26
 * 描述:       TODO
 */
public class NotificationContentIntent {
    public final int FLAG_REGULAR = 101;
    public final int FLAG_SPECIAL = 102;

    public PendingIntent getPendingIntent(Context context,Class resultClass,int flag) {
        PendingIntent pendingIntent = null;
        if (flag == FLAG_REGULAR) {
            pendingIntent = getRegularNotiPendingIntent(context, resultClass);
        } else if (flag == FLAG_SPECIAL) {
            pendingIntent = getSingleNotiPendingIntent(context, resultClass);
        } else {
            Log.e("PendingIntent.getPendingIntent:", "flag参数错误");
        }
        return pendingIntent;
    }

    private PendingIntent getRegularNotiPendingIntent(Context context, Class resultClass) {
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

    private PendingIntent getSingleNotiPendingIntent(Context context,Class resultClass) {
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
