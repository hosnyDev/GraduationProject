package com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_2_bassem;

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

public class Chapter_2_b_Activity extends AppCompatActivity {


	 // view
	 private ImageView cbb_a, cbb_b, cbb_c, cbb_d, cbb_e, cbb_f, cbb_g, cbb_h;

	 private ImageView up_2;
	 private ScrollView scrollView_2;

	 // background and text color
	 private TextView txt1, txt2, txt3, txt4, txt5;
	 private RelativeLayout back_C2_B;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_chapter_2_b);

		  // view
		  cbb_a = findViewById(R.id.cbb_a);
		  cbb_b = findViewById(R.id.cbb_b);
		  cbb_c = findViewById(R.id.cbb_c);
		  cbb_d = findViewById(R.id.cbb_d);
		  cbb_e = findViewById(R.id.cbb_e);
		  cbb_f = findViewById(R.id.cbb_f);
		  cbb_g = findViewById(R.id.cbb_g);
		  cbb_h = findViewById(R.id.cbb_h);

		  back_C2_B = findViewById(R.id.back_C2_B);
		  txt1 = findViewById(R.id.txt1C2b);
		  txt2 = findViewById(R.id.txt2C2b);
		  txt3 = findViewById(R.id.txt3C2b);
		  txt4 = findViewById(R.id.txt4C2b);
		  txt5 = findViewById(R.id.txt5C2b);
		  scrollView_2 = findViewById(R.id.scrollView_2);
		  up_2 = findViewById(R.id.up_2);


		  // get font size from shared preferences
		  // and set in textView
		  getFontSizeShared();

		  // get background color from shared preferences
		  // and set textView color and background color
		  getColorBackgroundShared();


		  scrollView_2.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			   @Override
			   public void onScrollChanged() {
					if ( scrollView_2 != null ) {
						 if ( scrollView_2.getChildAt(0).getBottom() <= (scrollView_2.getHeight() + scrollView_2.getScrollY()) ) {
							  up_2.setVisibility(View.VISIBLE);
							  up_2.setOnClickListener(new View.OnClickListener() {
								   @Override
								   public void onClick(View view) {
										scrollView_2.fullScroll(ScrollView.FOCUS_UP);
								   }
							  });
						 } else {
							  up_2.setVisibility(View.GONE);
						 }
					}
			   }
		  });

		  // on click image a
		  cbb_a.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(1);
			   }
		  });

		  // on click image b
		  cbb_b.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(2);
			   }
		  });

		  // on click image c
		  cbb_c.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(3);
			   }
		  });

		  // on click image d
		  cbb_d.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(4);
			   }
		  });

		  // on click image e
		  cbb_e.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(5);
			   }
		  });

		  // on click image f
		  cbb_f.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(6);
			   }
		  });

		  // on click image g
		  cbb_g.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(7);
			   }
		  });

		  // on click image h
		  cbb_h.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					ZoomClick(8);
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

			   img.setImageResource(R.drawable.cbb_a);

		  } else if ( i == 2 ) {

			   img.setImageResource(R.drawable.cbb_b);

		  } else if ( i == 3 ) {

			   img.setImageResource(R.drawable.cbb_c);

		  } else if ( i == 4 ) {

			   img.setImageResource(R.drawable.cbb_d);

		  } else if ( i == 5 ) {

			   img.setImageResource(R.drawable.cbb_e);

		  } else if ( i == 6 ) {

			   img.setImageResource(R.drawable.cbb_f);

		  } else if ( i == 7 ) {

			   img.setImageResource(R.drawable.cbb_g);

		  } else if ( i == 8 ) {

			   img.setImageResource(R.drawable.cbb_h);

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
		  txt4.setTextSize(size);
		  txt5.setTextSize(size);
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
		  back_C2_B.setBackgroundColor(colorBackground);
		  txt1.setTextColor(textColor);
		  txt2.setTextColor(textColor);
		  txt3.setTextColor(textColor);
		  txt4.setTextColor(textColor);
		  txt5.setTextColor(textColor);
	 }



}
