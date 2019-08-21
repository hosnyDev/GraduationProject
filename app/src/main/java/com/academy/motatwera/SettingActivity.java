package com.academy.motatwera;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;

import java.util.Locale;

import info.hoang8f.widget.FButton;

public class SettingActivity extends AppCompatActivity {

	 // view
	 private CardView   fontSize, backgroundColor, notification;

	 private int fontSizeState;
	 private int backgroundState;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_setting);

		  // view
 		  fontSize = findViewById(R.id.fontSize);
		  backgroundColor = findViewById(R.id.backgroundColor);
		  notification = findViewById(R.id.notification);


		  // on click to fontSize
		  fontSize.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					fontSizeMethod();
			   }
		  });

		  // on click to background color
		  backgroundColor.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					backgroundColorMethod();
			   }
		  });

		  // on click to notification
		  notification.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					notificationMethod();
			   }
		  });

	 }

	 // to change font size
	 private void fontSizeMethod() {
		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  LayoutInflater inflater = getLayoutInflater();
		  View view = inflater.inflate(R.layout.font_size , null);
		  al.setView(view);

		  // view
		  final RadioButton s = view.findViewById(R.id.s);
		  final RadioButton m = view.findViewById(R.id.m);
		  final RadioButton l = view.findViewById(R.id.l);
		  FButton save = view.findViewById(R.id.saveFontSize);

		  // set color to button
		  colorButton(save);

		  // get default value and set checked
		  getFontSizeShared();

		  if ( fontSizeState == 0 ) {

			   s.setChecked(true);

		  } else if ( fontSizeState == 1 ) {

			   m.setChecked(true);

		  } else if ( fontSizeState == 2 ) {

			   l.setChecked(true);
		  }

		  save.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					if ( s.isChecked() ) {

						 fontShared("s");

					} else if ( m.isChecked() ) {

						 fontShared("m");

					} else if ( l.isChecked() ) {

						 fontShared("l");

					} else {
						 msgAlert("please select option \n or click back button to close");
					}

			   }
		  });


		  al.create();
		  al.show();
	 }

	 // background method
	 private void backgroundColorMethod() {
		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  LayoutInflater inflater = getLayoutInflater();
		  View view = inflater.inflate(R.layout.background_color , null);
		  al.setView(view);

		  // view
		  FButton save = view.findViewById(R.id.saveBackground);
		  final RadioButton w = view.findViewById(R.id.w);
		  final RadioButton b = view.findViewById(R.id.b);

		  // set color to button
		  colorButton(save);

		  // get default value and set checked
		  getColorBackgroundShared();

		  if ( backgroundState == 0 ) {

			   w.setChecked(true);

		  } else if ( backgroundState == 1 ) {

			   b.setChecked(true);

		  }

		  save.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					if ( w.isChecked() ) {

						 colorBackgroundShared("w");

					} else if ( b.isChecked() ) {

						 colorBackgroundShared("b");

					} else {
						 msgAlert("please select option \n or click back button to close");
					}

			   }
		  });

		  al.create();
		  al.show();
	 }

	 // method to mack user choose notification push time
	 private void notificationMethod() {
		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  LayoutInflater inflater = getLayoutInflater();
		  View view = inflater.inflate(R.layout.notification , null);

		  al.setView(view);
		  al.create();
		  al.show();

	 }

	 //  change color button in layout setting
	 private void colorButton(FButton btn) {

		  //set color in FButton  library
		  btn.setButtonColor(getResources().getColor(R.color.colorPrimary));
		  btn.setShadowColor(getResources().getColor(R.color.colorAccent));
		  btn.setShadowEnabled(true);
		  btn.setShadowHeight(5);
		  btn.setCornerRadius(5);

	 }

	 // shared preferences to save font size in book
	 private void fontShared(String value) {

		  getSharedPreferences("fontSize" , MODE_PRIVATE)
				  .edit()
				  .putString("size" , value)
				  .commit();
		  startActivity(new Intent(SettingActivity.this , SettingActivity.class));

	 }

	 // shared preferences to save color background in book
	 private void colorBackgroundShared(String value) {

		  getSharedPreferences("colorBackground" , MODE_PRIVATE)
				  .edit()
				  .putString("color" , value)
				  .commit();
		  startActivity(new Intent(SettingActivity.this , SettingActivity.class));

	 }

	 // get shared preferences font size
	 private void getFontSizeShared() {
		  // get shared preference
		  SharedPreferences readeShared = getSharedPreferences("fontSize" , MODE_PRIVATE);

		  if ( readeShared != null ) {
			   String size = readeShared.getString("size" , null);
			   if ( size != null && size.length() > 0 ) {
					if ( size.equals("s") ) {

						 fontSizeState = 0;

					} else if ( size.equals("m") ) {

						 fontSizeState = 1;

					} else if ( size.equals("l") ) {

						 fontSizeState = 2;
					}
			   }
		  }
	 }

	 // get shared preferences color background
	 private void getColorBackgroundShared() {
		  // get shared preference
		  SharedPreferences readeShared = getSharedPreferences("colorBackground" , MODE_PRIVATE);

		  if ( readeShared != null ) {
			   String color = readeShared.getString("color" , null);
			   if ( color != null && color.length() > 0 ) {
					if ( color.equals("w") ) {

						 backgroundState = 0;

					} else if ( color.equals("b") ) {

						 backgroundState = 1;

					}
			   }
		  }
	 }

	 // error msg
	 private void msgAlert(String msg) {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  al.setMessage(msg)
				  .setNegativeButton("try again" , null);
		  al.create();
		  al.show();
	 }

	 // on back click
	 @Override
	 public void onBackPressed() {
		  super.onBackPressed();
		  startActivity(new Intent(this , MainActivity.class));
	 }
}
