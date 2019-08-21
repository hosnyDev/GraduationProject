package com.academy.motatwera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;

public class TableActivity extends AppCompatActivity {

	 // view
	 private Spinner spinnerTable;
	 private ImageView imgTable;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_table);

		  // view
		  spinnerTable = findViewById(R.id.spinnerTable);
		  imgTable = findViewById(R.id.imgTable);

		  // on click spinner

		  spinnerTable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			   @Override
			   public void onItemSelected(AdapterView<?> adapterView , View view , int i , long l) {

					if ( i == 0 ) {

						 setImage(R.drawable.a_n);

					} else if ( i == 1 ) {

						 setImage(R.drawable.a_t);

					} else if ( i == 2 ) {

						 setImage(R.drawable.b_n);

					} else if ( i == 3 ) {

						 setImage(R.drawable.a_t);

					} else if ( i == 4 ) {

						 setImage(R.drawable.c_n);

					} else if ( i == 5 ) {

						 setImage(R.drawable.a_t);

					} else if ( i == 6 ) {

						 setImage(R.drawable.d_n);

					} else if ( i == 7 ) {

						 setImage(R.drawable.a_t);

					}

			   }

			   @Override
			   public void onNothingSelected(AdapterView<?> adapterView) {

			   }
		  });

	 }

	 // set image in spinner
	 private void setImage(int img) {
		  imgTable.setImageResource(img);
		  //Zooming Image View Table
		  ImageMatrixTouchHandler zoom = new ImageMatrixTouchHandler(this);
		  imgTable.setOnTouchListener(new ImageMatrixTouchHandler(this));
		  zoom.getMode();
		  imgTable.performClick();

	 }
}
