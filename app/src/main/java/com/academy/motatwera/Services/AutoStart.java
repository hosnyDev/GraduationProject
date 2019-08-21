package com.academy.motatwera.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AutoStart extends BroadcastReceiver {
	 Alarm alarm = new Alarm();

	 @Override
	 public void onReceive(Context context , Intent intent) {
		  if ( intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) ) {
			   alarm.setAlarm(context);
		  }
	 }
}