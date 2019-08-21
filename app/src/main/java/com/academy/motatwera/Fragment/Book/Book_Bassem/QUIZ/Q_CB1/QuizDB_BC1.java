package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDB_BC1 extends SQLiteOpenHelper {

	 private static final String DATABASE_NAME = "quiz_b_1.db";
	 private static final int DATABASE_VERSION = 1;

	 private SQLiteDatabase db;

	 public QuizDB_BC1(Context context) {
		  super(context , DATABASE_NAME , null , DATABASE_VERSION);
	 }

	 @Override
	 public void onCreate(SQLiteDatabase db) {

		  this.db = db;

		  final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
				  QuizBContractC1.QTableBC1.TABLE_NAME_C1b + " ( " +
				  QuizBContractC1.QTableBC1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
				  QuizBContractC1.QTableBC1.COLUMN_QUESTION_C1b + " TEXT, " +
				  QuizBContractC1.QTableBC1.COLUMN_OPTION1_C1b + " TEXT , " +
				  QuizBContractC1.QTableBC1.COLUMN_OPTION2_C1b + " TEXT , " +
				  QuizBContractC1.QTableBC1.COLUMN_OPTION3_C1b + " TEXT , " +
				  QuizBContractC1.QTableBC1.COLUMN_OPTION4_C1b + " TEXT , " +
				  QuizBContractC1.QTableBC1.COLUMN_ANSWER_NO_C1b + " INTEGER " +
				  " )";

		  db.execSQL(SQL_CREATE_QUESTION_TABLE);

		  fillQuestionTable();
	 }


	 @Override
	 public void onUpgrade(SQLiteDatabase sqLiteDatabase , int i , int i1) {

		  db.execSQL("DROP TABLE IF EXISTS " + QuizBContractC1.QTableBC1.TABLE_NAME_C1b);

		  onCreate(db);

	 }


	 private void fillQuestionTable() {

		  // question 1
		  QuestionBC1 q1 = new QuestionBC1(
				  "ما هى المرحله الاولى فى نشأه وتطور علم الوسائط المتعدده" ,
				  "استخدام النظم الرقمية بدلا من الاشارات التماثلية وبالتالى فقد أصبح ممكنا ربط هذه المعدات مع الحاسب الذى يعمل بالنظم الرقمية" ,
				  "انتشار شبكة الانترنت وتطبيقاتها خصوصا عبر محركات البحث ومواقع التواصل الاجتماعى وعملية تهيئتهم وتحسينهم SEO and SMO مع تطور تكنولوجيا الاتصالات وتطبيقات التليفون المحمول Mobil Application ." ,
				  "اتجاه اجهزة الحاسب نحو تصغير الحجم وتسريع العمليات بفاعلية أكثر فى أداء وظائفها وقدرات أكبر فى امكانياتها" ,
				  "هو عبارة عن استخدام اكثر من وسيطين في الاطار الواحد بشكل تفاعلي وليس مستقل وحتى يتحقق التكامل بشكل جيد لابد من التقيد بعدة امور نذكر بعض منها" ,
				  3);
		  addQuestion(q1);

		  // question 2
		  QuestionBC1 q2 = new QuestionBC1(
				  "ما هى الفرديه" ,
				  "تتيح تكنولوجيا الوسائط المتعددة للمستخدم / العميل التعامل مع المعلومات بكفاءة وفعالية واستفادة قصوى ويمكنه الإتصال بشبكة الإنترنت للحصول علي ما يحتاجه من معلومات في كافة مجالات العلوم." ,
				  "هى عناصر الوسائط المتعددة لتناسب المتغيرات فى شخصيات العملاء وقدراتهم واستعداداتهم وخبراتهم السابقة والتى تعتمد على الخبرات الذاتية للعميل.  " ,
				  "وتعني اتاحة عروض الوسائط المتعددة في الوقت الذي يحتاج المستخدم الي التعامل معها و تتطلب هذه الخاصية تصميم وإنتاج مزيد من عروض الوسائط المتعددة ." ,
				  "عبارة عن برامج تمزج بين الكتابات والصور الثابتة والمتحركة والتسجيلات الصوتية والرسومات الخطية لعرض الرسالة، وهي التي يستطيع المتلقي ان يتفاعل معها مستعينا بالكمبيوتر " ,
				  2);
		  addQuestion(q2);

		  // question 3
		  QuestionBC1 q3 = new QuestionBC1(
				  "تعريف الوسائط المتعددة " ,
				  "هى الاستفادة من ابحاث الذكاء الاصطناعى والانجازات التى تحققت فى مجالات تقنية حركة الآلات المبرمجة ( الروبوت ) والرؤية فى الحاسب والتعرف على الحروف وابحاث الكلام مما أضاف ابعادا جديدة الى دمج المعدات المختلفة بآليات الذكاء الاصطناعى وحقق تزاوجا بين موضوعات البحث ." ,
				  ": توفر عروض الوسائط المتعددة بيئات معرفة وتعلم متنوعة يجد فيها العميل كل ما يناسبه ويتحقق ذلك عن طريق توفير مجموعة من البدائل والخيارات المختلفة " ,
				  "يعني مناسبة توقيتات تداخل العناصر المختلفة الموجودة في برنامج الوسائط المتعددة مع التعليق عليها ويراعي أن تتوافق سرعة العرض وإمكانات المستخدم ومراعاة التزامن يساعد علي تحقيق خاصيتي التكامل والتفاعل." ,
				  "عبارة عن برامج تمزج بين الكتابات والصور الثابتة والمتحركة والتسجيلات الصوتية والرسومات الخطية لعرض الرسالة، وهي التي يستطيع المتلقي ان يتفاعل معها مستعينا بالكمبيوتر " ,
				  4);
		  addQuestion(q3);

		  // question 4
		  QuestionBC1 q4 = new QuestionBC1(
				  "ما هو التزامن " ,
				  "مناسبة توقيتات تداخل العناصر المختلفة الموجودة في برنامج الوسائط المتعددة مع التعليق عليها ويراعي أن تتوافق سرعة العرض وإمكانات المستخدم ومراعاة التزامن يساعد علي تحقيق خاصيتي التكامل والتفاعل" ,
				  "B" ,
				  "اتاحة عروض الوسائط المتعددة في الوقت الذي يحتاج المستخدم الي التعامل معها و تتطلب هذه الخاصية تصميم وإنتاج مزيد من عروض الوسائط المتعددة ." ,
				  "استخدام اكثر من وسيطين في الاطار الواحد بشكل تفاعلي وليس مستقل" ,
				  1);
		  addQuestion(q4);

		  // question 5
		  QuestionBC1 q5 = new QuestionBC1(
				  "ما هو التنوع" ,
				  "اتاحة عروض الوسائط المتعددة في الوقت الذي يحتاج المستخدم الي التعامل معها و تتطلب هذه الخاصية تصميم وإنتاج مزيد من عروض الوسائط المتعددة " ,
				  "الاستفادة من ابحاث الذكاء الاصطناعى والانجازات التى تحققت فى مجالات تقنية حركة الآلات المبرمجة ( الروبوت ) والرؤية فى الحاسب والتعرف على الحروف وابحاث الكلام مما أضاف ابعادا جديدة الى دمج المعدات المختلفة بآليات الذكاء الاصطناعى وحقق تزاوجا بين موضوعات البحث ." ,
				  "توفر عروض الوسائط المتعددة بيئات معرفة وتعلم متنوعة يجد فيها العميل كل ما يناسبه ويتحقق ذلك عن طريق توفير مجموعة من البدائل والخيارات المختلفة " ,
				  "عدم الجمع بين وسيلتين بصريتين في نفس الاطار مثل عرض رسوم متحركة في نافذة ومقاطع من لقطات فيديو في نافذة مجاورة." ,
				  3);
		  addQuestion(q5);

		  // question 6
		  QuestionBC1 q6 = new QuestionBC1(
				  "ما هى الكونية " ,
				  "استخدام النظم الرقمية بدلا من الاشارات التماثلية وبالتالى فقد أصبح ممكنا ربط هذه المعدات مع الحاسب الذى يعمل بالنظم الرقمية ." ,
				  "اتاحة عروض الوسائط المتعددة في الوقت الذي يحتاج المستخدم الي التعامل معها و تتطلب هذه الخاصية تصميم وإنتاج مزيد من عروض الوسائط المتعددة " ,
				  "اتجاه اجهزة الحاسب نحو تصغير الحجم وتسريع العمليات بفاعلية أكثر فى أداء وظائفها وقدرات أكبر فى امكانياتها ." ,
				  "تتيح تكنولوجيا الوسائط المتعددة للمستخدم / العميل التعامل مع المعلومات بكفاءة وفعالية واستفادة قصوى ويمكنه الإتصال بشبكة الإنترنت للحصول علي ما يحتاجه من معلومات في كافة مجالات العلوم." ,
				  4);
		  addQuestion(q6);

		  // question 7
		  QuestionBC1 q7 = new QuestionBC1(
				  "ما هى المرحله الثالثه فى نشأه وتطور علم الوسائط المتعدده؟ " ,
				  "انتشار شبكة الانترنت وتطبيقاتها خصوصا عبر محركات البحث ومواقع التواصل الاجتماعى وعملية تهيئتهم وتحسينهم SEO and SMO مع تطور تكنولوجيا الاتصالات وتطبيقات التليفون المحمول Mobil Application ." ,
				  "الاستفادة من ابحاث الذكاء الاصطناعى والانجازات التى تحققت فى مجالات تقنية حركة الآلات المبرمجة ( الروبوت ) والرؤية فى الحاسب والتعرف على الحروف وابحاث الكلام مما أضاف ابعادا جديدة الى دمج المعدات المختلفة بآليات الذكاء الاصطناعى وحقق تزاوجا بين موضوعات البحث ." ,
				  "استخدام النظم الرقمية بدلا من الاشارات التماثلية وبالتالى فقد أصبح ممكنا ربط هذه المعدات مع الحاسب الذى يعمل بالنظم الرقمية .	" ,
				  "اتجاه اجهزة الحاسب نحو تصغير الحجم وتسريع العمليات بفاعلية أكثر فى أداء وظائفها وقدرات أكبر فى امكانياتها ." ,
				  2);
		  addQuestion(q7);

		  // question 8
		  QuestionBC1 q8 = new QuestionBC1(
				  "ما هى التكامليه" ,
				  "يعني مناسبة توقيتات تداخل العناصر المختلفة الموجودة في برنامج الوسائط المتعددة مع التعليق عليها ويراعي أن تتوافق سرعة العرض وإمكانات المستخدم ومراعاة التزامن يساعد علي تحقيق خاصيتي التكامل والتفاعل" ,
				  "هو العلاقة المتبادلة بين المستخدم من جهة وبين برنامج الوسائط المتعددة من ناحية اخرى وكلما زاد كم التفاعل المطروح في البرنامج كلما زادت كفاءة البرنامج فى الترويج وكذلك زادت رغبة العميل في التعامل معه والتعلم من خلاله. " ,
				  "هو عبارة عن استخدام اكثر من وسيطين في الاطار الواحد بشكل تفاعلي وليس مستقل " ,
				  "بها تفرد عناصر الوسائط المتعددة لتناسب المتغيرات فى شخصيات العملاء وقدراتهم واستعداداتهم وخبراتهم السابقة والتى تعتمد على الخبرات الذاتية للعميل. " ,
				  3);
		  addQuestion(q8);

		  // question 9
		  QuestionBC1 q9 = new QuestionBC1(
				  "ما هى الاتاحه" ,
				  "اتجاه اجهزة الحاسب نحو تصغير الحجم وتسريع العمليات بفاعلية أكثر فى أداء وظائفها وقدرات أكبر فى امكانياتها ." ,
				  "يعني مناسبة توقيتات تداخل العناصر المختلفة الموجودة في برنامج الوسائط المتعددة مع التعليق عليها ويراعي أن تتوافق سرعة العرض وإمكانات المستخدم ومراعاة التزامن يساعد علي تحقيق خاصيتي التكامل والتفاعل" ,
				  "بها تفرد عناصر الوسائط المتعددة لتناسب المتغيرات فى شخصيات العملاء وقدراتهم واستعداداتهم وخبراتهم السابقة والتى تعتمد على الخبرات الذاتية للعميل. " ,
				  "اتاحة عروض الوسائط المتعددة في الوقت الذي يحتاج المستخدم الي التعامل معها و تتطلب هذه الخاصية تصميم وإنتاج مزيد من عروض الوسائط المتعددة " ,
				  4);
		  addQuestion(q9);

		  // question 10
		  QuestionBC1 q10 = new QuestionBC1(
				  "ما هو التفاعليه" ,
				  "يعني مناسبة توقيتات تداخل العناصر المختلفة الموجودة في برنامج الوسائط المتعددة مع التعليق عليها ويراعي أن تتوافق سرعة العرض وإمكانات المستخدم ومراعاة التزامن يساعد علي تحقيق خاصيتي التكامل والتفاعل" ,
				  "هو العلاقة المتبادلة بين المستخدم من جهة وبين برنامج الوسائط المتعددة من ناحية اخرى وكلما زاد كم التفاعل المطروح في البرنامج كلما زادت كفاءة البرنامج فى الترويج وكذلك زادت رغبة العميل في التعامل معه والتعلم من خلاله. " ,
				  "الاستفادة من ابحاث الذكاء الاصطناعى والانجازات التى تحققت فى مجالات تقنية حركة الآلات المبرمجة ( الروبوت ) والرؤية فى الحاسب والتعرف على الحروف وابحاث الكلام مما أضاف ابعادا جديدة الى دمج المعدات المختلفة بآليات الذكاء الاصطناعى وحقق تزاوجا بين موضوعات البحث ." ,
				  "بها تفرد عناصر الوسائط المتعددة لتناسب المتغيرات فى شخصيات العملاء وقدراتهم واستعداداتهم وخبراتهم السابقة والتى تعتمد على الخبرات الذاتية للعميل. " ,
				  2);
		  addQuestion(q10);


	 }

	 private void addQuestion(QuestionBC1 questionC1) {

		  ContentValues cv = new ContentValues();
		  cv.put(QuizBContractC1.QTableBC1.COLUMN_QUESTION_C1b , questionC1.getQuestionC1());
		  cv.put(QuizBContractC1.QTableBC1.COLUMN_OPTION1_C1b , questionC1.getOption1C1());
		  cv.put(QuizBContractC1.QTableBC1.COLUMN_OPTION2_C1b , questionC1.getOption2C1());
		  cv.put(QuizBContractC1.QTableBC1.COLUMN_OPTION3_C1b , questionC1.getOption3C1());
		  cv.put(QuizBContractC1.QTableBC1.COLUMN_OPTION4_C1b , questionC1.getOption4C1());
		  cv.put(QuizBContractC1.QTableBC1.COLUMN_ANSWER_NO_C1b , questionC1.getAnswerNoC1());

		  db.insert(QuizBContractC1.QTableBC1.TABLE_NAME_C1b , null , cv);

	 }


	 public List<QuestionBC1> getAllQuestion() {

		  List<QuestionBC1> questionC1List = new ArrayList<>();
		  db = getReadableDatabase();

		  Cursor c = db.rawQuery("SELECT * FROM " + QuizBContractC1.QTableBC1.TABLE_NAME_C1b , null);
		  if ( c.moveToFirst() ) {

			   do {
					QuestionBC1 questionC1 = new QuestionBC1();
					questionC1.setQuestionC1(c.getString(c.getColumnIndex(QuizBContractC1.QTableBC1.COLUMN_QUESTION_C1b)));
					questionC1.setOption1C1(c.getString(c.getColumnIndex(QuizBContractC1.QTableBC1.COLUMN_OPTION1_C1b)));
					questionC1.setOption2C1(c.getString(c.getColumnIndex(QuizBContractC1.QTableBC1.COLUMN_OPTION2_C1b)));
					questionC1.setOption3C1(c.getString(c.getColumnIndex(QuizBContractC1.QTableBC1.COLUMN_OPTION3_C1b)));
					questionC1.setOption4C1(c.getString(c.getColumnIndex(QuizBContractC1.QTableBC1.COLUMN_OPTION4_C1b)));
					questionC1.setAnswerNoC1(c.getInt(c.getColumnIndex(QuizBContractC1.QTableBC1.COLUMN_ANSWER_NO_C1b)));

					questionC1List.add(questionC1);

			   } while (c.moveToNext());
		  }
		  c.close();
		  return questionC1List;
	 }


}
