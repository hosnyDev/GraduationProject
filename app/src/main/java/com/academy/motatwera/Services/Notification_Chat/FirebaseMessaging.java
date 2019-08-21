package com.academy.motatwera.Services.Notification_Chat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.academy.motatwera.SplashActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class FirebaseMessaging extends FirebaseMessagingService {


	 @Override
	 public void onMessageReceived(RemoteMessage remoteMessage) {
		  super.onMessageReceived(remoteMessage);

		  String sented = remoteMessage.getData().get("sented");
		  FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

		  if ( firebaseUser != null && sented.equals(firebaseUser.getUid()) ) {

			   sendNotification(remoteMessage);

		  }

	 }

	 private void sendNotification(RemoteMessage remoteMessage) {

		  String user_chat = remoteMessage.getData().get("user_chat");
		  String body_chat = remoteMessage.getData().get("user_chat");
		  String title_chat = remoteMessage.getData().get("title_chat");
		  String image_chat = remoteMessage.getData().get("image_chat");

		  RemoteMessage.Notification notification = remoteMessage.getNotification();

		  int j = Integer.parseInt(user_chat.replaceAll("[\\D]" , ""));
		  Intent intent = new Intent(this , SplashActivity.class);
		  Bundle bundle = new Bundle();
		  bundle.putString("userid" , user_chat);
		  intent.putExtras(bundle);
		  intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		  PendingIntent pendingIntent = PendingIntent.getActivity(this , j , intent , PendingIntent.FLAG_ONE_SHOT);
		  Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

		  NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
				  .setSmallIcon(Integer.parseInt(image_chat))
				  .setContentTitle(title_chat)
				  .setContentText(body_chat)
				  .setAutoCancel(true)
				  .setSound(defaultSound)
				  .setContentIntent(pendingIntent);

		  NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		  int i = 0;
		  if ( j > 0 ) {
			   i = j;
		  }

		  manager.notify(i , builder.build());

	 }
}
