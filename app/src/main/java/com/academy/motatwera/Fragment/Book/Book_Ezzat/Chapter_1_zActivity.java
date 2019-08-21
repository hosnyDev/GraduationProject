package com.academy.motatwera.Fragment.Book.Book_Ezzat;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.academy.motatwera.Fragment.Book.Book_Ezzat.Q_CZ1.Qcz1Activity;
import com.academy.motatwera.R;
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import info.hoang8f.widget.FButton;

public class Chapter_1_zActivity extends AppCompatActivity {


	 // view
	 private FButton quiz_c1_dz;
	 private ImageView a_z, b_z, c_z, d_z, e_z, f_z, g_z,
			 h_z, i_z, j_z, k_z, l_z, m_z, n_z,
			 o_z, p_z, q_z, r_z, s_z, t_z, u_z,
			 v_z, w_z, x_z, y_z, z_z,
			 aa_z, bb_z, cc_z, dd_z;

	 private TextView txtz1, txtz2, txtz3, txtz4, txtz5, txtz6, txtz7, txtz8, txtz9, txtz10,
			 txtz11, txtz12, txtz13, txtz14, txtz15, txtz16, txtz17, txtz18, txtz19, txtz20,
			 txtz21, txtz22, txtz23, txtz24, txtz25, txtz26, txtz27, txtz28, txtz29, txtz30,
			 txtz31, txtz32, txtz33, txtz34, txtz35, txtz36, txtz37, txtz38, txtz39, txtz40,
			 txtz41, txtz42, txtz43, txtz44, txtz45, txtz46, txtz47, txtz48, txtz49, txtz50, txtz51, txtz52, txtz53;

	 private RelativeLayout back_C1_z;

	 // FIREBASE
	 private FirebaseAuth mAuth;
	 private String uID;
	 private DocumentReference mCollection;
	 private FirebaseFirestore firebaseFirestore;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_chapter_1_z);


		  // view

		  back_C1_z = findViewById(R.id.back_C1_z);

		  a_z = findViewById(R.id.a_z);
		  b_z = findViewById(R.id.b_z);
		  c_z = findViewById(R.id.c_z);
		  d_z = findViewById(R.id.d_z);
		  e_z = findViewById(R.id.e_z);
		  f_z = findViewById(R.id.f_z);
		  g_z = findViewById(R.id.g_z);
		  h_z = findViewById(R.id.h_z);
		  i_z = findViewById(R.id.i_z);
		  j_z = findViewById(R.id.j_z);
		  k_z = findViewById(R.id.k_z);
		  l_z = findViewById(R.id.l_z);
		  m_z = findViewById(R.id.m_z);
		  n_z = findViewById(R.id.n_z);
		  o_z = findViewById(R.id.o_z);
		  p_z = findViewById(R.id.p_z);
		  q_z = findViewById(R.id.q_z);
		  r_z = findViewById(R.id.r_z);
		  s_z = findViewById(R.id.s_z);
		  t_z = findViewById(R.id.t_z);
		  u_z = findViewById(R.id.u_z);
		  v_z = findViewById(R.id.v_z);
		  w_z = findViewById(R.id.w_z);
		  x_z = findViewById(R.id.x_z);
		  y_z = findViewById(R.id.y_z);
		  z_z = findViewById(R.id.z_z);
		  aa_z = findViewById(R.id.aa_z);
		  bb_z = findViewById(R.id.bb_z);
		  cc_z = findViewById(R.id.cc_z);
		  dd_z = findViewById(R.id.dd_z);

		  quiz_c1_dz = findViewById(R.id.quiz_c1_dz);

		  txtz1 = findViewById(R.id.txtz1);
		  txtz2 = findViewById(R.id.txtz2);
		  txtz3 = findViewById(R.id.txtz3);
		  txtz4 = findViewById(R.id.txtz4);
		  txtz5 = findViewById(R.id.txtz5);
		  txtz6 = findViewById(R.id.txtz6);
		  txtz7 = findViewById(R.id.txtz7);
		  txtz8 = findViewById(R.id.txtz8);
		  txtz9 = findViewById(R.id.txtz9);
		  txtz10 = findViewById(R.id.txtz10);
		  txtz11 = findViewById(R.id.txtz11);
		  txtz12 = findViewById(R.id.txtz12);
		  txtz13 = findViewById(R.id.txtz13);
		  txtz14 = findViewById(R.id.txtz14);
		  txtz15 = findViewById(R.id.txtz15);
		  txtz16 = findViewById(R.id.txtz16);
		  txtz17 = findViewById(R.id.txtz17);
		  txtz18 = findViewById(R.id.txtz18);
		  txtz19 = findViewById(R.id.txtz19);
		  txtz20 = findViewById(R.id.txtz20);
		  txtz21 = findViewById(R.id.txtz21);
		  txtz22 = findViewById(R.id.txtz22);
		  txtz23 = findViewById(R.id.txtz23);
		  txtz24 = findViewById(R.id.txtz24);
		  txtz25 = findViewById(R.id.txtz25);
		  txtz26 = findViewById(R.id.txtz26);
		  txtz27 = findViewById(R.id.txtz27);
		  txtz28 = findViewById(R.id.txtz28);
		  txtz29 = findViewById(R.id.txtz29);
		  txtz30 = findViewById(R.id.txtz30);
		  txtz31 = findViewById(R.id.txtz31);
		  txtz32 = findViewById(R.id.txtz32);
		  txtz33 = findViewById(R.id.txtz33);
		  txtz34 = findViewById(R.id.txtz34);
		  txtz35 = findViewById(R.id.txtz35);
		  txtz36 = findViewById(R.id.txtz36);
		  txtz37 = findViewById(R.id.txtz37);
		  txtz38 = findViewById(R.id.txtz38);
		  txtz39 = findViewById(R.id.txtz39);
		  txtz40 = findViewById(R.id.txtz40);
		  txtz41 = findViewById(R.id.txtz41);
		  txtz42 = findViewById(R.id.txtz42);
		  txtz43 = findViewById(R.id.txtz43);
		  txtz44 = findViewById(R.id.txtz44);
		  txtz45 = findViewById(R.id.txtz45);
		  txtz46 = findViewById(R.id.txtz46);
		  txtz47 = findViewById(R.id.txtz47);
		  txtz48 = findViewById(R.id.txtz48);
		  txtz49 = findViewById(R.id.txtz49);
		  txtz50 = findViewById(R.id.txtz50);
		  txtz51 = findViewById(R.id.txtz51);
		  txtz52 = findViewById(R.id.txtz52);
		  txtz53 = findViewById(R.id.txtz53);


		  // get font size from shared preferences
		  // and set in textView
		  getFontSizeShared();

		  // get background color from shared preferences
		  // and set textView color and background color
		  getColorBackgroundShared();

		  // set color and shadow in button
		  btnColor();

		  // FIREBASE
		  mAuth = FirebaseAuth.getInstance();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  uID = mAuth.getCurrentUser().getUid();


		  // on click to start quiz
		  quiz_c1_dz.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					startQuiz();

			   }
		  });


		  // on click image a
		  a_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(1);
			   }
		  });

		  b_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(2);
			   }
		  });

		  c_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(3);
			   }
		  });

		  d_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(4);
			   }
		  });

		  e_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(5);
			   }
		  });

		  f_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(6);
			   }
		  });


		  g_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(7);
			   }
		  });

		  h_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(8);
			   }
		  });

		  i_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(9);
			   }
		  });

		  j_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(10);
			   }
		  });

		  k_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(11);
			   }
		  });

		  l_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(12);
			   }
		  });

		  m_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(13);
			   }
		  });

		  n_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(14);
			   }
		  });

		  o_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(15);
			   }
		  });

		  p_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(16);
			   }
		  });

		  q_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(17);
			   }
		  });

		  r_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(18);
			   }
		  });

		  s_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(19);
			   }
		  });


		  t_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(20);
			   }
		  });

		  u_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(21);
			   }
		  });

		  v_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(22);
			   }
		  });

		  w_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(23);
			   }
		  });


		  x_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(24);
			   }
		  });


		  y_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(25);
			   }
		  });


		  z_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(26);
			   }
		  });

		  aa_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(27);
			   }
		  });


		  bb_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(28);
			   }
		  });

		  cc_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(29);
			   }
		  });

		  dd_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(30);
			   }
		  });


	 }


	 // method to open image in alert dialog and mack zoom in image
	 private void ZoomClick(int i) {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  LayoutInflater inflater = LayoutInflater.from(this);
		  View view1 = inflater.inflate(R.layout.zoom_image_book , null);

		  al.setView(view1);
		  ImageView img = view1.findViewById(R.id.zoomImageBook);

		  if ( i == 1 ) {

			   img.setImageResource(R.drawable.a_z);

		  } else if ( i == 2 ) {

			   img.setImageResource(R.drawable.b_z);

		  } else if ( i == 3 ) {

			   img.setImageResource(R.drawable.c_z);

		  } else if ( i == 4 ) {

			   img.setImageResource(R.drawable.d_z);

		  } else if ( i == 5 ) {

			   img.setImageResource(R.drawable.e_z);

		  } else if ( i == 6 ) {

			   img.setImageResource(R.drawable.f_z);

		  } else if ( i == 7 ) {

			   img.setImageResource(R.drawable.g_z);

		  } else if ( i == 8 ) {

			   img.setImageResource(R.drawable.h_z);

		  } else if ( i == 9 ) {

			   img.setImageResource(R.drawable.i_z);

		  } else if ( i == 10 ) {

			   img.setImageResource(R.drawable.j_z);

		  } else if ( i == 11 ) {

			   img.setImageResource(R.drawable.k_z);

		  } else if ( i == 12 ) {

			   img.setImageResource(R.drawable.l_z);

		  } else if ( i == 13 ) {

			   img.setImageResource(R.drawable.m_z);

		  } else if ( i == 14 ) {

			   img.setImageResource(R.drawable.n_z);

		  } else if ( i == 15 ) {

			   img.setImageResource(R.drawable.o_z);

		  } else if ( i == 16 ) {

			   img.setImageResource(R.drawable.p_z);

		  } else if ( i == 17 ) {

			   img.setImageResource(R.drawable.q_z);

		  } else if ( i == 18 ) {

			   img.setImageResource(R.drawable.r_z);

		  } else if ( i == 19 ) {

			   img.setImageResource(R.drawable.s_z);

		  } else if ( i == 20 ) {

			   img.setImageResource(R.drawable.t_z);

		  } else if ( i == 21 ) {

			   img.setImageResource(R.drawable.u_z);

		  } else if ( i == 22 ) {

			   img.setImageResource(R.drawable.v_z);

		  } else if ( i == 23 ) {

			   img.setImageResource(R.drawable.w_z);

		  } else if ( i == 24 ) {

			   img.setImageResource(R.drawable.x_z);

		  } else if ( i == 25 ) {

			   img.setImageResource(R.drawable.y_z);

		  } else if ( i == 26 ) {

			   img.setImageResource(R.drawable.z_z);

		  } else if ( i == 27 ) {

			   img.setImageResource(R.drawable.aa_z);

		  } else if ( i == 28 ) {

			   img.setImageResource(R.drawable.bb_z);

		  } else if ( i == 29 ) {

			   img.setImageResource(R.drawable.cc_z);

		  } else if ( i == 30 ) {

			   img.setImageResource(R.drawable.dd_z);

		  }

		  //Zooming Image View Table
		  ImageMatrixTouchHandler zoom = new ImageMatrixTouchHandler(this);
		  img.setOnTouchListener(new ImageMatrixTouchHandler(this));
		  zoom.getMode();
		  img.performClick();

		  al.create();
		  al.show();


	 }

	 // get shared preferences font size
	 private void getFontSizeShared() {
		  // get shared preference
		  SharedPreferences readeShared = getSharedPreferences("fontSize" , MODE_PRIVATE);

		  if ( readeShared != null ) {
			   String size = readeShared.getString("size" , null);
			   if ( size != null && size.length() > 0 ) {
					if ( size.equals("s") ) {

						 setFontSize(18);

					} else if ( size.equals("m") ) {

						 setFontSize(20);

					} else if ( size.equals("l") ) {

						 setFontSize(24);
					}
			   }
		  }
	 }

	 // set font size
	 private void setFontSize(float size) {
		  txtz1.setTextSize(size);
		  txtz2.setTextSize(size);
		  txtz3.setTextSize(size);
		  txtz4.setTextSize(size);
		  txtz5.setTextSize(size);
		  txtz6.setTextSize(size);
		  txtz7.setTextSize(size);
		  txtz8.setTextSize(size);
		  txtz9.setTextSize(size);
		  txtz10.setTextSize(size);
		  txtz11.setTextSize(size);
		  txtz12.setTextSize(size);
		  txtz13.setTextSize(size);
		  txtz14.setTextSize(size);
		  txtz15.setTextSize(size);
		  txtz16.setTextSize(size);
		  txtz17.setTextSize(size);
		  txtz18.setTextSize(size);
		  txtz19.setTextSize(size);
		  txtz20.setTextSize(size);
		  txtz21.setTextSize(size);
		  txtz22.setTextSize(size);
		  txtz23.setTextSize(size);
		  txtz24.setTextSize(size);
		  txtz25.setTextSize(size);
		  txtz26.setTextSize(size);
		  txtz27.setTextSize(size);
		  txtz28.setTextSize(size);
		  txtz29.setTextSize(size);
		  txtz30.setTextSize(size);
		  txtz31.setTextSize(size);
		  txtz32.setTextSize(size);
		  txtz33.setTextSize(size);
		  txtz34.setTextSize(size);
		  txtz35.setTextSize(size);
		  txtz36.setTextSize(size);
		  txtz37.setTextSize(size);
		  txtz38.setTextSize(size);
		  txtz39.setTextSize(size);
		  txtz40.setTextSize(size);
		  txtz41.setTextSize(size);
		  txtz42.setTextSize(size);
		  txtz43.setTextSize(size);
		  txtz44.setTextSize(size);
		  txtz45.setTextSize(size);
		  txtz46.setTextSize(size);
		  txtz47.setTextSize(size);
		  txtz48.setTextSize(size);
		  txtz49.setTextSize(size);
		  txtz50.setTextSize(size);
		  txtz51.setTextSize(size);
		  txtz52.setTextSize(size);
		  txtz53.setTextSize(size);
	 }

	 // get shared preferences color background
	 private void getColorBackgroundShared() {
		  // get shared preference
		  SharedPreferences readeShared = getSharedPreferences("colorBackground" , MODE_PRIVATE);

		  if ( readeShared != null ) {
			   String color = readeShared.getString("color" , null);
			   if ( color != null && color.length() > 0 ) {
					if ( color.equals("w") ) {

						 setBackgroundColor(getResources().getColor(R.color.white) , getResources().getColor(R.color.b2b2b2));

					} else if ( color.equals("b") ) {

						 setBackgroundColor(getResources().getColor(R.color.b2b2b2) , getResources().getColor(R.color.white));

					}
			   }
		  }
	 }

	 // set font size
	 private void setBackgroundColor(int colorBackground , int textColor) {
		  back_C1_z.setBackgroundColor(colorBackground);


		  txtz1.setTextColor(textColor);
		  txtz2.setTextColor(textColor);
		  txtz3.setTextColor(textColor);
		  txtz4.setTextColor(textColor);
		  txtz5.setTextColor(textColor);
		  txtz6.setTextColor(textColor);
		  txtz7.setTextColor(textColor);
		  txtz8.setTextColor(textColor);
		  txtz9.setTextColor(textColor);
		  txtz10.setTextColor(textColor);
		  txtz11.setTextColor(textColor);
		  txtz12.setTextColor(textColor);
		  txtz13.setTextColor(textColor);
		  txtz14.setTextColor(textColor);
		  txtz15.setTextColor(textColor);
		  txtz16.setTextColor(textColor);
		  txtz17.setTextColor(textColor);
		  txtz18.setTextColor(textColor);
		  txtz19.setTextColor(textColor);
		  txtz20.setTextColor(textColor);
		  txtz21.setTextColor(textColor);
		  txtz22.setTextColor(textColor);
		  txtz23.setTextColor(textColor);
		  txtz24.setTextColor(textColor);
		  txtz25.setTextColor(textColor);
		  txtz26.setTextColor(textColor);
		  txtz27.setTextColor(textColor);
		  txtz28.setTextColor(textColor);
		  txtz29.setTextColor(textColor);
		  txtz30.setTextColor(textColor);
		  txtz31.setTextColor(textColor);
		  txtz32.setTextColor(textColor);
		  txtz33.setTextColor(textColor);
		  txtz34.setTextColor(textColor);
		  txtz35.setTextColor(textColor);
		  txtz36.setTextColor(textColor);
		  txtz37.setTextColor(textColor);
		  txtz38.setTextColor(textColor);
		  txtz39.setTextColor(textColor);
		  txtz40.setTextColor(textColor);
		  txtz41.setTextColor(textColor);
		  txtz42.setTextColor(textColor);
		  txtz43.setTextColor(textColor);
		  txtz44.setTextColor(textColor);
		  txtz45.setTextColor(textColor);
		  txtz46.setTextColor(textColor);
		  txtz47.setTextColor(textColor);
		  txtz48.setTextColor(textColor);
		  txtz49.setTextColor(textColor);
		  txtz50.setTextColor(textColor);
		  txtz51.setTextColor(textColor);
		  txtz52.setTextColor(textColor);
		  txtz53.setTextColor(textColor);
	 }

	 //set color in FButton  library
	 private void btnColor() {
		  quiz_c1_dz.setButtonColor(getResources().getColor(R.color.colorPrimary));
		  quiz_c1_dz.setShadowColor(getResources().getColor(R.color.colorAccent));
		  quiz_c1_dz.setShadowEnabled(true);
		  quiz_c1_dz.setShadowHeight(5);
		  quiz_c1_dz.setCornerRadius(5);
	 }

	 // start quiz method
	 private void startQuiz() {

		  startActivity(new Intent(this , Qcz1Activity.class));

	 }

	 @Override
	 public void onBackPressed() {
		  super.onBackPressed();
		  finish();
	 }
}
