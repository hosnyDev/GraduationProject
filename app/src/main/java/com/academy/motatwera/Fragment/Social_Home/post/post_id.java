package com.academy.motatwera.Fragment.Social_Home.post;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

public class post_id {

	 @Exclude
	 public String post_id;

	 public <T extends post_id> T withId(@NonNull final String post_id) {
		  this.post_id = post_id;
		  return (T) this;
	 }

}
