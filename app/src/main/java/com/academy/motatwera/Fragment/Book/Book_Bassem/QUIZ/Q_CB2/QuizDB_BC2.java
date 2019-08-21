package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDB_BC2 extends SQLiteOpenHelper {

	 private static final String DATABASE_NAME = "quiz_b_2.db";
	 private static final int DATABASE_VERSION = 1;

	 private SQLiteDatabase db;

	 public QuizDB_BC2(Context context) {
		  super(context , DATABASE_NAME , null , DATABASE_VERSION);
	 }

	 @Override
	 public void onCreate(SQLiteDatabase db) {

		  this.db = db;

		  final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
				  QuizBContractC2.QTableBC2.TABLE_NAME_C2b + " ( " +
				  QuizBContractC2.QTableBC2._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
				  QuizBContractC2.QTableBC2.COLUMN_QUESTION_C2b + " TEXT, " +
				  QuizBContractC2.QTableBC2.COLUMN_OPTION1_C2b + " TEXT , " +
				  QuizBContractC2.QTableBC2.COLUMN_OPTION2_C2b + " TEXT , " +
				  QuizBContractC2.QTableBC2.COLUMN_OPTION3_C2b + " TEXT , " +
				  QuizBContractC2.QTableBC2.COLUMN_OPTION4_C2b + " TEXT , " +
				  QuizBContractC2.QTableBC2.COLUMN_ANSWER_NO_C2b + " INTEGER " +
				  " )";

		  db.execSQL(SQL_CREATE_QUESTION_TABLE);

		  fillQuestionTable();
	 }


	 @Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {

		  db.execSQL("DROP TABLE IF EXISTS " + QuizBContractC2.QTableBC2.TABLE_NAME_C2b);

		  onCreate(db);

	 }


	 private void fillQuestionTable() {

		  // question 1
		  QuestionBC2 q1 = new QuestionBC2(
				  "ما يمكن عمله من خلال برنامج الفلاش" ,
				  "إنشاء دروس تعليمية تفاعلية." ,
				  "تصميم ألعاب رائعة وعالية الجودة." ,
				  "إنشاء وتصميم مواقع إنترنت مميزة وعالية الجودة" ,
				  "كل ما سبق" ,
				  4);
		  addQuestion(q1);

		  // question 2
		  QuestionBC2 q2 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q2);

		  // question 3
		  QuestionBC2 q3 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q3);

		  // question 4
		  QuestionBC2 q4 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q4);

		  // question 5
		  QuestionBC2 q5 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q5);

		  // question 6
		  QuestionBC2 q6 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q6);

		  // question 7
		  QuestionBC2 q7 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q7);

		  // question 8
		  QuestionBC2 q8 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q8);

		  // question 9
		  QuestionBC2 q9 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "B" ,
				  "C" ,
				  1);
		  addQuestion(q9);

		  // question 10
		  QuestionBC2 q10 = new QuestionBC2(
				  "A is correct c1 " ,
				  "A" ,
				  "B" ,
				  "C" ,
				  "C" ,
				  1);
		  addQuestion(q10);


	 }

	 private void addQuestion(QuestionBC2 questionC2) {

		  ContentValues cv = new ContentValues();
		  cv.put(QuizBContractC2.QTableBC2.COLUMN_QUESTION_C2b , questionC2.getQuestionC2b());
		  cv.put(QuizBContractC2.QTableBC2.COLUMN_OPTION1_C2b , questionC2.getOption1C2b());
		  cv.put(QuizBContractC2.QTableBC2.COLUMN_OPTION2_C2b , questionC2.getOption2C2b());
		  cv.put(QuizBContractC2.QTableBC2.COLUMN_OPTION3_C2b , questionC2.getOption3C2b());
		  cv.put(QuizBContractC2.QTableBC2.COLUMN_OPTION4_C2b , questionC2.getOption4C2b());
		  cv.put(QuizBContractC2.QTableBC2.COLUMN_ANSWER_NO_C2b , questionC2.getAnswerNoC2b());

		  db.insert(QuizBContractC2.QTableBC2.TABLE_NAME_C2b , null , cv);

	 }


	 public List<QuestionBC2> getAllQuestion() {

		  List<QuestionBC2> questionC2List = new ArrayList<>();
		  db = getReadableDatabase();

		  Cursor c = db.rawQuery("SELECT * FROM " + QuizBContractC2.QTableBC2.TABLE_NAME_C2b , null);
		  if ( c.moveToFirst() ) {

			   do {
					QuestionBC2 questionC2 = new QuestionBC2();
					questionC2.setQuestionC2b(c.getString(c.getColumnIndex(QuizBContractC2.QTableBC2.COLUMN_QUESTION_C2b)));
					questionC2.setOption1C2b(c.getString(c.getColumnIndex(QuizBContractC2.QTableBC2.COLUMN_OPTION1_C2b)));
					questionC2.setOption2C2b(c.getString(c.getColumnIndex(QuizBContractC2.QTableBC2.COLUMN_OPTION2_C2b)));
					questionC2.setOption3C2b(c.getString(c.getColumnIndex(QuizBContractC2.QTableBC2.COLUMN_OPTION3_C2b)));
					questionC2.setOption4C2b(c.getString(c.getColumnIndex(QuizBContractC2.QTableBC2.COLUMN_OPTION4_C2b)));
					questionC2.setAnswerNoC2b(c.getInt(c.getColumnIndex(QuizBContractC2.QTableBC2.COLUMN_ANSWER_NO_C2b)));

					questionC2List.add(questionC2);

			   } while (c.moveToNext());
		  }
		  c.close();
		  return questionC2List;
	 }


}
