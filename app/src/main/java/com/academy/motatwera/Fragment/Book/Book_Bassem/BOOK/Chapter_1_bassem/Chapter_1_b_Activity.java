package com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_1_bassem;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.academy.motatwera.R;
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Chapter_1_b_Activity extends AppCompatActivity {

	 // view
	 private ImageView cab_a;
	 private ImageView up;
	 private ScrollView scrollView;

	 // background and text color
	 private TextView txt1, txt2, txt3;
	 private RelativeLayout back_C1_B;

	 // FIREBASE
	 private FirebaseAuth mAuth;
	 private String uID;
	 private DocumentReference mCollection;
	 private FirebaseFirestore firebaseFirestore;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_chapter_1_b);

		  // view
		  cab_a = findViewById(R.id.cab_a);
		  txt1 = findViewById(R.id.txt1);
		  txt2 = findViewById(R.id.txt2);
		  txt3 = findViewById(R.id.txt3);
		  back_C1_B = findViewById(R.id.back_C1_B);
		  up = findViewById(R.id.up);
		  scrollView = findViewById(R.id.scrollView);

		  // get font size from shared preferences
		  // and set in textView
		  getFontSizeShared();

		  // get background color from shared preferences
		  // and set textView color and background color
		  getColorBackgroundShared();

		  // FIREBASE
		  mAuth = FirebaseAuth.getInstance();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  uID = mAuth.getCurrentUser().getUid();


		  scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			   @Override
			   public void onScrollChanged() {
					if ( scrollView != null ) {
						 if ( scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY()) ) {
							  up.setVisibility(View.VISIBLE);
							  up.setOnClickListener(new View.OnClickListener() {
								   @Override
								   public void onClick(View view) {
										scrollView.fullScroll(ScrollView.FOCUS_UP);
								   }
							  });
						 } else {
							  up.setVisibility(View.GONE);
						 }
					}
			   }
		  });


		  // on click to zoom image
		  cab_a.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick();
			   }
		  });


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
		  txt1.setTextSize(size);
		  txt2.setTextSize(size);
		  txt3.setTextSize(size);
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
		  back_C1_B.setBackgroundColor(colorBackground);
		  txt1.setTextColor(textColor);
		  txt2.setTextColor(textColor);
		  txt3.setTextColor(textColor);
	 }


	 // method to open image in alert dialog and mack zoom in image
	 private void ZoomClick() {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  LayoutInflater inflater = LayoutInflater.from(this);
		  View view1 = inflater.inflate(R.layout.zoom_image_book , null);

		  al.setView(view1);
		  ImageView img = view1.findViewById(R.id.zoomImageBook);

		  img.setImageResource(R.drawable.cab_a);

		  //Zooming Image View Table
		  ImageMatrixTouchHandler zoom = new ImageMatrixTouchHandler(this);
		  img.setOnTouchListener(new ImageMatrixTouchHandler(this));
		  zoom.getMode();
		  img.performClick();

		  al.create();
		  al.show();

	 }


}
