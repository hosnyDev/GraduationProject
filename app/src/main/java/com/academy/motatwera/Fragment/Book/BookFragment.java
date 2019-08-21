package com.academy.motatwera.Fragment.Book;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.academy.motatwera.Fragment.Book.Book_Bassem.Main_Bassem_Activity;
import com.academy.motatwera.Fragment.Book.Book_Ezzat.Chapter_Z_Book;
import com.academy.motatwera.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {


	 public BookFragment() {
		  // Required empty public constructor
	 }

	 // view
	 private CardView book_b;
	 private CardView book_z;

	 private static int activityStatue;


	 // FIREBASE
	 private FirebaseAuth mAuth;
	 private String uID;

	 // firebase
	 private FirebaseFirestore mFirebaseFirestore;
	 private DocumentReference mCollection;



	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_book , container , false);


		  // view
		  book_b = view.findViewById(R.id.book_b);
		  book_z = view.findViewById(R.id.book_z);

		  // firebase
		  mFirebaseFirestore = FirebaseFirestore.getInstance();

		  // FIREBASE
		  mAuth = FirebaseAuth.getInstance();
		  uID = mAuth.getCurrentUser().getUid();

		  book_b.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					activityStatue = 1;
				//	startActivity(new Intent(getActivity() , Main_Bassem_Activity.class));
					 qrCodeScan();
			   }
		  });

		  book_z.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					activityStatue = 2;
					qrCodeScan();


			   }
		  });

		  return view;
	 }


	 // PERMISSION TO ASK USER TO USE CAMERA TO SCAN QR CODE..

	 private void qrCodeScan() {

		  /**
		   *  Ask User to Open a Camera
		   */
		  if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ) {

			   if ( ContextCompat.checkSelfPermission(getActivity() , Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ) {

					Toast.makeText(getActivity() , "permission denied" , Toast.LENGTH_SHORT).show();

					ActivityCompat.requestPermissions(getActivity() , new String[]{ Manifest.permission.CAMERA } , 1);

			   } else {
					/**
					 *  this for version > 5
					 */
					OpenCameraScan();

			   }

		  } else {

			   /**
				*  this for version < 5
				*/
			   OpenCameraScan();


		  }
	 }

	 // OPEN CAMERA TO START SCAN
	 private void OpenCameraScan() {

		  AlertDialog.Builder al = new AlertDialog.Builder(getActivity());
		  al.setCancelable(false)
				  .setTitle("Motatawera")
				  .setMessage("we need to scan your qr code for security permeation")
				  .setPositiveButton("Scan" , new DialogInterface.OnClickListener() {
					   @Override
					   public void onClick(DialogInterface dialogInterface , int i) {

							IntentIntegrator.forSupportFragment(BookFragment.this).initiateScan();
					   }
				  }).setNegativeButton("cancel" , null);
		  al.create();
		  al.show();

	 }

	 // ON ACTIVITY RESULT AFTER SCAN TO CHECK IF QR CODE IS CORRECT OR NOT
	 @Override
	 public void onActivityResult(int requestCode , int resultCode , Intent data) {

		  IntentResult result = IntentIntegrator.parseActivityResult(requestCode , resultCode , data);


		  if ( result != null ) {

			   if ( result.getContents() == null ) {

					Toast.makeText(getActivity() , "Cancelled" , Toast.LENGTH_LONG).show();

			   } else {

					String contents = result.getContents();


					if ( requestCode == RESULT_OK ) {

						 Toast.makeText(getActivity() , "RESULT_OK" , Toast.LENGTH_SHORT).show();

					} else {

						 // chick if QrCode is correct or not
						 if ( contents.equals(uID) ) {

							  startBook();


						 } else {

							  /**
							   *  When Camera read any QrCode not Generate in App
							   */

							  AlertDialog.Builder m = new AlertDialog.Builder(getActivity())
									  .setTitle("Motatawera ")
									  .setCancelable(false)
									  .setMessage("Sorry this QrCode incorrect")
									  .setPositiveButton("Ok" , null);
							  m.create();
							  m.show();

						 }
					}

			   }

		  } else {

			   super.onActivityResult(requestCode , resultCode , data);

		  }
	 }

	 private void startBook() {

		  if ( activityStatue == 1 ) {

			   startActivity(new Intent(getActivity() , Main_Bassem_Activity.class));

		  } else if ( activityStatue == 2 ) {

			   startActivity(new Intent(getActivity() , Chapter_Z_Book.class));
		  }

	 }

}
