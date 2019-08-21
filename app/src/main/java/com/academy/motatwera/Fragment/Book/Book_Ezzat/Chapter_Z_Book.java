package com.academy.motatwera.Fragment.Book.Book_Ezzat;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ProgressBar;

import com.academy.motatwera.R;

public class Chapter_Z_Book extends AppCompatActivity {

	 private CardView c_z_1;
	 private SwipeRefreshLayout refresh_D_Z;
	 private ProgressBar book_d_z;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_chapter__z__book);

		  c_z_1 = findViewById(R.id.c_z_1);
		  refresh_D_Z = findViewById(R.id.refresh_D_Z);
		  book_d_z = findViewById(R.id.book_d_z);

		  c_z_1.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					book_d_z.setVisibility(View.VISIBLE);

					new Handler().postDelayed(new Runnable() {
						 @Override
						 public void run() {

							  startActivity(new Intent(Chapter_Z_Book.this , Chapter_1_zActivity.class));

						 }
					} , 1000);

			   }
		  });


		  refresh_D_Z.setColorSchemeColors(
				  getResources().getColor(R.color.colorPrimary) ,
				  getResources().getColor(R.color.b2b2b2) ,
				  getResources().getColor(R.color.colorPrimaryDark) ,
				  getResources().getColor(R.color.b2b2b2)
		  );

		  refresh_D_Z.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			   @Override
			   public void onRefresh() {

					refresh_D_Z.setRefreshing(false);
			   }
		  });


	 }

	 @Override
	 protected void onStart() {
		  super.onStart();
		  book_d_z.setVisibility(View.INVISIBLE);
	 }
}
