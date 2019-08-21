package com.academy.motatwera;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class CheckInternetConn {

	 private Context context;

	 public CheckInternetConn(Context context) {

		  this.context = context;
	 }

	 public boolean isConnection() {

		  ConnectivityManager conn = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		  if ( conn != null ) {

			   NetworkInfo info = conn.getActiveNetworkInfo();
			   return info != null && info.isConnected();

		  }

		  return false;
	 }
}
