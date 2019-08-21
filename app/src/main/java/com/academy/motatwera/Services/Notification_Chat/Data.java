package com.academy.motatwera.Services.Notification_Chat;

public class Data {

	 private String user_chat;
	 private String body_chat;
	 private String title_chat;
	 private String sented_chat;
	 private int image_chat;

	 public Data() {
	 }

	 public Data(String user_chat , String body_chat , String title_chat , String sented_chat , int image_chat) {
		  this.user_chat = user_chat;
		  this.body_chat = body_chat;
		  this.title_chat = title_chat;
		  this.sented_chat = sented_chat;
		  this.image_chat = image_chat;
	 }

	 public String getUser_chat() {
		  return user_chat;
	 }

	 public void setUser_chat(String user_chat) {
		  this.user_chat = user_chat;
	 }

	 public String getBody_chat() {
		  return body_chat;
	 }

	 public void setBody_chat(String body_chat) {
		  this.body_chat = body_chat;
	 }

	 public String getTitle_chat() {
		  return title_chat;
	 }

	 public void setTitle_chat(String title_chat) {
		  this.title_chat = title_chat;
	 }

	 public String getSented_chat() {
		  return sented_chat;
	 }

	 public void setSented_chat(String sented_chat) {
		  this.sented_chat = sented_chat;
	 }

	 public int getImage_chat() {
		  return image_chat;
	 }

	 public void setImage_chat(int image_chat) {
		  this.image_chat = image_chat;
	 }
}
