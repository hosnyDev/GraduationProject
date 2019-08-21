package com.academy.motatwera;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class LoginActivity extends AppCompatActivity {


	 // view
	 private FloatingActionButton mLogin;
	 private TextView mRegister;
	 private EditText txtEmailLogin;
	 private EditText txtPassLogin;
	 private ProgressBar progressBarLogin;
	 private ImageView logoLogin;

	 private String email;
	 private String pass;

	 private final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


	 // firebase
	 private FirebaseAuth mAth;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  Bar();
		  setContentView(R.layout.activity_login);

		  // view
		  mLogin = findViewById(R.id.btnLogin);
		  mRegister = findViewById(R.id.btnRegisterLogin);
		  txtEmailLogin = findViewById(R.id.txtEmailLogin);
		  txtPassLogin = findViewById(R.id.txtPassLogin);
		  progressBarLogin = findViewById(R.id.progressBarLogin);
		  logoLogin = findViewById(R.id.logoLogin);

		  // firebase
		  mAth = FirebaseAuth.getInstance();

		  // intent to registration activity
		  mRegister.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(LoginActivity.this , RegisterActivity.class));

			   }
		  });

		  animyButton(mLogin);
		  animyText(mRegister);

		  // on click to login
		  mLogin.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					mLogin.setEnabled(false);
					validationError();

			   }
		  });


	 }


	 // check if data is successful or not
	 private void validationError() {

		  email = txtEmailLogin.getText().toString();
		  pass = txtPassLogin.getText().toString();

		  if ( email.isEmpty() ) {

			   errorMsg("must be add email");
			   txtEmailLogin.requestFocus();

		  } else if ( pass.isEmpty() ) {

			   errorMsg("must be add password");
			   txtPassLogin.requestFocus();

		  } else if ( pass.length() < 6 ) {

			   errorMsg("password must be grater than 6 digit");
			   txtPassLogin.requestFocus();

		  } else if ( email.matches(emailPattern) ) {

			   loginFirebase();

		  } else {

			   errorMsg("invalid email address");

		  }

	 }

	 // method to connection to firebase
	 private void loginFirebase() {

		  progressBarLogin.setVisibility(View.VISIBLE);
		  mAth.signInWithEmailAndPassword(email , pass)
				  .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
					   @Override
					   public void onComplete(@NonNull Task<AuthResult> task) {
							if ( task.isSuccessful() ) {
								 progressBarLogin.setVisibility(View.INVISIBLE);

								 // save count notification in shared preferences
								 notification();
								 SendToMain();

							} else {
								 progressBarLogin.setVisibility(View.GONE);
								 // handel error
								 String error = task.getException().getMessage();
								 errorMsg(error);
								 mLogin.setEnabled(true);
								 // Log.d(TAG , task.getException().getMessage());
							}
					   }
				  });
	 }

	 // to show alert dialog error message
	 private void errorMsg(String msg) {
		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  al.setMessage(msg)
				  .setNegativeButton("try again" , null);
		  al.create();
		  al.show();
	 }

	 // on start method to check if user is login or not
	 @Override
	 public void onStart() {
		  super.onStart();

		  if ( mAth.getCurrentUser() != null ) {
			   SendToMain();
		  }

	 }

	 // intent to main activity
	 private void SendToMain() {
		  startActivity(new Intent(LoginActivity.this , MainActivity.class));
		  finish();

	 }

	 @Override
	 public void onBackPressed() {
		  super.onBackPressed();
		  finishAffinity();
	 }

	 private void animyButton(final FloatingActionButton button) {
		  button.setOnTouchListener(new View.OnTouchListener() {
			   @Override
			   public boolean onTouch(View view , MotionEvent motionEvent) {
					if ( motionEvent.getAction() == MotionEvent.ACTION_DOWN ) {
						 //perform your animation when button is touched and held
						 button.setBackgroundTintList
								 (ColorStateList.valueOf
										 (ContextCompat.getColor
												 (LoginActivity.this , R.color.back2)));

					} else if ( motionEvent.getAction() == MotionEvent.ACTION_UP ) {
						 //perform your animation when button is released
						 button.setBackgroundTintList
								 (ColorStateList.valueOf
										 (ContextCompat.getColor
												 (LoginActivity.this , R.color.colorPrimary)));
					}
					return false;
			   }
		  });
	 }

	 private void animyText(final TextView button) {
		  button.setOnTouchListener(new View.OnTouchListener() {
			   @Override
			   public boolean onTouch(View view , MotionEvent motionEvent) {
					if ( motionEvent.getAction() == MotionEvent.ACTION_DOWN ) {
						 //perform your animation when button is touched and held

						 button.setTextColor(getResources().getColor(R.color.back2));

					} else if ( motionEvent.getAction() == MotionEvent.ACTION_UP ) {
						 //perform your animation when button is released
						 button.setTextColor(getResources().getColor(R.color.b2b2b2));

					}
					return false;
			   }
		  });
	 }

	 // save notification data
	 private void notification() {

		  // save count in shared to use in push notification
		  getSharedPreferences("notificationNum" , MODE_PRIVATE)
				  .edit()
				  .putInt("countC1" , 0)
				  .putInt("stateC1" , 1)

				  .putInt("countC2" , 0)
				  .putInt("stateC2" , 0)

				  .putInt("countC3" , 0)
				  .putInt("stateC3" , 0)

				  .putInt("countC4" , 0)
				  .putInt("stateC4" , 0)

				  .putInt("countC5" , 0)
				  .putInt("stateC5" , 0)
				  .commit();

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
