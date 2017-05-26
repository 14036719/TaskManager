package sg.edu.rp.soi.c347.taskmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 14036719 on 26/5/2017.
 */

public class TaskBroadcastReceiver extends BroadcastReceiver {
    int reqCode = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is
        //receiving an Intent broadcast.
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, reqCode,
                i, PendingIntent.FLAG_CANCEL_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Buy Pen!");
        builder.setContentText("Task");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setAutoCancel(true);
        Notification n = builder.build();

        //context is to tell the app which application is being referred
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(123, n);
    }
}