package com.mateoj.multiactivitydrawer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by pavan on 10/8/16.
 */
public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService  {
  //  public final static String EXTRA_MESSAGE = "com.mateoj.multiactivitydrawer.MESSAGE";

    ArrayHelper pavan;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        pavan = new ArrayHelper(this);

        pavan.getMessage(remoteMessage.getData().get("message"));

        showNotification(remoteMessage.getData().get("message"));

    }

    private void showNotification(String message) {

        try {

        Intent i = new Intent(this,Notify.class);
      //  i.putExtra(EXTRA_MESSAGE,message);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setAutoCancel(false)
                    .setContentTitle("Notification from Police")
                    .setContentText(message)
                    .setSmallIcon(R.drawable.third_i)
                    .setContentIntent(pendingIntent)
                    .setDefaults(Notification.DEFAULT_ALL)

                    .setStyle(new NotificationCompat.BigTextStyle().bigText(message));

        //  Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //  builder.setSound(alarmSound);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify(0,builder.build());

    }catch (Exception e){e.printStackTrace();}
    }
}
