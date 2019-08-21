package com.academy.motatwera.Fragment.Social_Home;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.academy.motatwera.CheckInternetConn;
import com.academy.motatwera.MainActivity;
import com.academy.motatwera.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class Create_New_Post extends AppCompatActivity {


	 /// Image uploaded
	 private int IMAGE_STATE = 0;
	 private Uri imageUri = null;
	 private String postImageURL;


	 /// view
	 private Switch switch_image;
	 private ImageView image_add_new_post;
	 private EditText description_new_post;
	 private Button post;
	 private ImageView clear_Text_Post;
	 private ProgressBar progress_new_post;

	 ///  firebase
	 private DatabaseReference db;
	 private FirebaseAuth mAuth;
	 private String UID;
	 private DocumentReference mCollection;
	 private StorageReference storageReference;
	 private FirebaseFirestore firebaseFirestore;

	 /// field in create new post
	 private String userID;
	 private String imgUserProfileURL;
	 private String userNamePost;
	 private String timePost;
	 private String titlePost;
	 private ProgressDialog progressDialog;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_create__new__post);

		  /// view
		  image_add_new_post = findViewById(R.id.image_add_new_post);
		  description_new_post = findViewById(R.id.description_new_post);
		  post = findViewById(R.id.post);
		  switch_image = findViewById(R.id.switch_image);
		  clear_Text_Post = findViewById(R.id.clear_Text_Post);
		  progress_new_post = findViewById(R.id.progress_new_post);


		  /// firebase
		  mAuth = FirebaseAuth.getInstance();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  UID = mAuth.getCurrentUser().getUid();
		  storageReference = FirebaseStorage.getInstance().getReference();

		  switch_image.setChecked(false);
		  switch_image.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			   @Override
			   public void onCheckedChanged(CompoundButton compoundButton , boolean b) {

					if ( b ) {
						 image_add_new_post.setVisibility(View.VISIBLE);
						 image_add_new_post.setImageResource(R.drawable.upload_image);
						 image_add_new_post.setOnClickListener(new View.OnClickListener() {
							  @Override
							  public void onClick(View view) {
								   permissionImage();

							  }
						 });
					} else {
						 IMAGE_STATE = 0;
						 image_add_new_post.setVisibility(View.GONE);
					}

			   }
		  });

		  description_new_post.addTextChangedListener(new TextWatcher() {
			   @Override
			   public void beforeTextChanged(CharSequence charSequence , int i , int i1 , int i2) {

					if ( charSequence.toString().trim().length() > 0 ) {
						 clear_Text_Post.setVisibility(View.VISIBLE);
						 post.setEnabled(true);

					} else {
						 clear_Text_Post.setVisibility(View.GONE);
						 post.setEnabled(false);
					}

			   }

			   @Override
			   public void onTextChanged(CharSequence charSequence , int i , int i1 , int i2) {

					if ( description_new_post.getText().length() > 0 ) {
						 clear_Text_Post.setVisibility(View.VISIBLE);
						 post.setEnabled(true);
						 post.setTextColor(getResources().getColor(R.color.white));
						 post.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
						 clear_Text_Post.setOnClickListener(new View.OnClickListener() {
							  @Override
							  public void onClick(View view) {
								   description_new_post.setText("");
							  }
						 });
					} else {
						 clear_Text_Post.setVisibility(View.GONE);
						 post.setEnabled(false);
						 post.setTextColor(getResources().getColor(R.color.white));
						 post.setBackgroundColor(getResources().getColor(R.color.buttonBackground));
					}
			   }

			   @Override
			   public void afterTextChanged(Editable editable) {

			   }
		  });

		  post.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					CheckInternetConn conn = new CheckInternetConn(Create_New_Post.this);
					boolean ch = conn.isConnection();

					if ( ch ) {
						 post.setEnabled(false);
						 //addPostFirestore();
						 addPostFirestore();
					} else {
						 al("you can't create new post when your connection is offline");
					}
			   }
		  });
	 }

	 /// add new post in firebase firestore database
	 private void addPostFirestore() {
		  // set progressBar VISIBLE
		  progress_new_post.setVisibility(View.VISIBLE);

		  String dec = description_new_post.getText().toString();

		  if ( TextUtils.isEmpty(dec) ) {
			   al("must be add description");
		  } else {

			   if ( IMAGE_STATE != 0 ) {

					uploadImage();

			   } else {

					if ( switch_image.isChecked() ) {

						 if ( imageUri != null ) {

							  SavePost();

						 } else {

							  progress_new_post.setVisibility(View.GONE);
							  al("must be choose image");
						 }
					} else {
						 SavePost();
					}
			   }
		  }
	 }

	 // upload image to StorageReference
	 private void uploadImage() {

		  // chick if user image is null or not
		  if ( imageUri != null && IMAGE_STATE != 0 ) {

			   // mack progress bar dialog
			   progressDialog = new ProgressDialog(this);
			   progressDialog.setTitle("uploading...");
			   progressDialog.setCancelable(false);
			   progressDialog.show();


			   // mack collection in fireStorage
			   final StorageReference ref = storageReference.child("post_image").child(UID + GetToday() + ".jpg");

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


							  Uri downloadUri = task.getResult();
							  postImageURL = downloadUri.toString();

							  if ( postImageURL != null && postImageURL.length() > 0 ) {
								   SavePost();
								   progressDialog.dismiss();
							  }
						 } else {
							  post.setEnabled(true);
							  progressDialog.dismiss();
							  Toast.makeText(Create_New_Post.this , " Error in addOnCompleteListener " + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
						 }
					}
			   });
		  }


	 }

	 private void SavePost() {

		  if ( IMAGE_STATE == 0 ) {

			   uploadPost("no");

		  } else {

			   uploadPost(postImageURL);
		  }

	 }

	 private void uploadPost(final String imageURL) {


		  // variable
		  userID = UID;
		  timePost = GetToday();
		  titlePost = description_new_post.getText().toString();

		  Map<String, Object> postMap = new HashMap<>();
		  postMap.put("image_url" , imageURL);
		  postMap.put("desc" , titlePost);
		  postMap.put("user_id" , userID);
		  postMap.put("timestamp" , FieldValue.serverTimestamp());

		  firebaseFirestore.collection("posts").add(postMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
			   @Override
			   public void onComplete(@NonNull Task<DocumentReference> task) {
					if ( task.isSuccessful() ) {
						 startActivity(new Intent(Create_New_Post.this , MainActivity.class));
						 finish();
						 progress_new_post.setVisibility(View.GONE);
					} else {
						 progress_new_post.setVisibility(View.GONE);
						 post.setEnabled(true);
						 Toast.makeText(Create_New_Post.this , "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
					}
			   }
		  });


	 }

	 /// get date and time
	 private String GetToday() {
		  Date presentTime_Date = Calendar.getInstance().getTime();
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h:m");
		  dateFormat.setTimeZone(TimeZone.getDefault());
		  return dateFormat.format(presentTime_Date);
	 }

	 // On Activity result When user back Contains image
	 @Override
	 protected void onActivityResult(int requestCode , int resultCode , Intent data) {
		  super.onActivityResult(requestCode , resultCode , data);


		  if ( requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE ) {
			   CropImage.ActivityResult result = CropImage.getActivityResult(data);

			   if ( resultCode == RESULT_OK ) {
					imageUri = result.getUri();

					///set image in ImageView ;
					if ( imageUri != null ) {
						 image_add_new_post.setImageURI(imageUri);
						 IMAGE_STATE = 1;
					}


					//uploadImage();

			   } else if ( resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE ) {
					IMAGE_STATE = 0;
					Exception error = result.getError();
					post.setEnabled(true);
					Toast.makeText(Create_New_Post.this , "Error : " + error , Toast.LENGTH_LONG).show();

			   }
		  }
	 }

	 // use permission to open cam and gallery
	 private void permissionImage() {

		  /**
		   *   use permission to READ_EXTERNAL_STORAGE For Device >= Marshmallow
		   */
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {

			   if ( ContextCompat.checkSelfPermission(Create_New_Post.this , Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
					Toast.makeText(Create_New_Post.this , "  permission denied" , Toast.LENGTH_LONG).show();

					// to ask user to reade external storage

					ActivityCompat.requestPermissions(Create_New_Post.this , new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE } , 1);

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
				  .setAspectRatio(1 , 1)
				  .setMinCropResultSize(512 , 512)
				  .start(Create_New_Post.this);

	 }


	 private void al(String msg) {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  al.setMessage(msg).setPositiveButton("ok" , null);
		  al.create();
		  al.show();
	 }

	 @Override
	 public void onBackPressed() {
		  super.onBackPressed();
		  startActivity(new Intent(Create_New_Post.this , MainActivity.class));
		  finish();
	 }
}
