package com.academy.motatwera.Fragment.Book.Book_Bassem;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.academy.motatwera.MainActivity;
import com.academy.motatwera.R;

public class Main_Bassem_Activity extends AppCompatActivity {

	 private int pageTab;
	 private ViewPager viewPager;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_main__bassem__avtivity);


		  // set Taps for fragment
		  TabLayout tabLayout = findViewById(R.id.tabs);
		  tabLayout.addTab(tabLayout.newTab().setText("Book"));
		  tabLayout.addTab(tabLayout.newTab().setText("Chat"));
		  tabLayout.addTab(tabLayout.newTab().setText("Quiz"));


		  // set tapLayout GRAVITY_FILL to screen
		  tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

		  // viewPager to move a fragment
		  viewPager = findViewById(R.id.container);

		  // set Adapter to get count from Fragment to Display in viewPager
		  // pagerAdapterFragment = new class to set switch Tabs
		  final PagerAdapterFragment pagerAdapterFragment =
				  new PagerAdapterFragment(getSupportFragmentManager() ,
						  tabLayout.getTabCount());

		  // set adapter to viewPager
		  viewPager.setAdapter(pagerAdapterFragment);

		  viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		  tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
			   @Override
			   public void onTabSelected(TabLayout.Tab tab) {
					pageTab = tab.getPosition();
					viewPager.setCurrentItem(tab.getPosition());
			   }

			   @Override
			   public void onTabUnselected(TabLayout.Tab tab) {


			   }

			   @Override
			   public void onTabReselected(TabLayout.Tab tab) {

			   }
		  });

	 }

	 @Override
	 public void onBackPressed() {

		  if ( pageTab != 0 ) {
			   viewPager.setCurrentItem(0);
		  } else {
			   startActivity(new Intent(Main_Bassem_Activity.this , MainActivity.class));
		  }

	 }
}