package com.academy.motatwera.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.academy.motatwera.LoginActivity;
import com.academy.motatwera.MainActivity;
import com.academy.motatwera.MapsActivity;
import com.academy.motatwera.R;
import com.academy.motatwera.SettingActivity;
import com.academy.motatwera.TableActivity;
import com.academy.motatwera.WebsiteActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Locale;

import info.hoang8f.widget.FButton;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


	 // Required empty public constructor
	 public MenuFragment() {
	 }

	 private int langState;
	 // view
	 private CardView table, setting, website, map, language, logout;


	 // firebase
	 private FirebaseAuth mAth;
	 private FirebaseFirestore mFirebaseFirestore;


	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_menu , container , false);

		  // view
		  table = view.findViewById(R.id.tableMenu);
		  setting = view.findViewById(R.id.settingMenu);
		  website = view.findViewById(R.id.WebsiteMenu);
		  map = view.findViewById(R.id.mapMenu);
		  logout = view.findViewById(R.id.logoutMenu);
		  language = view.findViewById(R.id.language);


		  // FIREBASE
		  mAth = FirebaseAuth.getInstance();
		  mFirebaseFirestore = FirebaseFirestore.getInstance();


		  // on click table
		  table.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , TableActivity.class));
			   }
		  });

		  // on click setting
		  setting.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , SettingActivity.class));
			   }
		  });

		  // on click website
		  website.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , WebsiteActivity.class));
			   }
		  });

		  // on click map
		  map.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , MapsActivity.class));
			   }
		  });

		  // on click to language
		  language.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					languageMethod();
			   }
		  });

		  // on click logout
		  logout.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					if ( getActivity() != null ) {

						 final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
						 LayoutInflater inflater1 = getLayoutInflater();
						 View view1 = inflater1.inflate(R.layout.confirm_logout , null);

						 final CheckBox accept_logout = view1.findViewById(R.id.accept_logout);
						 Button cancel = view1.findViewById(R.id.cancel);
						 final Button leave = view1.findViewById(R.id.leave);

						 animyButton(cancel);
						 animyButton(leave);

						 cancel.setOnClickListener(new View.OnClickListener() {
							  @Override
							  public void onClick(View view) {

								   bottomSheetDialog.dismiss();

							  }
						 });

						 leave.setEnabled(false);


						 accept_logout.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
							  @Override
							  public void onCheckedChanged(CompoundButton compoundButton , boolean b) {

								   if ( b ) {

										leave.setEnabled(true);
										leave.setBackgroundColor(getResources().getColor(R.color.b2b2b2));
										leave.setTextColor(getResources().getColor(R.color.white));

								   } else {
										leave.setEnabled(false);
										leave.setBackgroundColor(getResources().getColor(R.color.buttonText));
										leave.setTextColor(getResources().getColor(R.color.white));

								   }

							  }
						 });

						 leave.setOnClickListener(new View.OnClickListener() {
							  @Override
							  public void onClick(View view) {

								   SignOut();
							  }
						 });


						 bottomSheetDialog.setContentView(view1);
						 bottomSheetDialog.show();

					}

			   }
		  });

		  return view;
	 }


	 // SIGN OUT
	 private void SignOut() {

		  if ( getActivity() != null ) {
			   if ( mAth != null ) {
					mAth.signOut();
					startActivity(new Intent(getActivity() , LoginActivity.class));
					getActivity().finish();
			   }
		  }
	 }


	 private void animyButton(final Button button) {
		  button.setOnTouchListener(new View.OnTouchListener() {
			   @Override
			   public boolean onTouch(View view , MotionEvent motionEvent) {
					if ( motionEvent.getAction() == MotionEvent.ACTION_DOWN ) {
						 //perform your animation when button is touched and held
						 button.setBackgroundColor(getResources().getColor(R.color.white));
						 button.setTextColor(getResources().getColor(R.color.b2b2b2));

					} else if ( motionEvent.getAction() == MotionEvent.ACTION_UP ) {
						 //perform your animation when button is released
						 button.setBackgroundColor(getResources().getColor(R.color.b2b2b2));
						 button.setTextColor(getResources().getColor(R.color.white));
					}
					return false;
			   }
		  });
	 }

	 // this method for choose user a favorite language
	 Locale myLocale;

	 public void changeLang(String lang) {

		  if ( lang.equalsIgnoreCase("") )
			   return;
		  myLocale = new Locale(lang);
		  saveLocale(lang);
		  Locale.setDefault(myLocale);
		  android.content.res.Configuration config = new android.content.res.Configuration();
		  config.locale = myLocale;
		  getResources().updateConfiguration(config , getResources().getDisplayMetrics());
		  startActivity(new Intent(getActivity() , MainActivity.class));

	 }

	 // save language in shared preferences
	 public void saveLocale(String lang) {
		  String langPref = "Language";
		  SharedPreferences prefs = getActivity().getSharedPreferences("CommonPrefs" , MODE_PRIVATE);
		  SharedPreferences.Editor editor = prefs.edit();
		  editor.putString(langPref , lang);
		  editor.apply();
	 }

	 // load Language form shared Preferences
	 public void loadLang() {
		  String langPref = "Language";
		  SharedPreferences prefs = getActivity().getSharedPreferences("CommonPrefs" , MODE_PRIVATE);
		  String language = prefs.getString(langPref , null);

		  if ( language != null && language.length() > 0 ) {

			   if ( language.equals("ar") ) {
					langState = 0;
			   } else if ( language.equals("en") ) {
					langState = 1;
			   }

		  }
	 }

	 // to change language
	 private void languageMethod() {

		  if ( getActivity() != null ) {

			   final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
			   LayoutInflater inflater1 = getLayoutInflater();
			   View view1 = inflater1.inflate(R.layout.language , null);

			   final RadioButton arabic = view1.findViewById(R.id.arabic);
			   final RadioButton english = view1.findViewById(R.id.english);

			   Button cancel = view1.findViewById(R.id.cancel_lang);
			   Button saveLang = view1.findViewById(R.id.saveLang);

			   animyButton(cancel);
			   animyButton(saveLang);

			   cancel.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {

						 bottomSheetDialog.dismiss();

					}
			   });


			   // get default value and set checked
			   loadLang();
			   if ( langState == 0 ) {
					arabic.setChecked(true);
			   } else if ( langState == 1 ) {
					english.setChecked(true);
			   }

			   saveLang.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {

						 if ( arabic.isChecked() ) {
							  changeLang("ar");
						 } else if ( english.isChecked() ) {
							  changeLang("en");
						 } else {
							  msgAlert("please select language");
						 }
					}
			   });


			   bottomSheetDialog.setContentView(view1);
			   bottomSheetDialog.show();

		  }

	 }

	 // error msg
	 private void msgAlert(String msg) {

		  if ( getActivity() != null ) {
			   AlertDialog.Builder al = new AlertDialog.Builder(getActivity());
			   al.setMessage(msg)
					   .setNegativeButton("try again" , null);
			   al.create();
			   al.show();

		  }
	 }


}
