package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDB_BC5  extends SQLiteOpenHelper {

	 private static final String DATABASE_NAME = "quiz_b_5.db";
	 private static final int DATABASE_VERSION = 1;

	 private SQLiteDatabase db;

	 public QuizDB_BC5(Context context) {
		  super(context , DATABASE_NAME , null , DATABASE_VERSION);
	 }

	 @Override
	 public void onCreate(SQLiteDatabase db) {

		  this.db = db;

		  final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
				  QuizBContractC5.QTableBC5.TABLE_NAME_C5b + " ( " +
				  QuizBContractC5.QTableBC5._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
				  QuizBContractC5.QTableBC5.COLUMN_QUESTION_C5b + " TEXT, " +
				  QuizBContractC5.QTableBC5.COLUMN_OPTION1_C5b + " TEXT , " +
				  QuizBContractC5.QTableBC5.COLUMN_OPTION2_C5b + " TEXT , " +
				  QuizBContractC5.QTableBC5.COLUMN_OPTION3_C5b + " TEXT , " +
				  QuizBContractC5.QTableBC5.COLUMN_OPTION4_C5b + " TEXT , " +
				  QuizBContractC5.QTableBC5.COLUMN_ANSWER_NO_C5b + " INTEGER " +
				  " )";

		  db.execSQL(SQL_CREATE_QUESTION_TABLE);

		  fillQuestionTable();
	 }


	 @Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {

		  db.execSQL("DROP TABLE IF EXISTS " + QuizBContractC5.QTableBC5.TABLE_NAME_C5b);

		  onCreate(db);

	 }


	 private void fillQuestionTable() {

		  // question 1
		  QuestionBC5 q1 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q1);

		  // question 2
		  QuestionBC5 q2 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q2);

		  // question 3
		  QuestionBC5 q3 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q3);

		  // question 4
		  QuestionBC5 q4 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q4);

		  // question 5
		  QuestionBC5 q5 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q5);

		  // question 6
		  QuestionBC5 q6 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q6);

		  // question 7
		  QuestionBC5 q7 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q7);

		  // question 8
		  QuestionBC5 q8 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q8);

		  // question 9
		  QuestionBC5 q9 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q9);

		  // question 10
		  QuestionBC5 q10 = new QuestionBC5(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q10);


	 }

	 private void addQuestion(QuestionBC5 questionC5) {

		  ContentValues cv = new ContentValues();
		  cv.put(QuizBContractC5.QTableBC5.COLUMN_QUESTION_C5b , questionC5.getQuestionC5b());
		  cv.put(QuizBContractC5.QTableBC5.COLUMN_OPTION1_C5b , questionC5.getOption1C5b());
		  cv.put(QuizBContractC5.QTableBC5.COLUMN_OPTION2_C5b , questionC5.getOption2C5b());
		  cv.put(QuizBContractC5.QTableBC5.COLUMN_OPTION3_C5b , questionC5.getOption3C5b());
		  cv.put(QuizBContractC5.QTableBC5.COLUMN_OPTION4_C5b , questionC5.getOption4C5b());
		  cv.put(QuizBContractC5.QTableBC5.COLUMN_ANSWER_NO_C5b , questionC5.getAnswerNoC5b());

		  db.insert(QuizBContractC5.QTableBC5.TABLE_NAME_C5b , null , cv);

	 }


	 public List<QuestionBC5> getAllQuestion() {

		  List<QuestionBC5> questionC5List = new ArrayList<>();
		  db = getReadableDatabase();

		  Cursor c = db.rawQuery("SELECT * FROM " + QuizBContractC5.QTableBC5.TABLE_NAME_C5b , null);
		  if ( c.moveToFirst() ) {

			   do {
					QuestionBC5 questionC5 = new QuestionBC5();
					questionC5.setQuestionC5b(c.getString(c.getColumnIndex(QuizBContractC5.QTableBC5.COLUMN_QUESTION_C5b)));
					questionC5.setOption1C5b(c.getString(c.getColumnIndex(QuizBContractC5.QTableBC5.COLUMN_OPTION1_C5b)));
					questionC5.setOption2C5b(c.getString(c.getColumnIndex(QuizBContractC5.QTableBC5.COLUMN_OPTION2_C5b)));
					questionC5.setOption3C5b(c.getString(c.getColumnIndex(QuizBContractC5.QTableBC5.COLUMN_OPTION3_C5b)));
					questionC5.setOption4C5b(c.getString(c.getColumnIndex(QuizBContractC5.QTableBC5.COLUMN_OPTION4_C5b)));
					questionC5.setAnswerNoC5b(c.getInt(c.getColumnIndex(QuizBContractC5.QTableBC5.COLUMN_ANSWER_NO_C5b)));

					questionC5List.add(questionC5);

			   } while (c.moveToNext());
		  }
		  c.close();
		  return questionC5List;
	 }


}
