package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.Rating;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB1.Qcb1Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB2.Qcb2Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB3.Qcb3Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB4.Qcb4Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB5.Qcb5Activity;
import com.academy.motatwera.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class Quiz_Fragment extends Fragment {

	 /// firebase
	 private FirebaseAuth mAth;
	 private FirebaseFirestore mFirebaseFirestore;
	 private String uID;
	 private DocumentReference mCollection;

	 /// get data chapter1
	 private String Value1_D_Bassem;
	 private String ImageState1_D_Bassem;
	 private String Rate1_D_Bassem;
	 private String Statues1_D_Bassem;

	 /// get data chapter 2
	 private String Value2_D_Bassem;
	 private String ImageState2_D_Bassem;
	 private String Rate2_D_Bassem;
	 private String Statues2_D_Bassem;

	 /// get data chapter 3
	 private String Value3_D_Bassem;
	 private String ImageState3_D_Bassem;
	 private String Rate3_D_Bassem;
	 private String Statues3_D_Bassem;

	 /// get data chapter 4
	 private String Value4_D_Bassem;
	 private String ImageState4_D_Bassem;
	 private String Rate4_D_Bassem;
	 private Object Statues4_D_Bassem;

	 /// get data chapter 5
	 private String Value5_D_Bassem;
	 private String ImageState5_D_Bassem;
	 private String Rate5_D_Bassem;
	 private String Statues5_D_Bassem;


	 public Quiz_Fragment() {
		  // Required empty public constructor
	 }


	 /// view
	 private CardView c_b_1;
	 private CardView c_b_2;
	 private CardView c_b_3;
	 private CardView c_b_4;
	 private CardView c_b_5;

	 private ProgressBar progress_chapter_bassem;


	 /// data in book

	 /// rate data
	 private RatingBar rate_chapter_1_bassem;
	 private RatingBar rate_chapter_2_bassem;
	 private RatingBar rate_chapter_3_bassem;
	 private RatingBar rate_chapter_4_bassem;
	 private RatingBar rate_chapter_5_bassem;

	 /// value data
	 private TextView value_chapter_1_bassem;
	 private TextView value_chapter_2_bassem;
	 private TextView value_chapter_3_bassem;
	 private TextView value_chapter_4_bassem;
	 private TextView value_chapter_5_bassem;

	 /// image state
	 private ImageView state_chapter_1_bassem;
	 private ImageView state_chapter_2_bassem;
	 private ImageView state_chapter_3_bassem;
	 private ImageView state_chapter_4_bassem;
	 private ImageView state_chapter_5_bassem;

	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_quiz_ , container , false);

		  /// view
		  c_b_1 = view.findViewById(R.id.c_b_1);
		  c_b_2 = view.findViewById(R.id.c_b_2);
		  c_b_3 = view.findViewById(R.id.c_b_3);
		  c_b_4 = view.findViewById(R.id.c_b_4);
		  c_b_5 = view.findViewById(R.id.c_b_5);
		  progress_chapter_bassem = view.findViewById(R.id.progress_chapter_bassem);

		  rate_chapter_1_bassem = view.findViewById(R.id.rate_chapter_1_bassem);
		  rate_chapter_2_bassem = view.findViewById(R.id.rate_chapter_2_bassem);
		  rate_chapter_3_bassem = view.findViewById(R.id.rate_chapter_3_bassem);
		  rate_chapter_4_bassem = view.findViewById(R.id.rate_chapter_4_bassem);
		  rate_chapter_5_bassem = view.findViewById(R.id.rate_chapter_5_bassem);

		  value_chapter_1_bassem = view.findViewById(R.id.value_chapter_1_bassem);
		  value_chapter_2_bassem = view.findViewById(R.id.value_chapter_2_bassem);
		  value_chapter_3_bassem = view.findViewById(R.id.value_chapter_3_bassem);
		  value_chapter_4_bassem = view.findViewById(R.id.value_chapter_4_bassem);
		  value_chapter_5_bassem = view.findViewById(R.id.value_chapter_5_bassem);

		  state_chapter_1_bassem = view.findViewById(R.id.state_chapter_1_bassem);
		  state_chapter_2_bassem = view.findViewById(R.id.state_chapter_2_bassem);
		  state_chapter_3_bassem = view.findViewById(R.id.state_chapter_3_bassem);
		  state_chapter_4_bassem = view.findViewById(R.id.state_chapter_4_bassem);
		  state_chapter_5_bassem = view.findViewById(R.id.state_chapter_5_bassem);


		  // firebase
		  mAth = FirebaseAuth.getInstance();
		  mFirebaseFirestore = FirebaseFirestore.getInstance();

		  // on click to start quiz
		  c_b_1.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					startActivity(new Intent(getActivity() , Qcb1Activity.class));
			   }
		  });


		  // on click to start quiz
		  c_b_2.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Qcb2Activity.class));
			   }
		  });


		  // on click to start quiz
		  c_b_3.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Qcb3Activity.class));
			   }
		  });


		  // on click to start quiz
		  c_b_4.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Qcb4Activity.class));
			   }
		  });


		  // on click to start quiz
		  c_b_5.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Qcb5Activity.class));
			   }
		  });


		  return view;
	 }


	 // save score data in firebase
	 private void getScore() {
		  progress_chapter_bassem.setVisibility(View.VISIBLE);
		  //  get user ID
		  uID = mAth.getCurrentUser().getUid();

		  // mack collection in firebase firestore
		  mCollection = mFirebaseFirestore.collection("book_doctor_baseem").document(uID);

		  // mack collection in firebase firestore
		  mCollection.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
			   @Override
			   public void onComplete(@NonNull Task<DocumentSnapshot> task) {
					if ( task.isSuccessful() ) {
						 DocumentSnapshot document = task.getResult();
						 if ( document.exists() ) {
							  // get score data doctor bassem
							  Value1_D_Bassem = document.getString("Value1_D_Bassem");
							  ImageState1_D_Bassem = document.getString("ImageState1_D_Bassem");
							  Rate1_D_Bassem = document.getString("Rate1_D_Bassem");
							  Statues1_D_Bassem = document.getString("Statues1_D_Bassem");

							  Value2_D_Bassem = document.getString("Value2_D_Bassem");
							  ImageState2_D_Bassem = document.getString("ImageState2_D_Bassem");
							  Rate2_D_Bassem = document.getString("Rate2_D_Bassem");
							  Statues2_D_Bassem = document.getString("Statues2_D_Bassem");

							  Value3_D_Bassem = document.getString("Value3_D_Bassem");
							  ImageState3_D_Bassem = document.getString("ImageState3_D_Bassem");
							  Rate3_D_Bassem = document.getString("Rate3_D_Bassem");
							  Statues3_D_Bassem = document.getString("Statues3_D_Bassem");

							  Value4_D_Bassem = document.getString("Value4_D_Bassem");
							  ImageState4_D_Bassem = document.getString("ImageState4_D_Bassem");
							  Rate4_D_Bassem = document.getString("Rate4_D_Bassem");
							  Statues4_D_Bassem = document.getString("Statues4_D_Bassem");

							  Value5_D_Bassem = document.getString("Value5_D_Bassem");
							  ImageState5_D_Bassem = document.getString("ImageState5_D_Bassem");
							  Rate5_D_Bassem = document.getString("Rate5_D_Bassem");
							  Statues5_D_Bassem = document.getString("Statues5_D_Bassem");

							  /// stop progressBar
							  progress_chapter_bassem.setVisibility(View.GONE);

						 }
					} else {
						 progress_chapter_bassem.setVisibility(View.GONE);
						 String msg = task.getException().getMessage();
						 Toast.makeText(getActivity() , "Error in Fragment when load a data" + msg , Toast.LENGTH_SHORT).show();
					}
			   }
		  });
	 }

	 @Override
	 public void onStart() {
		  super.onStart();
		  // getScore();
	 }


	 private void check(Button button , final String state , String imageState , String rate) {

		  int batteryLevel = getBattery(getActivity());
		  if ( batteryLevel < 2 ) {
			   AlertDialog.Builder al = new AlertDialog.Builder(getActivity());
			   al.setTitle("Battery is low")
					   .setCancelable(false)
					   .setMessage("your battery is " + batteryLevel + "% \n " + "\n to start exam you must battery grater than 30% \n" + "Please charge your phone battery to continue.. \n" + "thank you :)")
					   .setNegativeButton("ok" , null);
			   al.create();
			   al.show();

		  } else {

			   button.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {

						 if ( state.equals("1") ) {

						 }

					}
			   });

		  }

	 }


	 // to get battery level
	 private static int getBattery(Context context) {

		  IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
		  Intent batteryStatus = context.registerReceiver(null , filter);

		  int level = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL , -1) : -1;
		  int scale = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE , -1) : -1;

		  float b = level / (float) scale;
		  return (int) (b * 100);

	 }
}
