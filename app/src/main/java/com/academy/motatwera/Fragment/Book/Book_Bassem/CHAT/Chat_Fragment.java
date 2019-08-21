package com.academy.motatwera.Fragment.Book.Book_Bassem.CHAT;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.academy.motatwera.CheckInternetConn;
import com.academy.motatwera.R;
import com.academy.motatwera.Services.Notification_Chat.APIService;
import com.academy.motatwera.Services.Notification_Chat.Client;
import com.academy.motatwera.Services.Notification_Chat.Token;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat_Fragment extends Fragment {

	 /// view
	 private RecyclerView recyclerView;
	 private ProgressBar progress_chat_bassem;
	 private ImageView send_message;
	 private EditText message;
	 private TextView noInternetChat;
	 private RelativeLayout chatContainer;

	 /// studentData
	 private String userID;
	 private String userName;
	 private String imgURL;
	 private String ID;

	 /// firebase
	 private FirebaseAuth mAuth;
	 private DatabaseReference reference;
	 private FirebaseFirestore firebaseFirestore;
	 private DocumentReference mCollection;

	 /// model class
	 private chat_bassem_adapter messageAdapter;
	 private List<chatModel_bassem> mChat;



	 public Chat_Fragment() {
		  // Required empty public constructor
	 }


	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_chat_ , container , false);

		  ///view
		  message = view.findViewById(R.id.message);
		  send_message = view.findViewById(R.id.btn_send);
		  recyclerView = view.findViewById(R.id.recyclerView);
		  progress_chat_bassem = view.findViewById(R.id.progress_chat_bassem);
		  chatContainer = view.findViewById(R.id.chatContainer);
		  noInternetChat = view.findViewById(R.id.noInternetChat);

		  ///firebase
		  mAuth = FirebaseAuth.getInstance();
		  userID = mAuth.getCurrentUser().getUid();
		  firebaseFirestore = FirebaseFirestore.getInstance();

		  recyclerView.setHasFixedSize(true);
		  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
		  linearLayoutManager.setStackFromEnd(true);
		  recyclerView.setLayoutManager(linearLayoutManager);

		  /// on click to send message
		  send_message.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					String msg = message.getText().toString();

					if ( !TextUtils.isEmpty(msg) ) {
						 sendMessage(userID , msg , userName , imgURL , ID);
					} else {
						 Toast.makeText(getActivity() , getString(R.string.muste) , Toast.LENGTH_LONG).show();
					}
					message.setText("");

			   }
		  });

		  return view;
	 }

	 private void sendMessage(final String userID , final String msg , String userName , String imgURL , String ID) {

		  DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
		  HashMap<String, Object> sendHash = new HashMap<>();
		  sendHash.put("message" , msg);
		  sendHash.put("user_id_sender" , userID);
		  sendHash.put("username" , userName);
		  sendHash.put("user_image_url" , imgURL);
		  sendHash.put("user_institute_id" , ID);

		  reference.child("chat_doctor_bassem").push().setValue(sendHash);


	 }

	 // get data from collection
	 private void retrieveStudentData() {

		  mCollection = firebaseFirestore.collection("student_registration").document(userID);
		  mCollection.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
			   @Override
			   public void onComplete(@NonNull Task<DocumentSnapshot> task) {

					if ( task.isSuccessful() ) {
						 DocumentSnapshot document = task.getResult();

						 assert document != null;
						 if ( document.exists() ) {
							  userName = task.getResult().getString("userName");
							  imgURL = task.getResult().getString("img");
							  ID = task.getResult().getString("ID");

						 } else {
							  Toast.makeText(getActivity() , "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
						 }

					} else {
						 Toast.makeText(getActivity() , "Error\n" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
					}

			   }
		  });

	 }

	 private void readMessage() {

		  mChat = new ArrayList<>();
		  reference = FirebaseDatabase.getInstance().getReference("chat_doctor_bassem");
		  reference.addValueEventListener(new ValueEventListener() {
			   @Override
			   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

					mChat.clear();
					for ( DataSnapshot snapshot : dataSnapshot.getChildren() ) {
						 chatModel_bassem chat = snapshot.getValue(chatModel_bassem.class);
						 mChat.add(chat);
					}
					messageAdapter = new chat_bassem_adapter(getActivity() , mChat);
					recyclerView.setVisibility(View.VISIBLE);
					recyclerView.setAdapter(messageAdapter);
					progress_chat_bassem.setVisibility(View.GONE);
			   }

			   @Override
			   public void onCancelled(@NonNull DatabaseError databaseError) {

			   }
		  });

	 }

	 @Override
	 public void onStart() {
		  super.onStart();

		  CheckInternetConn internetConn = new CheckInternetConn(getActivity());
		  boolean isConn = internetConn.isConnection();
		  if ( isConn ) {
			   noInternetChat.setVisibility(View.GONE);
			   chatContainer.setVisibility(View.VISIBLE);
			   retrieveStudentData();
			   readMessage();
		  } else {
			   noInternetChat.setVisibility(View.VISIBLE);
			   chatContainer.setVisibility(View.GONE);
			   progress_chat_bassem.setVisibility(View.GONE);
		  }

	 }

}
