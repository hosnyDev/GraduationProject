package com.academy.motatwera.Fragment.Social_Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.academy.motatwera.MainActivity;
import com.academy.motatwera.R;
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.bumptech.glide.Glide;

public class ViewImageHome extends AppCompatActivity {

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_view_image_home);

		  ImageView imageView = findViewById(R.id.viewImage);
		  ProgressBar progress_view_image = findViewById(R.id.progress_view_image);

		  String url = getIntent().getStringExtra("img_url");

		  if ( !url.isEmpty() ) {
			   Glide.with(this).load(url).into(imageView);

			   if ( !url.equals("no") ) {
					imageView.setOnTouchListener(new ImageMatrixTouchHandler(this));
			   }
			   progress_view_image.setVisibility(View.GONE);
		  } else {
			   imageView.setImageResource(R.drawable.picture);
		  }
	 }

	 @Override
	 public void onBackPressed() {
		  super.onBackPressed();
		  startActivity(new Intent(ViewImageHome.this , MainActivity.class));
		  finish();
	 }
}
