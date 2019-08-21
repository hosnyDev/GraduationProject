package com.academy.motatwera.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.academy.motatwera.ProfileActivity;
import com.academy.motatwera.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class ProfileFragment extends Fragment {

	 /// view
	 private FloatingActionButton editProfile;
	 private ProgressBar progress_Profile_fragment;
	 private ImageView img_Profile_fragment;
	 private TextView userName_Profile_fragment;
	 private TextView email_Profile_fragment;
	 private TextView phone_Profile_fragment;
	 private TextView id_Profile_fragment;
	 private TextView complete_profile_fragment;
	 private RelativeLayout container_profile_fragment;

	 /// firebase
	 private FirebaseAuth mAuth;
	 private FirebaseFirestore firebaseFirestore;
	 private DocumentReference mCollection;
	 private String uID;

	 public ProfileFragment() {
		  // Required empty public constructor
	 }

	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_profile , container , false);

		  /// view
		  editProfile = view.findViewById(R.id.editProfile);
		  progress_Profile_fragment = view.findViewById(R.id.progress_Profile_fragment);
		  img_Profile_fragment = view.findViewById(R.id.img_Profile_fragment);
		  userName_Profile_fragment = view.findViewById(R.id.userName_Profile_fragment);
		  email_Profile_fragment = view.findViewById(R.id.email_Profile_fragment);
		  phone_Profile_fragment = view.findViewById(R.id.phone_Profile_fragment);
		  id_Profile_fragment = view.findViewById(R.id.id_Profile_fragment);
		  complete_profile_fragment = view.findViewById(R.id.complete_profile_fragment);
		  container_profile_fragment = view.findViewById(R.id.container_profile_fragment);


		  // firebase
		  mAuth = FirebaseAuth.getInstance();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  uID = mAuth.getCurrentUser().getUid();


		  editProfile.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , ProfileActivity.class));
			   }
		  });

		  complete_profile_fragment.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , ProfileActivity.class));
			   }
		  });

		  return view;
	 }

	 // get data from collection
	 private void retrieveStudentData() {

		  progress_Profile_fragment.setVisibility(View.VISIBLE);

		  mCollection = firebaseFirestore.collection("student_registration").document(uID);
		  mCollection.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
			   @Override
			   public void onComplete(@NonNull Task<DocumentSnapshot> task) {

					if ( task.isSuccessful() ) {
						 DocumentSnapshot document = task.getResult();
						 if ( document.exists() ) {
							  userName_Profile_fragment.setText(task.getResult().getString("userName"));
							  String imageStudent = task.getResult().getString("img");
							  email_Profile_fragment.setText(task.getResult().getString("email"));
							  id_Profile_fragment.setText(task.getResult().getString("ID"));
							  phone_Profile_fragment.setText(task.getResult().getString("phone"));

							  if ( imageStudent != null ) {
								   RequestOptions placeholderRequest = new RequestOptions();
								   placeholderRequest.placeholder(R.drawable.plac_holder);

								   if ( imageStudent.equals("no") ) {
										complete_profile_fragment.setVisibility(View.VISIBLE);
										img_Profile_fragment.setImageResource(R.drawable.plac_holder);
								   } else {
										if ( getActivity() != null ) {
											 complete_profile_fragment.setVisibility(View.GONE);
											 Glide.with(getActivity()).setDefaultRequestOptions(placeholderRequest).load(imageStudent).into(img_Profile_fragment);
										}
								   }
							  } else {

								   Toast.makeText(getActivity() , "image is exist" , Toast.LENGTH_SHORT).show();
							  }

							  progress_Profile_fragment.setVisibility(View.GONE);
							  container_profile_fragment.setVisibility(View.VISIBLE);
						 } else {
							  progress_Profile_fragment.setVisibility(View.GONE);
							  Toast.makeText(getActivity() , "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
						 }
					} else {
						 Toast.makeText(getActivity() , "Error\n" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
					}
			   }
		  });

	 }

	 @Override
	 public void onStart() {
		  super.onStart();
		  retrieveStudentData();
	 }

}
