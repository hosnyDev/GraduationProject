package com.academy.motatwera.Fragment.Book.Book_Ezzat.Q_CZ1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDB_ZC1 extends SQLiteOpenHelper {

	 private static final String DATABASE_NAME = "quiz_z_1.db";
	 private static final int DATABASE_VERSION = 1;

	 private SQLiteDatabase db;

	 public QuizDB_ZC1(Context context) {
		  super(context , DATABASE_NAME , null , DATABASE_VERSION);
	 }

	 @Override
	 public void onCreate(SQLiteDatabase db) {

		  this.db = db;

		  final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
				  QuizZContractC1.QTableZC1.TABLE_NAME_C1z + " ( " +
				  QuizZContractC1.QTableZC1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
				  QuizZContractC1.QTableZC1.COLUMN_QUESTION_C1z + " TEXT, " +
				  QuizZContractC1.QTableZC1.COLUMN_OPTION1_C1z + " TEXT , " +
				  QuizZContractC1.QTableZC1.COLUMN_OPTION2_C1z + " TEXT , " +
				  QuizZContractC1.QTableZC1.COLUMN_OPTION3_C1z + " TEXT , " +
				  QuizZContractC1.QTableZC1.COLUMN_OPTION4_C1z + " TEXT , " +
				  QuizZContractC1.QTableZC1.COLUMN_ANSWER_NO_C1z + " INTEGER " +
				  " )";

		  db.execSQL(SQL_CREATE_QUESTION_TABLE);

		  fillQuestionTable();
	 }


	 @Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {

		  db.execSQL("DROP TABLE IF EXISTS " + QuizZContractC1.QTableZC1.TABLE_NAME_C1z);

		  onCreate(db);

	 }


	 private void fillQuestionTable() {

		  // question 1
		  QuestionZC1 q1 = new QuestionZC1(
				  " .لو كان هناك تطبيق واكثر من نظام تشغيل , ما هي برامج Java المطلوبة?" ,
				  " برنامج خاص لكل نظام تشغيل" ,
				  "-يوجد 2 برنامج Java" ,
				  "برنامج واحد فقط" ,
				  "جميع االجابات خاطئة" ,
				  3);
		  addQuestion(q1);

		  // question 2
		  QuestionZC1 q2 = new QuestionZC1(
				  " .تستحدم لغة البرمجة Java في أي من :" ,
				  "Google’s Android OS" ,
				  "Desktop Applications Such As Media Players" ,
				  "Web Applications" ,
				  "جميع ما سبق" ,
				  4);
		  addQuestion(q2);

		  // question 3
		  QuestionZC1 q3 = new QuestionZC1(
				  " .أي من الجمل التالية سليمة بما يخص Java" ,
				  "أ- Java لها 3 بليون مستخدم في جميع المجالات التاليه" ,
				  "ب-Java تستخدمها فقط في تطبيقات وكالة ناسا Applications s’NASA " ,
				  "ج- Java تستخدمها فقط في تطبيقات الموبيلات Applications s’Mobile Android" ,
				  "د- جميع االجابات خاطئة" ,
				  1);
		  addQuestion(q3);

		  // question 4
		  QuestionZC1 q4 = new QuestionZC1(
				  " .ما اسم الدالة الرئسية التي يكتب الكود" ,
				  "package" ,
				  "class" ,
				  "main" ,
				  "ليس مما سبق" ,
				  3);
		  addQuestion(q4);

		  // question 5
		  QuestionZC1 q5 = new QuestionZC1(
				  " .ما طريقة كتابة نص في لغة Java" ,
				  "System.printText()" ,
				  "Out.writeText()" ,
				  "System.out()" ,
				  "System.out.println()" ,
				  4);
		  addQuestion(q5);

		  // question 6
		  QuestionZC1 q6 = new QuestionZC1(
				  " .املأ المكان الفارغ في البرنامج التالي\n" +
						  "public static void ......(String[] args)\n" +
						  "{\n" +
						  " System.out.println(“ Higher Institute”);\n" +
						  "}" ,
				  "final" ,
				  "main" ,
				  "privet" ,
				  "for" ,
				  2);
		  addQuestion(q6);

		  // question 7
		  QuestionZC1 q7 = new QuestionZC1(
				  " .اضافة ملحوظة من سطر واحد ال تنفذ وتشرح ما تريد عمله داخل البرنامج تكون بداية السطر" ,
				  "**" ,
				  "*/" ,
				  "??" ,
				  "//" ,
				  4);
		  addQuestion(q7);

		  // question 8
		  QuestionZC1 q8 = new QuestionZC1(
				  "aaaaaaaaaaaaa" ,
				  "aaaaaaaaaaaaa" ,
				  "aaaaaaaaaaaaa" ,
				  "aaaaaaaaaaaaa" ,
				  "aaaaaaaaaaaaa" ,
				  111111111);
		  addQuestion(q8);


		  // question 9
		  QuestionZC1 q9 = new QuestionZC1(
				  " .لو اضفت ملحوظة من عدة أسطر ال تنفذ وتشرح ما تريد عمله داخل البرنامج تكون البداية\n" +
						  "والنهاية\n" +
						  "........" +
						  "ملاحظات علي البرنامج Text Comment" +
						  "......" ,
				  "/* , */ " ,
				  "// , //" ,
				  "*/ , /*" ,
				  "*/ , */" ,
				  1);
		  addQuestion(q9);

		  // question 10
		  QuestionZC1 q10 = new QuestionZC1(
				  ".ما سيتم طباعته علي الشاشة عند تنفيذ البرنامج \n" +
				  "/****************************************************\n" +
						  "This is my program 12/09/2019\n" +
						  "Done by Dr. Ezzat Garras for Java Programming Language\n" +
						  "*****************************************************/",
				  "اول سطر" ,
				  "ثانى سطر" ,
				  "الاول والتانى" ,
				  "لم يتم الطباعه" ,
				  4);
		  addQuestion(q10);


	 }

	 private void addQuestion(QuestionZC1 questionC1) {

		  ContentValues cv = new ContentValues();
		  cv.put(QuizZContractC1.QTableZC1.COLUMN_QUESTION_C1z , questionC1.getQuestionC1z());
		  cv.put(QuizZContractC1.QTableZC1.COLUMN_OPTION1_C1z , questionC1.getOption1C1z());
		  cv.put(QuizZContractC1.QTableZC1.COLUMN_OPTION2_C1z , questionC1.getOption2C1z());
		  cv.put(QuizZContractC1.QTableZC1.COLUMN_OPTION3_C1z , questionC1.getOption3C1z());
		  cv.put(QuizZContractC1.QTableZC1.COLUMN_OPTION4_C1z , questionC1.getOption4C1z());
		  cv.put(QuizZContractC1.QTableZC1.COLUMN_ANSWER_NO_C1z , questionC1.getAnswerNoC1z());

		  db.insert(QuizZContractC1.QTableZC1.TABLE_NAME_C1z , null , cv);

	 }


	 public List<QuestionZC1> getAllQuestion() {

		  List<QuestionZC1> questionC1List = new ArrayList<>();
		  db = getReadableDatabase();

		  Cursor c = db.rawQuery("SELECT * FROM " + QuizZContractC1.QTableZC1.TABLE_NAME_C1z , null);
		  if ( c.moveToFirst() ) {

			   do {
					QuestionZC1 questionC1 = new QuestionZC1();
					questionC1.setQuestionC1z(c.getString(c.getColumnIndex(QuizZContractC1.QTableZC1.COLUMN_QUESTION_C1z)));
					questionC1.setOption1C1z(c.getString(c.getColumnIndex(QuizZContractC1.QTableZC1.COLUMN_OPTION1_C1z)));
					questionC1.setOption2C1z(c.getString(c.getColumnIndex(QuizZContractC1.QTableZC1.COLUMN_OPTION2_C1z)));
					questionC1.setOption3C1z(c.getString(c.getColumnIndex(QuizZContractC1.QTableZC1.COLUMN_OPTION3_C1z)));
					questionC1.setOption4C1z(c.getString(c.getColumnIndex(QuizZContractC1.QTableZC1.COLUMN_OPTION4_C1z)));
					questionC1.setAnswerNoC1z(c.getInt(c.getColumnIndex(QuizZContractC1.QTableZC1.COLUMN_ANSWER_NO_C1z)));

					questionC1List.add(questionC1);

			   } while (c.moveToNext());
		  }
		  c.close();
		  return questionC1List;
	 }


}