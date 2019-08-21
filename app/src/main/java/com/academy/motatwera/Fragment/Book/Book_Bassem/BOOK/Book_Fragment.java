package com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_1_bassem.Chapter_1_b_Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_2_bassem.Chapter_2_b_Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_3_bassem.Chapter_3_b_Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_4_bassem.Chapter_4_b_Activity;
import com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Chapter_5_bassem.Chapter_5_b_Activity;
import com.academy.motatwera.R;

public class Book_Fragment extends Fragment {

	 public Book_Fragment() {
		  // Required empty public constructor
	 }

	 // view
	 private CardView c_b_1, c_b_2, c_b_3, c_b_4, c_b_5;
	 private SwipeRefreshLayout refresh_D_B;


	 @Override
	 public View onCreateView(LayoutInflater inflater , ViewGroup container ,
							  Bundle savedInstanceState) {
		  // Inflate the layout for this fragment
		  View view = inflater.inflate(R.layout.fragment_book_ , container , false);

		  c_b_1 = view.findViewById(R.id.c_b_1);
		  c_b_2 = view.findViewById(R.id.c_b_2);
		  c_b_3 = view.findViewById(R.id.c_b_3);
		  c_b_4 = view.findViewById(R.id.c_b_4);
		  c_b_5 = view.findViewById(R.id.c_b_5);

		  refresh_D_B = view.findViewById(R.id.refresh_D_B);

		  refresh_D_B.setColorSchemeColors(
				  getResources().getColor(R.color.colorPrimary) ,
				  getResources().getColor(R.color.b2b2b2) ,
				  getResources().getColor(R.color.colorPrimaryDark) ,
				  getResources().getColor(R.color.b2b2b2)
		  );

		  refresh_D_B.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			   @Override
			   public void onRefresh() {

					refresh_D_B.setRefreshing(false);
			   }
		  });

		  // on click to open chapter 1
		  c_b_1.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Chapter_1_b_Activity.class));
			   }
		  });


		  // on click to open chapter 2
		  c_b_2.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Chapter_2_b_Activity.class));
			   }
		  });


		  // on click to open chapter 3
		  c_b_3.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Chapter_3_b_Activity.class));
			   }
		  });


		  // on click to open chapter 4
		  c_b_4.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Chapter_4_b_Activity.class));
			   }
		  });


		  // on click to open chapter 5
		  c_b_5.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {
					startActivity(new Intent(getActivity() , Chapter_5_b_Activity.class));
			   }
		  });


		  return view;
	 }

}
