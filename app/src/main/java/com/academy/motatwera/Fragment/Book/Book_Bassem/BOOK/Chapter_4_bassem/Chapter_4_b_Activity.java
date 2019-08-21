package com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_4_bassem;

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

public class Chapter_4_b_Activity extends AppCompatActivity {


	 // view
	 private ImageView ccb_a, ccb_b, ccb_c, ccb_d, ccb_e;

	 // background and text color
	 private TextView txt1, txt2, txt3;
	 private RelativeLayout back_C4_B;

	 private ImageView up_4;
	 private ScrollView scrollView_4;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_chapter_4_b_);


		  // view
		  ccb_a = findViewById(R.id.ccb_a);
		  ccb_b = findViewById(R.id.ccb_b);
		  ccb_c = findViewById(R.id.ccb_c);
		  ccb_d = findViewById(R.id.ccb_d);
		  ccb_e = findViewById(R.id.ccb_e);

		  back_C4_B = findViewById(R.id.back_C4_B);
		  txt1 = findViewById(R.id.txt1C4b);
		  txt2 = findViewById(R.id.txt2C4b);
		  txt3 = findViewById(R.id.txt3C4b);


		  scrollView_4 = findViewById(R.id.scrollView_4);
		  up_4 = findViewById(R.id.up_4);

		  // get font size from shared preferences
		  // and set in textView
		  getFontSizeShared();

		  // get background color from shared preferences
		  // and set textView color and background color
		  getColorBackgroundShared();

		  // on click img a
		  ccb_a.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(1);
			   }
		  });

		  // on click img b
		  ccb_b.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(2);
			   }
		  });


		  // on click img c
		  ccb_c.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(3);
			   }
		  });

		  // on click img d
		  ccb_d.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(4);
			   }
		  });

		  // on click img e
		  ccb_e.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(5);
			   }
		  });


		  scrollView_4.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			   @Override
			   public void onScrollChanged() {
					if ( scrollView_4 != null ) {
						 if ( scrollView_4.getChildAt(0).getBottom() <= (scrollView_4.getHeight() + scrollView_4.getScrollY()) ) {
							  up_4.setVisibility(View.VISIBLE);
							  up_4.setOnClickListener(new View.OnClickListener() {
								   @Override
								   public void onClick(View view) {
										scrollView_4.fullScroll(ScrollView.FOCUS_UP);
								   }
							  });
						 } else {
							  up_4.setVisibility(View.GONE);
						 }
					}
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

			   img.setImageResource(R.drawable.ccb_a);

		  } else if ( i == 2 ) {

			   img.setImageResource(R.drawable.ccb_b);

		  } else if ( i == 3 ) {

			   img.setImageResource(R.drawable.ccb_c);

		  } else if ( i == 4 ) {

			   img.setImageResource(R.drawable.ccb_d);

		  } else if ( i == 5 ) {

			   img.setImageResource(R.drawable.ccb_e);

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
		  back_C4_B.setBackgroundColor(colorBackground);
		  txt1.setTextColor(textColor);
		  txt2.setTextColor(textColor);
		  txt3.setTextColor(textColor);
	 }



}
