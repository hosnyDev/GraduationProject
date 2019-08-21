package com.academy.motatwera.Fragment.Social_Home.post;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.academy.motatwera.Fragment.Social_Home.Create_New_Post;
import com.academy.motatwera.R;
import com.academy.motatwera.SplashActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


	 private FloatingActionButton createPost;
	 private RecyclerView blog_list_view;
	 private List<post_model> blog_list;

	 private FirebaseFirestore firebaseFirestore;
	 private FirebaseAuth firebaseAuth;
	 private post_adapter blogRecyclerAdapter;

	 private DocumentSnapshot lastVisible;
	 private Boolean isFirstPageFirstLoad = true;

	 private ProgressBar progress_home;
	 private ProgressBar progress_load_post;

	 // Required empty public constructor
	 public HomeFragment() {
	 }

	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_home , container , false);

		  blog_list = new ArrayList<>();

		  blog_list_view = view.findViewById(R.id.recyclerViewHome);
		  progress_home = view.findViewById(R.id.progress_home);
		  progress_load_post = view.findViewById(R.id.progress_load_post);
		  createPost = view.findViewById(R.id.createPost);

		  firebaseAuth = FirebaseAuth.getInstance();

		  progress_home.setVisibility(View.VISIBLE);

		  blogRecyclerAdapter = new post_adapter(blog_list);
		  blog_list_view.setLayoutManager(new LinearLayoutManager(container.getContext()));
		  blog_list_view.setAdapter(blogRecyclerAdapter);
		  blog_list_view.setHasFixedSize(true);

		  if ( firebaseAuth.getCurrentUser() != null ) {

			   firebaseFirestore = FirebaseFirestore.getInstance();

			   blog_list_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
					@Override
					public void onScrolled(RecyclerView recyclerView , int dx , int dy) {
						 super.onScrolled(recyclerView , dx , dy);

						 Boolean reachedBottom = !recyclerView.canScrollVertically(1);

						 if ( reachedBottom ) {
							  progress_load_post.setVisibility(View.VISIBLE);
							  loadMorePost();
							  progress_load_post.setVisibility(View.GONE);
						 }

					}
			   });

			   Query firstQuery = firebaseFirestore.collection("posts")
							   .orderBy("timestamp" , Query.Direction.DESCENDING)
							   .limit(5);
			   firstQuery.addSnapshotListener(new EventListener<QuerySnapshot>() {
					@Override
					public void onEvent(QuerySnapshot documentSnapshots , FirebaseFirestoreException e) {

						 if ( !documentSnapshots.isEmpty() ) {

							  if ( isFirstPageFirstLoad ) {

								   lastVisible = documentSnapshots.getDocuments().get(documentSnapshots.size() - 1);
								   blog_list.clear();

							  }

							  for ( DocumentChange doc : documentSnapshots.getDocumentChanges() ) {

								   if ( doc.getType() == DocumentChange.Type.ADDED ) {

										String blogPostId = doc.getDocument().getId();
										post_model blogPost = doc.getDocument()
												.toObject(post_model.class)
												.withId(blogPostId);

										if ( isFirstPageFirstLoad ) {

											 blog_list.add(blogPost);

										} else {

											 blog_list.add(0 , blogPost);

										}


										blogRecyclerAdapter.notifyDataSetChanged();

								   }
							  }
							  progress_home.setVisibility(View.GONE);
							  isFirstPageFirstLoad = false;

						 } else {
							  progress_home.setVisibility(View.GONE);
							  Toast.makeText(getActivity() , "no Data" , Toast.LENGTH_SHORT).show();
						 }

					}

			   });

		  }
		  createPost.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Create_New_Post.class));
//					AlertDialog.Builder a = new AlertDialog.Builder(getActivity());
//					a.setMessage(getWifiName(getActivity()))
//							.setPositiveButton("ok" , null);
//					a.create();
//					a.show();
			   }
		  });

		  return view;
	 }


	 public void loadMorePost() {

		  if ( firebaseAuth.getCurrentUser() != null ) {

			   Query nextQuery = firebaseFirestore.collection("posts")
					   .orderBy("timestamp" , Query.Direction.DESCENDING)
					   .startAfter(lastVisible)
					   .limit(5);

			   nextQuery.addSnapshotListener(new EventListener<QuerySnapshot>() {
					@Override
					public void onEvent(QuerySnapshot documentSnapshots , FirebaseFirestoreException e) {

						 if ( !documentSnapshots.isEmpty() ) {

							  lastVisible = documentSnapshots.getDocuments().get(documentSnapshots.size() - 1);
							  for ( DocumentChange doc : documentSnapshots.getDocumentChanges() ) {

								   if ( doc.getType() == DocumentChange.Type.ADDED ) {

										String blogPostId = doc.getDocument().getId();
										post_model blogPost = doc.getDocument()
												.toObject(post_model.class)
												.withId(blogPostId);
										blog_list.add(blogPost);

										blogRecyclerAdapter.notifyDataSetChanged();
								   }

							  }
							  progress_load_post.setVisibility(View.GONE);
						 }
						 progress_load_post.setVisibility(View.GONE);

					}
			   });

		  } else {
			   startActivity(new Intent(getActivity() , SplashActivity.class));
			   getActivity().finish();
		  }

	 }

	 public String getWifiName(Context context) {
		  WifiManager manager = (WifiManager)
				  getActivity().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
		  if ( manager.isWifiEnabled() ) {
			   WifiInfo wifiInfo = manager.getConnectionInfo();
			   if ( wifiInfo != null ) {
					NetworkInfo.DetailedState state = WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState());
					if ( state == NetworkInfo.DetailedState.CONNECTED || state == NetworkInfo.DetailedState.OBTAINING_IPADDR ) {
						 return wifiInfo.getSSID();
					}
			   }
		  }
		  return null;
	 }
}