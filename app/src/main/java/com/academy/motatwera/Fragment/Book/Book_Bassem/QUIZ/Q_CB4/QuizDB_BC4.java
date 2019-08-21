package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

public class QuizDB_BC4 extends SQLiteOpenHelper {

	 private static final String DATABASE_NAME = "quiz_b_4.db";
	 private static final int DATABASE_VERSION = 1;

	 private SQLiteDatabase db;

	 public QuizDB_BC4(Context context) {
		  super(context , DATABASE_NAME , null , DATABASE_VERSION);
	 }

	 @Override
	 public void onCreate(SQLiteDatabase db) {

		  this.db = db;

		  final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
				  QuizBContractC4.QTableBC4.TABLE_NAME_C4b + " ( " +
				  QuizBContractC4.QTableBC4._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
				  QuizBContractC4.QTableBC4.COLUMN_QUESTION_C4b + " TEXT, " +
				  QuizBContractC4.QTableBC4.COLUMN_OPTION1_C4b + " TEXT , " +
				  QuizBContractC4.QTableBC4.COLUMN_OPTION2_C4b + " TEXT , " +
				  QuizBContractC4.QTableBC4.COLUMN_OPTION3_C4b + " TEXT , " +
				  QuizBContractC4.QTableBC4.COLUMN_OPTION4_C4b + " TEXT , " +
				  QuizBContractC4.QTableBC4.COLUMN_ANSWER_NO_C4b + " INTEGER " +
				  " )";

		  db.execSQL(SQL_CREATE_QUESTION_TABLE);

		  fillQuestionTable();
	 }


	 @Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {

		  db.execSQL("DROP TABLE IF EXISTS " + QuizBContractC4.QTableBC4.TABLE_NAME_C4b);

		  onCreate(db);

	 }


	 private void fillQuestionTable() {

		  // question 1
		  QuestionBC4 q1 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q1);

		  // question 2
		  QuestionBC4 q2 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q2);

		  // question 3
		  QuestionBC4 q3 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q3);

		  // question 4
		  QuestionBC4 q4 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q4);

		  // question 5
		  QuestionBC4 q5 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q5);

		  // question 6
		  QuestionBC4 q6 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q6);

		  // question 7
		  QuestionBC4 q7 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q7);

		  // question 8
		  QuestionBC4 q8 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q8);

		  // question 9
		  QuestionBC4 q9 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q9);

		  // question 10
		  QuestionBC4 q10 = new QuestionBC4(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q10);


	 }

	 private void addQuestion(QuestionBC4 questionC4) {

		  ContentValues cv = new ContentValues();
		  cv.put(QuizBContractC4.QTableBC4.COLUMN_QUESTION_C4b , questionC4.getQuestionC4b());
		  cv.put(QuizBContractC4.QTableBC4.COLUMN_OPTION1_C4b , questionC4.getOption1C4b());
		  cv.put(QuizBContractC4.QTableBC4.COLUMN_OPTION2_C4b , questionC4.getOption2C4b());
		  cv.put(QuizBContractC4.QTableBC4.COLUMN_OPTION3_C4b , questionC4.getOption3C4b());
		  cv.put(QuizBContractC4.QTableBC4.COLUMN_OPTION4_C4b , questionC4.getOption4C4b());
		  cv.put(QuizBContractC4.QTableBC4.COLUMN_ANSWER_NO_C4b , questionC4.getAnswerNoC4b());

		  db.insert(QuizBContractC4.QTableBC4.TABLE_NAME_C4b , null , cv);

	 }


	 public List<QuestionBC4> getAllQuestion() {

		  List<QuestionBC4> questionC4List = new ArrayList<>();
		  db = getReadableDatabase();

		  Cursor c = db.rawQuery("SELECT * FROM " + QuizBContractC4.QTableBC4.TABLE_NAME_C4b , null);
		  if ( c.moveToFirst() ) {

			   do {
					QuestionBC4 questionC4 = new QuestionBC4();
					questionC4.setQuestionC4b(c.getString(c.getColumnIndex(QuizBContractC4.QTableBC4.COLUMN_QUESTION_C4b)));
					questionC4.setOption1C4b(c.getString(c.getColumnIndex(QuizBContractC4.QTableBC4.COLUMN_OPTION1_C4b)));
					questionC4.setOption2C4b(c.getString(c.getColumnIndex(QuizBContractC4.QTableBC4.COLUMN_OPTION2_C4b)));
					questionC4.setOption3C4b(c.getString(c.getColumnIndex(QuizBContractC4.QTableBC4.COLUMN_OPTION3_C4b)));
					questionC4.setOption4C4b(c.getString(c.getColumnIndex(QuizBContractC4.QTableBC4.COLUMN_OPTION4_C4b)));
					questionC4.setAnswerNoC4b(c.getInt(c.getColumnIndex(QuizBContractC4.QTableBC4.COLUMN_ANSWER_NO_C4b)));

					questionC4List.add(questionC4);

			   } while (c.moveToNext());
		  }
		  c.close();
		  return questionC4List;
	 }


}
