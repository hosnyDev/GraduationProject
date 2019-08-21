package com.academy.motatwera;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.hdodenhof.circleimageview.CircleImageView;
import info.hoang8f.widget.FButton;
import pl.droidsonroids.gif.GifImageView;

public class ProfileActivity extends AppCompatActivity {

	 // view
	 private CircleImageView image_user_profile;
	 private ImageView profile_image_upload;

	 private SwipeRefreshLayout refreshProfile;
	 private GifImageView load_profile;

	 private TextView email_profile;
	 private TextView id_profile;

	 private EditText userName_profile;
	 private EditText phoneNumber_profile;

	 private ImageView clearPhone;
	 private ImageView clearUserName;

	 private MaterialRippleLayout btn_save_profile;
	 private ProgressBar progressBarUploadProfile;

	 // firebase
	 private String uID;
	 private Uri imageUri = null;
	 private static String StudentImageURL = null;

	 private String NameStudent;
	 private String imageStudent;
	 private String emailStudent;
	 private String ID;
	 private String phone;

	 /// firebase
	 private StorageReference storageReference;
	 private FirebaseAuth mAuth;
	 private FirebaseFirestore firebaseFirestore;
	 private DocumentReference mCollection;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_profile);

		  // view
		  image_user_profile = findViewById(R.id.image_user_profile);

		  profile_image_upload = findViewById(R.id.profile_image_upload);

		  email_profile = findViewById(R.id.email_profile);
		  id_profile = findViewById(R.id.id_profile);

		  userName_profile = findViewById(R.id.userName_profile);
		  phoneNumber_profile = findViewById(R.id.phoneNumber_profile);
		  clearUserName = findViewById(R.id.clearUserName);
		  clearPhone = findViewById(R.id.clearPhone);

		  btn_save_profile = findViewById(R.id.btn_save_profile);
		  progressBarUploadProfile = findViewById(R.id.progressBarUploadProfile);

		  refreshProfile = findViewById(R.id.refreshProfile);
		  load_profile = findViewById(R.id.load_profile);

		  // firebase
		  mAuth = FirebaseAuth.getInstance();
		  storageReference = FirebaseStorage.getInstance().getReference();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  uID = mAuth.getCurrentUser().getUid();


		  refreshProfile.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			   @Override
			   public void onRefresh() {

					retrieveStudentData();

					refreshProfile.setRefreshing(false);
			   }
		  });

		  /// edit text changed
		  userName_profile.addTextChangedListener(new TextWatcher() {

			   @Override
			   public void afterTextChanged(Editable s) {
			   }

			   @Override
			   public void beforeTextChanged(CharSequence s , int start ,
											 int count , int after) {
					if ( userName_profile.getText().length() > 0 ) {
						 clearUserName.setVisibility(View.VISIBLE);
					} else {
						 clearUserName.setVisibility(View.GONE);
					}
			   }

			   @Override
			   public void onTextChanged(CharSequence s , int start ,
										 int before , int count) {

					if ( s.toString().trim().length() > 0 ) {
						 clearUserName.setVisibility(View.VISIBLE);

						 clearUserName.setOnClickListener(new View.OnClickListener() {
							  @Override
							  public void onClick(View view) {
								   userName_profile.setText("");
							  }
						 });
					} else {
						 clearUserName.setVisibility(View.GONE);
					}


			   }
		  });

		  phoneNumber_profile.addTextChangedListener(new TextWatcher() {

			   @Override
			   public void afterTextChanged(Editable s) {
			   }

			   @Override
			   public void beforeTextChanged(CharSequence s , int start ,
											 int count , int after) {
					if ( phoneNumber_profile.getText().length() > 0 ) {
						 clearPhone.setVisibility(View.VISIBLE);
					} else {
						 clearPhone.setVisibility(View.GONE);
					}
			   }

			   @Override
			   public void onTextChanged(CharSequence s , int start ,
										 int before , int count) {

					if ( s.toString().trim().length() > 0 ) {
						 clearPhone.setVisibility(View.VISIBLE);
						 clearPhone.setOnClickListener(new View.OnClickListener() {
							  @Override
							  public void onClick(View view) {
								   phoneNumber_profile.setText("");
							  }
						 });
					} else {
						 clearPhone.setVisibility(View.GONE);
					}

			   }
		  });


		  // onClick to open gallery or camera to take image
		  profile_image_upload.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {

					setImageFromImageCroping();

			   }
		  });


		  //  onClick to save change
		  btn_save_profile.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					CheckInternetConn conn = new CheckInternetConn(ProfileActivity.this);

					Boolean ch = conn.isConnection();

					if ( ch ) {


						 progressBarUploadProfile.setVisibility(View.VISIBLE);
						 Save();

					} else {
						 progressBarUploadProfile.setVisibility(View.INVISIBLE);
						 AlertDialog.Builder al = new AlertDialog.Builder(ProfileActivity.this);
						 al.setCancelable(false)
								 .setMessage("you can't update profile setting when your connection is offline")
								 .setNegativeButton("try again" , null);
						 al.create();
						 al.show();
					}

			   }
		  });


		  // display image whine on click
		  image_user_profile.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {

					Dialog nagDialog = new Dialog(ProfileActivity.this);
					nagDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					nagDialog.setCancelable(true);
					nagDialog.setContentView(R.layout.preview_image);

					ImageView ivPreview = nagDialog.findViewById(R.id.iv_preview_image);

					ivPreview.setScaleType(ImageView.ScaleType.FIT_XY);

					if ( imageStudent != null && imageStudent.length() > 0 ) {

						 RequestOptions placeholderRequest = new RequestOptions();
						 placeholderRequest.placeholder(R.drawable.plac_holder);

						 Glide.with(ProfileActivity.this).setDefaultRequestOptions(placeholderRequest).load(imageStudent).into(ivPreview);
					}
					nagDialog.show();

			   }
		  });


	 }


	 // update data in collection
	 private void Save() {

		  Map<String, Object> studentData = new HashMap<>();

		  studentData.put("userName" , userName_profile.getText().toString());
		  studentData.put("phone" , phoneNumber_profile.getText().toString());

		  if ( StudentImageURL != null && StudentImageURL.length() > 0 ) {

			   studentData.put("img" , StudentImageURL);
			   image_user_profile.setImageURI(imageUri);

		  } else {
			   studentData.put("img" , imageStudent);
		  }

		  mCollection = firebaseFirestore.collection("student_registration").document(uID);

		  // update collection
		  mCollection.update(studentData)
				  .addOnSuccessListener(new OnSuccessListener<Void>() {
					   @Override
					   public void onSuccess(Void aVoid) {

							progressBarUploadProfile.setVisibility(View.INVISIBLE);
							Toast.makeText(ProfileActivity.this , "Update done" , Toast.LENGTH_SHORT).show();

					   }
				  }).addOnFailureListener(new OnFailureListener() {
			   @Override
			   public void onFailure(@NonNull Exception e) {

					progressBarUploadProfile.setVisibility(View.INVISIBLE);
					Toast.makeText(ProfileActivity.this , "Error \n " + e.getMessage() , Toast.LENGTH_SHORT).show();

			   }
		  });


	 }

	 // get data from collection
	 private void retrieveStudentData() {

		  progressBarUploadProfile.setVisibility(View.VISIBLE);
		  load_profile.setVisibility(View.VISIBLE);
		  refreshProfile.setVisibility(View.INVISIBLE);

		  mCollection = firebaseFirestore.collection("student_registration").document(uID);

		  mCollection.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
			   @Override
			   public void onComplete(@NonNull Task<DocumentSnapshot> task) {

					if ( task.isSuccessful() ) {
						 DocumentSnapshot document = task.getResult();

						 if ( document.exists() ) {

							  NameStudent = task.getResult().getString("userName");
							  imageStudent = task.getResult().getString("img");
							  emailStudent = task.getResult().getString("email");
							  ID = task.getResult().getString("ID");
							  phone = task.getResult().getString("phone");

							  email_profile.setText("Email : " + emailStudent);
							  userName_profile.setText(NameStudent);
							  phoneNumber_profile.setText(phone);
							  id_profile.setText("ID : " + ID);

							  if ( userName_profile.length() > 0 ) {
								   clearUserName.setVisibility(View.VISIBLE);
							  } else {
								   clearUserName.setVisibility(View.GONE);
							  }


							  if ( phoneNumber_profile.length() > 0 ) {
								   clearPhone.setVisibility(View.VISIBLE);
							  } else {
								   clearPhone.setVisibility(View.GONE);
							  }


							  if ( imageStudent != null ) {
								   RequestOptions placeholderRequest = new RequestOptions();
								   placeholderRequest.placeholder(R.drawable.plac_holder);

								   if ( imageStudent.equals("no") ) {
										image_user_profile.setImageResource(R.drawable.plac_holder);
								   } else {
										Glide.with(ProfileActivity.this).setDefaultRequestOptions(placeholderRequest).load(imageStudent).into(image_user_profile);
								   }
							  } else {

								   Toast.makeText(ProfileActivity.this , "image is exist" , Toast.LENGTH_SHORT).show();
							  }

							  progressBarUploadProfile.setVisibility(View.INVISIBLE);
							  load_profile.setVisibility(View.INVISIBLE);
							  refreshProfile.setVisibility(View.VISIBLE);
						 } else {

							  progressBarUploadProfile.setVisibility(View.INVISIBLE);
							  load_profile.setVisibility(View.VISIBLE);
							  refreshProfile.setVisibility(View.INVISIBLE);
							  Toast.makeText(ProfileActivity.this , "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();

						 }

					} else {

						 Toast.makeText(ProfileActivity.this , "Error\n" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();

					}

			   }
		  });

	 }

	 // use permission to open cam and gallery
	 private void setImageFromImageCroping() {

		  /**
		   *   use permission to READ_EXTERNAL_STORAGE For Device >= Marshmallow
		   */
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {

			   if ( ContextCompat.checkSelfPermission(ProfileActivity.this , Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
					Toast.makeText(ProfileActivity.this , "  permission denied" , Toast.LENGTH_LONG).show();

					// to ask user to reade external storage

					ActivityCompat.requestPermissions(ProfileActivity.this , new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE } , 1);

			   } else {

					OpenGalleryImagePicker();

			   }

			   /**
				*  implement code for device < Marshmallow
				*/
		  } else {

			   OpenGalleryImagePicker();
		  }


	 }

	 // Method to open gallery
	 private void OpenGalleryImagePicker() {

		  // start picker to get image for cropping and then use the image in cropping activity
		  CropImage.activity()
				  .setGuidelines(CropImageView.Guidelines.ON)
				  .start(ProfileActivity.this);

	 }

	 // On Activity result When user back Contains image
	 @Override
	 protected void onActivityResult(int requestCode , int resultCode , Intent data) {
		  super.onActivityResult(requestCode , resultCode , data);


		  if ( requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE ) {
			   CropImage.ActivityResult result = CropImage.getActivityResult(data);

			   if ( resultCode == RESULT_OK ) {

					imageUri = result.getUri();

					/**
					 *  set image user in ImageView ;
					 */
					image_user_profile.setImageURI(imageUri);

					uploadImage();

			   } else if ( resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE ) {

					Exception error = result.getError();
					Toast.makeText(ProfileActivity.this , "Error : " + error , Toast.LENGTH_LONG).show();

			   }
		  }
	 }

	 // upload image to StorageReference
	 private void uploadImage() {

		  // set progressBar VISIBLE
		  progressBarUploadProfile.setVisibility(View.VISIBLE);

		  CheckInternetConn conn = new CheckInternetConn(this);

		  boolean ch = conn.isConnection();

		  if ( ch ) {

			   // chick if user image is null or not
			   if ( imageUri != null ) {

					// mack progress bar dialog
					final ProgressDialog progressDialog = new ProgressDialog(this);
					progressDialog.setTitle("uploading...");
					progressDialog.setCancelable(false);
					progressDialog.show();

					// mack collection in fireStorage
					final StorageReference ref = storageReference.child("Profile_image_student").child(emailStudent + ".jpg");

					// get image user and give to imageUserPath
					ref.putFile(imageUri).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
						 @Override
						 public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

							  double progress = (100.0 * taskSnapshot.getBytesTransferred()) / taskSnapshot.getTotalByteCount();
							  progressDialog.setMessage("upload " + (int) progress + "%");

						 }
					}).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						 @Override
						 public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
							  if ( !task.isSuccessful() ) {

								   throw task.getException();

							  }
							  return ref.getDownloadUrl();

						 }
					}).addOnCompleteListener(new OnCompleteListener<Uri>() {
						 @Override
						 public void onComplete(@NonNull Task<Uri> task) {

							  if ( task.isSuccessful() ) {

								   progressDialog.dismiss();
								   Uri downloadUri = task.getResult();

								   StudentImageURL = downloadUri.toString();

								   if ( StudentImageURL != null ) {


										Save();

								   }

							  } else {

								   progressDialog.dismiss();
								   progressBarUploadProfile.setVisibility(View.INVISIBLE);
								   Toast.makeText(ProfileActivity.this , " Error in addOnCompleteListener " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();

							  }
						 }
					});
			   }


		  } else {
			   progressBarUploadProfile.setVisibility(View.INVISIBLE);
			   AlertDialog.Builder al = new AlertDialog.Builder(this);
			   al.setCancelable(false)
					   .setMessage("you can't upload image when your connection is offline")
					   .setNegativeButton("try again" , null);
			   al.create();
			   al.show();
		  }

	 }

	 // on start to retrieve Student Data
	 @Override
	 protected void onStart() {
		  super.onStart();
		  // Retrieve data from FirebaseDatabase

		  retrieveStudentData();
	 }


}
