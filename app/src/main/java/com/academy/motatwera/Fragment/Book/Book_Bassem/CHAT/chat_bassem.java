package com.academy.motatwera.Fragment.Book.Book_Bassem.CHAT;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.academy.motatwera.R;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class chat_bassem extends AppCompatActivity {

	 /// view
	 private CircleImageView userImage;
	 private TextView txtUserName;

	 private RecyclerView recyclerView;
	 private ProgressBar progress_chat_bassem;
	 private ImageView send_message;
	 private EditText message;

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

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_chat_bassem);

		  ///view
		  message = findViewById(R.id.message);
		  send_message = findViewById(R.id.btn_send);
		  recyclerView = findViewById(R.id.recyclerView);
		  progress_chat_bassem = findViewById(R.id.progress_chat_bassem);

		  ///firebase
		  mAuth = FirebaseAuth.getInstance();
		  userID = mAuth.getCurrentUser().getUid();
		  firebaseFirestore = FirebaseFirestore.getInstance();

		  /// on click to send message
		  send_message.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					String msg = message.getText().toString();

					if ( !TextUtils.isEmpty(msg) ) {
						 sendMessage(userID , msg , userName , imgURL , ID);
					} else {
						 Toast.makeText(chat_bassem.this , getString(R.string.some) , Toast.LENGTH_LONG).show();
					}
					message.setText("");

			   }
		  });

	 }

	 private void sendMessage(String userID , String msg , String userName , String imgURL , String ID) {

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
							  Toast.makeText(chat_bassem.this , "Error" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
						 }

					} else {
						 Toast.makeText(chat_bassem.this , "Error\n" + task.getException().getMessage() , Toast.LENGTH_SHORT).show();
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
					messageAdapter = new chat_bassem_adapter(chat_bassem.this , mChat);
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
	 protected void onStart() {
		  super.onStart();
		  retrieveStudentData();
		  readMessage();
	 }


}
