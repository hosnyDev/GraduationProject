package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class QuizDB_BC3 extends SQLiteOpenHelper {

	 private static final String DATABASE_NAME = "quiz_b_3.db";
	 private static final int DATABASE_VERSION = 1;

	 private SQLiteDatabase db;

	 public QuizDB_BC3(Context context) {
		  super(context , DATABASE_NAME , null , DATABASE_VERSION);
	 }

	 @Override
	 public void onCreate(SQLiteDatabase db) {

		  this.db = db;

		  final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
				  QuizBContractC3.QTableBC3.TABLE_NAME_C3b + " ( " +
				  QuizBContractC3.QTableBC3._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
				  QuizBContractC3.QTableBC3.COLUMN_QUESTION_C3b + " TEXT, " +
				  QuizBContractC3.QTableBC3.COLUMN_OPTION1_C3b + " TEXT , " +
				  QuizBContractC3.QTableBC3.COLUMN_OPTION2_C3b + " TEXT , " +
				  QuizBContractC3.QTableBC3.COLUMN_OPTION3_C3b + " TEXT , " +
				  QuizBContractC3.QTableBC3.COLUMN_OPTION4_C3b + " TEXT , " +
				  QuizBContractC3.QTableBC3.COLUMN_ANSWER_NO_C3b + " INTEGER " +
				  " )";

		  db.execSQL(SQL_CREATE_QUESTION_TABLE);

		  fillQuestionTable();
	 }


	 @Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {

		  db.execSQL("DROP TABLE IF EXISTS " + QuizBContractC3.QTableBC3.TABLE_NAME_C3b);

		  onCreate(db);

	 }


	 private void fillQuestionTable() {

		  // question 1
		  QuestionBC3 q1 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q1);

		  // question 2
		  QuestionBC3 q2 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q2);

		  // question 3
		  QuestionBC3 q3 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q3);

		  // question 4
		  QuestionBC3 q4 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q4);

		  // question 5
		  QuestionBC3 q5 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q5);

		  // question 6
		  QuestionBC3 q6 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q6);

		  // question 7
		  QuestionBC3 q7 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q7);

		  // question 8
		  QuestionBC3 q8 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q8);

		  // question 9
		  QuestionBC3 q9 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q9);

		  // question 10
		  QuestionBC3 q10 = new QuestionBC3(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q10);


	 }

	 private void addQuestion(QuestionBC3 questionC3) {

		  ContentValues cv = new ContentValues();
		  cv.put(QuizBContractC3.QTableBC3.COLUMN_QUESTION_C3b , questionC3.getQuestionC3b());
		  cv.put(QuizBContractC3.QTableBC3.COLUMN_OPTION1_C3b , questionC3.getOption1C3b());
		  cv.put(QuizBContractC3.QTableBC3.COLUMN_OPTION2_C3b , questionC3.getOption2C3b());
		  cv.put(QuizBContractC3.QTableBC3.COLUMN_OPTION3_C3b , questionC3.getOption3C3b());
		  cv.put(QuizBContractC3.QTableBC3.COLUMN_OPTION4_C3b , questionC3.getOption4C3b());
		  cv.put(QuizBContractC3.QTableBC3.COLUMN_ANSWER_NO_C3b , questionC3.getAnswerNoC3b());

		  db.insert(QuizBContractC3.QTableBC3.TABLE_NAME_C3b , null , cv);

	 }


	 public List<QuestionBC3> getAllQuestion() {

		  List<QuestionBC3> questionC3List = new ArrayList<>();
		  db = getReadableDatabase();

		  Cursor c = db.rawQuery("SELECT * FROM " + QuizBContractC3.QTableBC3.TABLE_NAME_C3b , null);
		  if ( c.moveToFirst() ) {

			   do {
					QuestionBC3 questionC3 = new QuestionBC3();
					questionC3.setQuestionC3b(c.getString(c.getColumnIndex(QuizBContractC3.QTableBC3.COLUMN_QUESTION_C3b)));
					questionC3.setOption1C3b(c.getString(c.getColumnIndex(QuizBContractC3.QTableBC3.COLUMN_OPTION1_C3b)));
					questionC3.setOption2C3b(c.getString(c.getColumnIndex(QuizBContractC3.QTableBC3.COLUMN_OPTION2_C3b)));
					questionC3.setOption3C3b(c.getString(c.getColumnIndex(QuizBContractC3.QTableBC3.COLUMN_OPTION3_C3b)));
					questionC3.setOption4C3b(c.getString(c.getColumnIndex(QuizBContractC3.QTableBC3.COLUMN_OPTION4_C3b)));
					questionC3.setAnswerNoC3b(c.getInt(c.getColumnIndex(QuizBContractC3.QTableBC3.COLUMN_ANSWER_NO_C3b)));

					questionC3List.add(questionC3);

			   } while (c.moveToNext());
		  }
		  c.close();
		  return questionC3List;
	 }


}
