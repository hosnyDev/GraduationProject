package com.academy.motatwera.Fragment.Social_Home.comment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.academy.motatwera.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentsRecyclerAdapter extends RecyclerView.Adapter<CommentsRecyclerAdapter.ViewHolder> {

	 public List<Comments> commentsList;
	 public Context context;

	 private FirebaseFirestore firebaseFirestore;
	 private FirebaseAuth firebaseAuth;

	 public CommentsRecyclerAdapter(List<Comments> commentsList) {

		  this.commentsList = commentsList;

	 }

	 @Override
	 public CommentsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {

		  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_item , parent , false);
		  context = parent.getContext();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  firebaseAuth = FirebaseAuth.getInstance();
		  return new CommentsRecyclerAdapter.ViewHolder(view);
	 }

	 @Override
	 public void onBindViewHolder(final CommentsRecyclerAdapter.ViewHolder holder , int position) {

		  holder.setIsRecyclable(false);

		  String commentMessage = commentsList.get(position).getMessage();
		  holder.setComment_message(commentMessage);


		  String user_id = commentsList.get(position).getUser_id();
		  //User Data will be retrieved here...
		  firebaseFirestore.collection("student_registration")
				  .document(user_id)
				  .get()
				  .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
					   @Override
					   public void onComplete(@NonNull Task<DocumentSnapshot> task) {

							if ( task.isSuccessful() ) {

								 String userName = task.getResult().getString("userName");
								 String userImage = task.getResult().getString("img");

								 holder.setUserData(userName , userImage);


							} else {

								 //Firebase Exception

							}

					   }
				  });


	 }


	 @Override
	 public int getItemCount() {

		  if ( commentsList != null ) {

			   return commentsList.size();

		  } else {

			   return 0;

		  }

	 }

	 public class ViewHolder extends RecyclerView.ViewHolder {

		  private View mView;

		  private TextView blogUserName;
		  private CircleImageView blogUserImage;
		  private TextView comment_message;

		  public ViewHolder(View itemView) {
			   super(itemView);
			   mView = itemView;
		  }

		  public void setComment_message(String message) {

			   comment_message = mView.findViewById(R.id.comment_message);
			   comment_message.setText(message);

		  }

		  public void setUserData(String name , String image) {

			   blogUserImage = mView.findViewById(R.id.comment_image);
			   blogUserName = mView.findViewById(R.id.comment_username);

			   blogUserName.setText(name);

			   RequestOptions placeholderOption = new RequestOptions();
			   placeholderOption.placeholder(R.drawable.plac_holder);

			   Glide.with(context).applyDefaultRequestOptions(placeholderOption).load(image).into(blogUserImage);

		  }


	 }

}