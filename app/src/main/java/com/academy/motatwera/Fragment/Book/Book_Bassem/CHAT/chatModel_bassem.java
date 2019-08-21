package com.academy.motatwera.Fragment.Book.Book_Bassem.CHAT;

public class chatModel_bassem {


	 private String message;
	 private String user_id_sender;
	 private String user_image_url;
	 private String user_institute_id;
	 private String username;

	 public chatModel_bassem(String message , String user_id_sender , String user_image_url , String user_institute_id , String username) {
		  this.message = message;
		  this.user_id_sender = user_id_sender;
		  this.user_image_url = user_image_url;
		  this.user_institute_id = user_institute_id;
		  this.username = username;
	 }

	 public chatModel_bassem() {
	 }

	 public String getMessage() {
		  return message;
	 }

	 public void setMessage(String message) {
		  this.message = message;
	 }

	 public String getUser_id_sender() {
		  return user_id_sender;
	 }

	 public void setUser_id_sender(String user_id_sender) {
		  this.user_id_sender = user_id_sender;
	 }

	 public String getUser_image_url() {
		  return user_image_url;
	 }

	 public void setUser_image_url(String user_image_url) {
		  this.user_image_url = user_image_url;
	 }

	 public String getUser_institute_id() {
		  return user_institute_id;
	 }

	 public void setUser_institute_id(String user_institute_id) {
		  this.user_institute_id = user_institute_id;
	 }

	 public String getUsername() {
		  return username;
	 }

	 public void setUsername(String username) {
		  this.username = username;
	 }
}
