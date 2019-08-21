package com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_3_bassem;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.academy.motatwera.R;

public class Chapter_3_b_Activity extends AppCompatActivity {


	 // view

	 // background and text color
	 private TextView txt1, txt2, txt3;
	 private RelativeLayout back_C3_B;

	 private ImageView up_3;
	 private ScrollView scrollView_3;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_chapter_3_b_);

		  // view
		  back_C3_B = findViewById(R.id.back_C3_B);
		  txt1 = findViewById(R.id.txt1C3b);
		  txt2 = findViewById(R.id.txt2C3b);
		  txt3 = findViewById(R.id.txt3C3b);

		  scrollView_3 = findViewById(R.id.scrollView_3);
		  up_3 = findViewById(R.id.up_3);

		  // get font size from shared preferences
		  // and set in textView
		  getFontSizeShared();

		  // get background color from shared preferences
		  // and set textView color and background color
		  getColorBackgroundShared();


		  scrollView_3.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			   @Override
			   public void onScrollChanged() {
					if ( scrollView_3 != null ) {
						 if ( scrollView_3.getChildAt(0).getBottom() <= (scrollView_3.getHeight() + scrollView_3.getScrollY()) ) {
							  up_3.setVisibility(View.VISIBLE);
							  up_3.setOnClickListener(new View.OnClickListener() {
								   @Override
								   public void onClick(View view) {
										scrollView_3.fullScroll(ScrollView.FOCUS_UP);
								   }
							  });
						 } else {
							  up_3.setVisibility(View.GONE);
						 }
					}
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
		  back_C3_B.setBackgroundColor(colorBackground);
		  txt1.setTextColor(textColor);
		  txt2.setTextColor(textColor);
		  txt3.setTextColor(textColor);
	 }


}
