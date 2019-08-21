package com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_5_bassem;

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

public class Chapter_5_b_Activity extends AppCompatActivity {


	 // view

	 // background and text color
	 private TextView txt1, txt2, txt3, txt4, txt5, txt6;
	 private RelativeLayout back_C5_B;


	 private ImageView up_5;
	 private ScrollView scrollView_5;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_chapter_5_b_);


		  back_C5_B = findViewById(R.id.back_C5_B);
		  txt1 = findViewById(R.id.txt1C5b);
		  txt2 = findViewById(R.id.txt2C5b);
		  txt3 = findViewById(R.id.txt3C5b);
		  txt4 = findViewById(R.id.txt4C5b);
		  txt5 = findViewById(R.id.txt5C5b);
		  txt6 = findViewById(R.id.txt6C5b);


		  scrollView_5 = findViewById(R.id.scrollView_5);
		  up_5 = findViewById(R.id.up_5);

		  // get font size from shared preferences
		  // and set in textView
		  getFontSizeShared();

		  // get background color from shared preferences
		  // and set textView color and background color
		  getColorBackgroundShared();



		  scrollView_5.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			   @Override
			   public void onScrollChanged() {
					if ( scrollView_5 != null ) {
						 if ( scrollView_5.getChildAt(0).getBottom() <= (scrollView_5.getHeight() + scrollView_5.getScrollY()) ) {
							  up_5.setVisibility(View.VISIBLE);
							  up_5.setOnClickListener(new View.OnClickListener() {
								   @Override
								   public void onClick(View view) {
										scrollView_5.fullScroll(ScrollView.FOCUS_UP);
								   }
							  });
						 } else {
							  up_5.setVisibility(View.GONE);
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
		  txt4.setTextSize(size);
		  txt5.setTextSize(size);
		  txt6.setTextSize(size);
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
		  back_C5_B.setBackgroundColor(colorBackground);
		  txt1.setTextColor(textColor);
		  txt2.setTextColor(textColor);
		  txt3.setTextColor(textColor);
		  txt4.setTextColor(textColor);
		  txt5.setTextColor(textColor);
		  txt6.setTextColor(textColor);
	 }

}
