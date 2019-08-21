package com.academy.motatwera;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_splash);

		  // get default language
		  loadLocale();

	 }

	 // load Language form shared Preferences
	 public void loadLocale() {
		  String langPref = "Language";
		  SharedPreferences prefs = getSharedPreferences("CommonPrefs" , MODE_PRIVATE);
		  String language = prefs.getString(langPref , null);

		  if (  language != null && language.length() > 0 ) {
			   changeLang(language);
		  } else {

			   // New Intent after 2 second
			   new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {

						 Intent refresh = new Intent(SplashActivity.this , LoginActivity.class);
						 startActivity(refresh);
						 finish();

					}
			   } , 2000); // Number Of Second Until go the Activity loginActivity

		  }
	 }

	 // change language
	 public void changeLang(String lang) {
		  if ( lang.equalsIgnoreCase("") ) {
			   return;
		  }
		  Locale myLocale = new Locale(lang);
		  saveLocale(lang);
		  Locale.setDefault(myLocale);
		  android.content.res.Configuration config = new android.content.res.Configuration();
		  config.locale = myLocale;
		  this.getResources().updateConfiguration(config , getResources().getDisplayMetrics());

		  // New Intent after 3 second
		  new Handler().postDelayed(new Runnable() {
			   @Override
			   public void run() {

					Intent refresh = new Intent(SplashActivity.this , LoginActivity.class);
					startActivity(refresh);
					finish();

			   }
		  } , 2000); // Number Of Second Until go the Activity loginActivity


	 }

	 // save language in shared Preferences
	 public void saveLocale(String lang) {
		  String langPref = "Language";
		  SharedPreferences prefs = this.getSharedPreferences("CommonPrefs" , Activity.MODE_PRIVATE);
		  SharedPreferences.Editor editor = prefs.edit();
		  editor.putString(langPref , lang);
		  editor.commit();
	 }
}
