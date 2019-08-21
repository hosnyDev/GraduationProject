package com.academy.motatwera;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import info.hoang8f.widget.FButton;

public class RegisterActivity extends AppCompatActivity {

	 // view
	 private MaterialRippleLayout btn_Register;
	 private EditText txtEmailR;
	 private EditText txtPassR;
	 private EditText txtUserNameR;
	 private EditText txtIDR;
	 private EditText txtPhoneNumberR;
	 private ProgressBar progressBarRegister;

	 private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	 private String email;
	 private String pass;
	 private String userName;
	 private String id;
	 private String phone;

	 // firebase
	 private FirebaseAuth mAth;
	 private FirebaseFirestore mFirebaseFirestore;
	 private String uID;
	 private DocumentReference mCollection;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
 		  super.onCreate(savedInstanceState);
		  Bar();
		  setContentView(R.layout.activity_register);

		  // view
		  btn_Register = findViewById(R.id.btn_Register);
		  txtEmailR = findViewById(R.id.txtEmailR);
		  txtPassR = findViewById(R.id.txtPassR);
		  txtUserNameR = findViewById(R.id.txtUserNameR);
		  txtIDR = findViewById(R.id.txtIDR);
		  txtPhoneNumberR = findViewById(R.id.txtPhoneNumberR);
		  progressBarRegister = findViewById(R.id.progressBarRegister);


		  // firebase
		  mAth = FirebaseAuth.getInstance();
		  mFirebaseFirestore = FirebaseFirestore.getInstance();

		  // to get email address in a device user and set in txt email address
		  Pattern emailPattern = Patterns.EMAIL_ADDRESS; // API level 8+
		  Account[] accounts = AccountManager.get(RegisterActivity.this).getAccounts();
		  for ( Account account : accounts ) {
			   if ( emailPattern.matcher(account.name).matches() ) {
					String possibleEmail = account.name;
					txtEmailR.setText(possibleEmail);
			   }
		  }


		  // set on click to button register
		  btn_Register.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					validationError();

			   }
		  });

	 }

	 // check data is not empty
	 private void validationError() {

		  email = txtEmailR.getText().toString();
		  pass = txtPassR.getText().toString();
		  userName = txtUserNameR.getText().toString();
		  id = txtIDR.getText().toString();
		  phone = txtPhoneNumberR.getText().toString();

		  if ( email.isEmpty() ) {

			   errorMsg("Must be add email");
			   txtEmailR.requestFocus();

		  } else if ( pass.isEmpty() ) {

			   errorMsg("Must be add password");
			   txtPassR.requestFocus();

		  } else if ( pass.length() < 6 ) {

			   errorMsg("Must be password greater than 6 digit");
			   txtPassR.requestFocus();

		  } else if ( userName.isEmpty() ) {

			   errorMsg("Must be add user name");
			   txtUserNameR.requestFocus();

		  } else if ( id.isEmpty() ) {

			   errorMsg("Must be add ID");
			   txtIDR.requestFocus();

		  } else if ( id.length() < 8 ) {

			   errorMsg("Must be ID equal 8 digit");
			   txtIDR.requestFocus();

		  } else if ( phone.isEmpty() ) {

			   errorMsg("Must be add phone");

			   txtPhoneNumberR.requestFocus();

		  } else if ( phone.length() < 11 ) {

			   errorMsg("invalid phone number");

			   txtPhoneNumberR.requestFocus();

		  } else if ( email.matches(emailPattern) ) {

			   FirebaseRegister();

		  } else {

			   errorMsg("invalid Email Address");
			   txtEmailR.requestFocus();

		  }

	 }

	 // to add data in firebase auth
	 private void FirebaseRegister() {

		  progressBarRegister.setVisibility(View.VISIBLE);

		  // create email and password for register
		  mAth.createUserWithEmailAndPassword(email , pass)
				  .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
					   @Override
					   public void onComplete(@NonNull Task<AuthResult> task) {

							if ( task.isSuccessful() ) {

								 // save student data in firebaseFirestore
								 saveStudentData();

							} else {

								 // stop progressBar
								 progressBarRegister.setVisibility(View.INVISIBLE);

								 // show error massage
								 String error = task.getException().getMessage();


								 if ( error.contains("The email address is already in use by another account") ) {

									  errorMsg("the email address is already in use by another  ");

								 } else if ( error.contains("A network error") ) {

									  errorMsg("No internet connection");

								 }
							}

					   }
				  });

	 }

	 // to save student data in firebase firestore
	 private void saveStudentData() {

		  // to get user id from firebase
		  uID = mAth.getCurrentUser().getUid();

		  // create hash map
		  HashMap<String, Object> data = new HashMap<>();
		  data.put("email" , email);
		  data.put("pass" , pass);
		  data.put("userName" , userName);
		  data.put("ID" , id);
		  data.put("phone" , phone);
		  data.put("img" , "no");

		  // mack collection in firebase firestore
		  mCollection = mFirebaseFirestore.collection("student_registration").document(uID);

		  // add data to collection
		  mCollection.set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
			   @Override
			   public void onComplete(@NonNull Task<Void> task) {

					// to check thw data is save successful or not
					if ( task.isSuccessful() ) {

						 // save score data
						 saveScore();

					} else {

						 progressBarRegister.setVisibility(View.INVISIBLE);
						 // handel error
						 String error = task.getException().getMessage();

						 errorMsg(error);

					}

			   }
		  });


	 }

	 // save score data in firebase
	 private void saveScore() {

		  //  get user ID
		  uID = mAth.getCurrentUser().getUid();

		  // save score data doctor bassem
		  String Level_D_Bassem = "Level 1";
		  int score_D_Bassem = 0;

		  String Value1_D_Bassem = "0/10";
		  String ImageState1_D_Bassem = "1";
		  String Rate1_D_Bassem = "0";
		  String Statues1_D_Bassem = "0";

		  String Value2_D_Bassem = "0/10";
		  String ImageState2_D_Bassem = "0";
		  String Rate2_D_Bassem = "0";
		  String Statues2_D_Bassem = "0";

		  String Value3_D_Bassem = "0/10";
		  String ImageState3_D_Bassem = "0";
		  String Rate3_D_Bassem = "0";
		  String Statues3_D_Bassem = "0";

		  String Value4_D_Bassem = "0/10";
		  String ImageState4_D_Bassem = "0";
		  String Rate4_D_Bassem = "0";
		  String Statues4_D_Bassem = "0";

		  String Value5_D_Bassem = "0/10";
		  String ImageState5_D_Bassem = "0";
		  String Rate5_D_Bassem = "0";
		  String Statues5_D_Bassem = "0";

		  // create hashMap to save data in collection doctor bassem
		  HashMap<String, Object> data_bassem = new HashMap<>();

		  data_bassem.put("email" , email);
		  data_bassem.put("userName" , userName);

		  data_bassem.put("score" , score_D_Bassem);
		  data_bassem.put("level" , Level_D_Bassem);

		  // level 1
		  data_bassem.put("Value1_D_Bassem" , Value1_D_Bassem);
		  data_bassem.put("ImageState1_D_Bassem" , ImageState1_D_Bassem);
		  data_bassem.put("Rate1_D_Bassem" , Rate1_D_Bassem);
		  data_bassem.put("Statues1_D_Bassem" , Statues1_D_Bassem);

		  // level 2
		  data_bassem.put("Value2_D_Bassem" , Value2_D_Bassem);
		  data_bassem.put("ImageState2_D_Bassem" , ImageState2_D_Bassem);
		  data_bassem.put("Rate2_D_Bassem" , Rate2_D_Bassem);
		  data_bassem.put("Statues2_D_Bassem" , Statues2_D_Bassem);

		  // level 3
		  data_bassem.put("Value3_D_Bassem" , Value3_D_Bassem);
		  data_bassem.put("ImageState3_D_Bassem" , ImageState3_D_Bassem);
		  data_bassem.put("Rate3_D_Bassem" , Rate3_D_Bassem);
		  data_bassem.put("Statues3_D_Bassem" , Statues3_D_Bassem);

		  // level 4
		  data_bassem.put("Value4_D_Bassem" , Value4_D_Bassem);
		  data_bassem.put("ImageState4_D_Bassem" , ImageState4_D_Bassem);
		  data_bassem.put("Rate4_D_Bassem" , Rate4_D_Bassem);
		  data_bassem.put("Statues4_D_Bassem" , Statues4_D_Bassem);

		  // level 5
		  data_bassem.put("Value5_D_Bassem" , Value5_D_Bassem);
		  data_bassem.put("ImageState5_D_Bassem" , ImageState5_D_Bassem);
		  data_bassem.put("Rate5_D_Bassem" , Rate5_D_Bassem);
		  data_bassem.put("Statues5_D_Bassem" , Statues5_D_Bassem);

		  // mack collection in firebase firestore
		  mCollection = mFirebaseFirestore.collection("book_doctor_baseem").document(uID);


		  // mack collection in firebase firestore
		  mCollection.set(data_bassem).addOnCompleteListener(new OnCompleteListener<Void>() {
			   @Override
			   public void onComplete(@NonNull Task<Void> task) {

					if ( task.isSuccessful() ) {

						 progressBarRegister.setVisibility(View.INVISIBLE);
						 goToMain();

					} else {
						 progressBarRegister.setVisibility(View.INVISIBLE);
						 // handel error
						 String error = task.getException().getMessage();
						 errorMsg(error);
					}

			   }
		  });

	 }

	 // Intent to home activity
	 private void goToMain() {

		  startActivity(new Intent(this , MainActivity.class));
		  finish();

	 }


	 // to show alert dialog error message
	 private void errorMsg(String msg) {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  al.setMessage(msg)
				  .setNegativeButton("try again" , null);
		  al.create();
		  al.show();

	 }



	 //  Method To change  status bar color
	 private void Bar() {

		  Window window = getWindow();
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP ) {
			   window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			   SystemBarTintManager tintManager = new SystemBarTintManager(this);
			   tintManager.setStatusBarTintEnabled(true);
			   tintManager.setTintColor(ContextCompat.getColor(this , R.color.colorPrimary));
		  }
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
			   window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
			   window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
		  }

	 }


}