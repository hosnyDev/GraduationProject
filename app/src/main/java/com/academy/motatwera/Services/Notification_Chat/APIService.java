package com.academy.motatwera.Services.Notification_Chat;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

	 @Headers({
			 "Content-Type:application/json" ,
			 "Authorization:Key=AAAAAd0dBXM:APA91bG1nLqg9jyxHm5z0Usnge7ASR-l-2m7wmdL0XWrSCfgZbf7xuu8-lNC7-Qt7PTMq3_S3em2jEkuZgSAhgRM8vVWUBix_2U23GCe5GxVUCwGSLBsWNfZdgmwb6KpG7eP4hBsajyE"
	 }
	 )

	 @POST("fcm/send")
	 Call<MyResponse> sendNotification(@Body Sender body);
}
