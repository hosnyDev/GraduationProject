package com.academy.motatwera.Fragment.Book.Book_Bassem.CHAT;

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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class chat_bassem_adapter extends RecyclerView.Adapter<chat_bassem_adapter.ViewHolder> {

	 public static final int MSG_TYPE_LEFT = 0;
	 public static final int MSG_TYPE_RIGHT = 1;
	 private Context mContext;
	 private List<chatModel_bassem> chatModel_bassems;


	 FirebaseUser firebaseUser;

	 public chat_bassem_adapter(Context mContext , List<chatModel_bassem> chatModel_bassems) {
		  this.mContext = mContext;
		  this.chatModel_bassems = chatModel_bassems;
	 }

	 @NonNull
	 @Override
	 public chat_bassem_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {

		  if ( i == MSG_TYPE_RIGHT ) {
			   View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_right , viewGroup , false);
			   return new chat_bassem_adapter.ViewHolder(view);
		  } else {
			   View view = LayoutInflater.from(mContext).inflate(R.layout.chat_item_left , viewGroup , false);
			   return new chat_bassem_adapter.ViewHolder(view);
		  }

	 }

	 @Override
	 public void onBindViewHolder(@NonNull chat_bassem_adapter.ViewHolder viewHolder , int i) {

		  chatModel_bassem chat = chatModel_bassems.get(i);

		  viewHolder.chat_show_message.setText(chat.getMessage());
		  viewHolder.chat_userName.setText(chat.getUsername());
		  viewHolder.chat_user_id.setText(chat.getUser_institute_id());

		  if ( chat.getUser_image_url() != null ) {
			   RequestOptions placeholderRequest = new RequestOptions();
			   placeholderRequest.placeholder(R.drawable.plac_holder);
			   Glide.with(mContext).setDefaultRequestOptions(placeholderRequest).load(chat.getUser_image_url()).into(viewHolder.chat_img);
		  } else {
			   viewHolder.chat_img.setImageResource(R.drawable.logo);
		  }


	 }

	 @Override
	 public int getItemCount() {
		  return chatModel_bassems.size();
	 }

	 public class ViewHolder extends RecyclerView.ViewHolder {

		  public TextView chat_userName;
		  public TextView chat_user_id;
		  public TextView chat_show_message;
		  public CircleImageView chat_img;

		  public ViewHolder(@NonNull View itemView) {
			   super(itemView);

			   chat_userName = itemView.findViewById(R.id.chat_userName);
			   chat_user_id = itemView.findViewById(R.id.chat_user_id);
			   chat_show_message = itemView.findViewById(R.id.chat_show_message);
			   chat_img = itemView.findViewById(R.id.chat_img);
		  }

	 }

	 @Override
	 public int getItemViewType(int position) {

		  firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
		  if ( chatModel_bassems.get(position).getUser_id_sender().equals(firebaseUser.getUid()) ) {
			   return MSG_TYPE_RIGHT;
		  } else {
			   return MSG_TYPE_LEFT;
		  }

	 }
}
