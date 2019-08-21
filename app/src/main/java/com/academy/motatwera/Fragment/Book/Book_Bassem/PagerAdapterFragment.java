package com.academy.motatwera.Fragment.Book.Book_Bassem;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.academy.motatwera.Fragment.Book.Book_Bassem.BOOK.Book_Fragment;
import com.academy.motatwera.Fragment.Book.Book_Bassem.CHAT.Chat_Fragment;
import com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Quiz_Fragment;
public class PagerAdapterFragment extends FragmentStatePagerAdapter {

	 int mNumberTab;

	 // Constructor when calling giv Parameter of fragment state and number of Tabs
	 public PagerAdapterFragment(FragmentManager fragmentManager , int mNumberTab) {
		  super(fragmentManager);
		  this.mNumberTab = mNumberTab;
	 }

	 @Override
	 public Fragment getItem(int position) {
		  switch (position) {
			   case 0:
					Book_Fragment tap1 = new Book_Fragment();
					return tap1;

			   case 1:
					Chat_Fragment tap2 = new Chat_Fragment();
					return tap2;
			   case 2:
					Quiz_Fragment tap3 = new Quiz_Fragment();
					return tap3;
			   default:
					return null;
		  }
	 }


	 @Override
	 public int getCount() {
		  return mNumberTab;
	 }
}
