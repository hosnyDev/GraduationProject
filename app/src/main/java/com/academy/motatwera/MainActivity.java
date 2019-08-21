package com.academy.motatwera;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.academy.motatwera.Fragment.Book.BookFragment;
import com.academy.motatwera.Fragment.MenuFragment;
import com.academy.motatwera.Fragment.ProfileFragment;
import com.academy.motatwera.Fragment.Social_Home.post.HomeFragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	 private int pageFragment;

	 // view
	 private BottomNavigationView navigation;
	 private CircleImageView image_user_home;
	 private TextView user_name_home;
	 private RelativeLayout container_home_data;
	 private LinearLayout data;
	 private ProgressBar progressBarHome;


	 // FIREBASE
	 private FirebaseAuth mAuth;
	 private String uID;

	 // firebase
	 private FirebaseFirestore mFirebaseFirestore;
	 private DocumentReference mCollection;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  Bar();
		  setContentView(R.layout.activity_main);


		  // view
		  navigation = findViewById(R.id.navigation);
		  image_user_home = findViewById(R.id.image_user_home);
		  user_name_home = findViewById(R.id.user_name_home);
		  container_home_data = findViewById(R.id.container_home_data);
		  data = findViewById(R.id.data);
		  progressBarHome = findViewById(R.id.progressBarHome);

		  final HomeFragment homeFragment = new HomeFragment();
		  final BookFragment bookFragment = new BookFragment();
		  final MenuFragment menuFragment = new MenuFragment();
		  final ProfileFragment profileFragment = new ProfileFragment();


		  // firebase
		  mFirebaseFirestore = FirebaseFirestore.getInstance();

		  // FIREBASE
		  mAuth = FirebaseAuth.getInstance();
		  uID = mAuth.getCurrentUser().getUid();

		  container_home_data.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					setFragment(profileFragment);
					pageFragment = 2;
					container_home_data.setVisibility(View.GONE);
			   }
		  });


		  navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			   @Override
			   public boolean onNavigationItemSelected(@NonNull MenuItem item) {

					int id = item.getItemId();
					if ( id == R.id.navigation_home ) {
						 setFragment(homeFragment);
						 pageFragment = 0;
						 container_home_data.setVisibility(View.VISIBLE);
						 return true;
					} else if ( id == R.id.navigation_Book ) {
						 setFragment(bookFragment);
						 pageFragment = 1;
						 container_home_data.setVisibility(View.VISIBLE);
						 return true;
					} else if ( id == R.id.navigation_Profile ) {
						 setFragment(profileFragment);
						 pageFragment = 2;
						 container_home_data.setVisibility(View.GONE);
						 return true;
					} else if ( id == R.id.navigation_menu ) {
						 setFragment(menuFragment);
						 pageFragment = 3;
						 container_home_data.setVisibility(View.VISIBLE);
						 return true;
					}

					return false;
			   }
		  });

		  navigation.setSelectedItemId(R.id.navigation_home);


	 }


	 // method to load fragment
	 private void setFragment(Fragment fragment) {
		  FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		  fragmentTransaction.replace(R.id.frame_container , fragment);
		  fragmentTransaction.commit();

	 }

	 // onBackPressed
	 @Override
	 public void onBackPressed() {

		  if ( pageFragment != 0 ) {
			   navigation.setSelectedItemId(R.id.navigation_home);
		  } else {
			   finishAffinity();
		  }

	 }

	 @Override
	 public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
		  return false;
	 }



	 // SET USER NAME IN NAVIGATION MENU
	 private void displayStudentData() {

		  progressBarHome.setVisibility(View.VISIBLE);
		  data.setVisibility(View.GONE);

		  // get data for collection "studentData"
		  mCollection = mFirebaseFirestore.collection("student_registration").document(uID);
		  mCollection.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
			   @Override
			   public void onComplete(@NonNull Task<DocumentSnapshot> task) {

					if ( task.isSuccessful() ) {
						 DocumentSnapshot document = task.getResult();

						 // if data is exists
						 if ( document.exists() ) {

							  // make string var to get data from collection
							  String NameStudent = document.getString("userName");
							  String imageStudent = document.getString("img");

							  // set name and img user from string object
							  assert NameStudent != null;
							  if ( NameStudent.length() > 25 ) {
								   user_name_home.setMaxLines(1);
								   String nameMax = NameStudent + "..";
								   user_name_home.setText(nameMax);
							  } else {
								   user_name_home.setText(NameStudent);
							  }


							  if ( imageStudent != null && imageStudent.length() > 0 ) {
								   RequestOptions placeholderRequest = new RequestOptions();
								   placeholderRequest.placeholder(R.drawable.plac_holder);
								   if ( MainActivity.this != null ) {
										if ( imageStudent.equals("no") ) {
											 image_user_home.setImageResource(R.drawable.plac_holder);
										} else {
											 Glide.with(MainActivity.this).setDefaultRequestOptions(placeholderRequest).load(imageStudent).into(image_user_home);
										}
								   }
							  }
							  progressBarHome.setVisibility(View.GONE);
							  data.setVisibility(View.VISIBLE);

						 } else {

							  // handel errors
							  Toast.makeText(MainActivity.this , "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
						 }

					} else {
						 // handel errors
						 Toast.makeText(MainActivity.this , "Error\n" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
					}

			   }
		  });
	 }

	 @Override
	 public void onStart() {
		  super.onStart();

		  // SET STUDENT DATA
		  if ( mAuth != null ) {
			   displayStudentData();
		  }
	 }


	 //  Method To change  status bar color
	 private void Bar() {

		  Window window = getWindow();
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP ) {
			   window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			   SystemBarTintManager tintManager = new SystemBarTintManager(this);
			   tintManager.setStatusBarTintEnabled(true);
			   tintManager.setTintColor(ContextCompat.getColor(this , R.color.colorPrimary));
		  }
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
			   window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
			   window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
		  }

	 }

}
