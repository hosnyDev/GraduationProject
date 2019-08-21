package com.academy.motatwera.Fragment.Social_Home.post;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.academy.motatwera.CheckInternetConn;
import com.academy.motatwera.Fragment.Social_Home.ViewImageHome;
import com.academy.motatwera.Fragment.Social_Home.comment.Comments;
import com.academy.motatwera.Fragment.Social_Home.comment.CommentsActivity;
import com.academy.motatwera.ProfileActivity;
import com.academy.motatwera.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class post_adapter extends RecyclerView.Adapter<post_adapter.ViewHolder> {

	 public List<post_model> blog_list;
	 public Context context;

	 private FirebaseFirestore firebaseFirestore;
	 private FirebaseAuth firebaseAuth;

	 public post_adapter(List<post_model> blog_list) {

		  this.blog_list = blog_list;

	 }

	 @Override
	 public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType) {

		  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_formate , parent , false);
		  context = parent.getContext();
		  firebaseFirestore = FirebaseFirestore.getInstance();
		  firebaseAuth = FirebaseAuth.getInstance();
		  return new ViewHolder(view);
	 }

	 @Override
	 public void onBindViewHolder(final ViewHolder holder , int position) {

		  holder.setIsRecyclable(false);

		  final String blogPostId = blog_list.get(position).post_id;
		  final String currentUserId = firebaseAuth.getCurrentUser().getUid();

		  String desc_data = blog_list.get(position).getDesc();
		  holder.setDescText(desc_data);

		  String image_url = blog_list.get(position).getImage_url();
		  holder.setBlogImage(image_url);

		  String user_id = blog_list.get(position).getUser_id();
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

		  try {
			   long millisecond = blog_list.get(position).getTimestamp().getTime();
			   String dateString = DateFormat.format("dd/MM/yyyy" , new Date(millisecond)).toString();
			   holder.setTime(dateString);
		  } catch (Exception e) {

			   Toast.makeText(context , "Exception : " + e.getMessage() , Toast.LENGTH_SHORT).show();

		  }

		  //Get Likes Count
		  firebaseFirestore.collection("posts/" + blogPostId + "/Likes")
				  .addSnapshotListener(new EventListener<QuerySnapshot>() {
					   @Override
					   public void onEvent(QuerySnapshot documentSnapshots , FirebaseFirestoreException e) {

							if ( !documentSnapshots.isEmpty() ) {

								 int count = documentSnapshots.size();

								 holder.updateLikesCount(count);

							} else {

								 holder.updateLikesCount(0);

							}

					   }
				  });


		  //Get Likes
		  firebaseFirestore.collection("posts/" + blogPostId + "/Likes").document(currentUserId).addSnapshotListener(new EventListener<DocumentSnapshot>() {
			   @Override
			   public void onEvent(DocumentSnapshot documentSnapshot , FirebaseFirestoreException e) {

					if ( documentSnapshot.exists() ) {

						 holder.blogLikeBtn.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_like));

					} else {

						 holder.blogLikeBtn.setImageDrawable(context.getResources().getDrawable(R.mipmap.ic_u_like));

					}

			   }
		  });


		  //Likes Feature
		  holder.blogLikeBtn.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {

					CheckInternetConn conn = new CheckInternetConn(context);

					Boolean ch = conn.isConnection();

					if ( ch ) {

						 firebaseFirestore.collection("posts/" + blogPostId + "/Likes").document(currentUserId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
							  @Override
							  public void onComplete(@NonNull Task<DocumentSnapshot> task) {

								   if ( !task.getResult().exists() ) {

										Map<String, Object> likesMap = new HashMap<>();
										likesMap.put("timestamp" , FieldValue.serverTimestamp());

										firebaseFirestore.collection("posts/" + blogPostId + "/Likes").document(currentUserId).set(likesMap);

								   } else {

										firebaseFirestore.collection("posts/" + blogPostId + "/Likes").document(currentUserId).delete();

								   }

							  }
						 });
					} else {
						 AlertDialog.Builder al = new AlertDialog.Builder(context);
						 al.setCancelable(false)
								 .setMessage("check internet")
								 .setNegativeButton("try again" , null);
						 al.create();
						 al.show();
					}
			   }
		  });


		  firebaseFirestore.collection("posts/" + blogPostId + "/Comments")
				  .addSnapshotListener(new EventListener<QuerySnapshot>() {
					   @Override
					   public void onEvent(QuerySnapshot documentSnapshots , FirebaseFirestoreException e) {

							if ( !documentSnapshots.isEmpty() ) {

								 for ( DocumentChange doc : documentSnapshots.getDocumentChanges() ) {

									  if ( doc.getType() == DocumentChange.Type.ADDED ) {


										   holder.countCommentPost.setText(String.valueOf(documentSnapshots.size()));

									  }
								 }

							} else {
								 holder.countCommentPost.setText("0");

							}

					   }
				  });


		  holder.blogCommentBtn.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View v) {

					Intent commentIntent = new Intent(context , CommentsActivity.class);
					commentIntent.putExtra("blog_post_id" , blogPostId);
					context.startActivity(commentIntent);

			   }
		  });

	 }


	 @Override
	 public int getItemCount() {
		  return blog_list.size();
	 }

	 public class ViewHolder extends RecyclerView.ViewHolder {

		  private View mView;

		  private TextView descView;
		  private ImageView blogImageView;
		  private TextView blogDate;

		  private TextView blogUserName;
		  private CircleImageView blogUserImage;

		  private ImageView blogLikeBtn;
		  private TextView blogLikeCount;
		  private TextView countCommentPost;

		  private LinearLayout blogCommentBtn;


		  public ViewHolder(View itemView) {
			   super(itemView);
			   mView = itemView;

			   blogLikeBtn = mView.findViewById(R.id.blog_like_btn);
			   blogCommentBtn = mView.findViewById(R.id.blog_comment_icon);
			   countCommentPost = mView.findViewById(R.id.countCommentPost);

		  }

		  public void setDescText(String descText) {

			   descView = mView.findViewById(R.id.blog_desc);
			   descView.setText(descText);

		  }

		  public void setBlogImage(final String downloadUri) {

			   blogImageView = mView.findViewById(R.id.blog_image);

			   if ( downloadUri.equals("no") ) {

					blogImageView.setVisibility(View.GONE);

			   } else {
					blogImageView.setVisibility(View.VISIBLE);
					RequestOptions requestOptions = new RequestOptions();
					requestOptions.placeholder(R.drawable.picture);

					Glide.with(context).applyDefaultRequestOptions(requestOptions).load(downloadUri).into(blogImageView);

					blogImageView.setOnClickListener(new View.OnClickListener() {
						 @Override
						 public void onClick(View view) {

							  Intent intent = new Intent(context , ViewImageHome.class);
							  intent.putExtra("img_url" , downloadUri);
							  context.startActivity(intent);

						 }
					});

			   }
		  }

		  public void setTime(String date) {

			   blogDate = mView.findViewById(R.id.timePost);
			   blogDate.setText(date);

		  }

		  public void setUserData(String name , String image) {

			   blogUserImage = mView.findViewById(R.id.blog_user_image);
			   blogUserName = mView.findViewById(R.id.blog_user_name);

			   blogUserName.setText(name);

			   RequestOptions placeholderOption = new RequestOptions();
			   placeholderOption.placeholder(R.drawable.plac_holder);

			   Glide.with(context).applyDefaultRequestOptions(placeholderOption).load(image).into(blogUserImage);

		  }

		  public void updateLikesCount(int count) {

			   blogLikeCount = mView.findViewById(R.id.count_like_post);
			   blogLikeCount.setText(count + " Likes");

		  }

	 }

}