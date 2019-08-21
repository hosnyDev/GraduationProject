package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.academy.motatwera.CheckInternetConn;
import com.academy.motatwera.MainActivity;
import com.academy.motatwera.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import info.hoang8f.widget.FButton;

public class Qcb2Activity extends AppCompatActivity {


	 // view
	 private TextView mScore, mQuestionCount, mTime, mQuestion;
	 private RadioGroup radioGroup;
	 private RadioButton mR1, mR2, mR3, mR4;
	 private FButton mNext;

	 // quiz class
	 private static final long COUNTDOWN_IN_MILLIS = 30000;
	 private List<QuestionBC2> questionList;
	 private ColorStateList textColorDefaultRb;
	 private ColorStateList textColorDefaultCD;
	 private CountDownTimer countDownTimer;
	 private long timeLeftMillis;

	 private int questionCounter, questionCountTotal;
	 private QuestionBC2 currentQuestion;
	 private static int score;
	 private boolean answered;

	 // firebase
	 private FirebaseAuth mAuth;
	 private String uID;
	 private DocumentReference mCollection;
	 private FirebaseFirestore mFirebaseFirestore;


	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_qcb2);


		  // view
		  mScore = findViewById(R.id.ScoreQ2b);
		  mQuestionCount = findViewById(R.id.countQuestionQ2b);
		  mTime = findViewById(R.id.timeQ2b);
		  mQuestion = findViewById(R.id.questionQ2b);
		  radioGroup = findViewById(R.id.radioGroupQ2b);
		  mR1 = findViewById(R.id.radio1Q2b);
		  mR2 = findViewById(R.id.radio2Q2b);
		  mR3 = findViewById(R.id.radio3Q2b);
		  mR4 = findViewById(R.id.radio4Q2b);
		  mNext = findViewById(R.id.btnQ2b);

		  //set color in FButton  library
		  mNext.setButtonColor(getResources().getColor(R.color.colorPrimary));
		  mNext.setShadowColor(getResources().getColor(R.color.colorAccent));
		  mNext.setShadowEnabled(true);
		  mNext.setShadowHeight(5);
		  mNext.setCornerRadius(5);

		  // firebase
//		  mAuth = FirebaseAuth.getInstance();
//		  mFirebaseFirestore = FirebaseFirestore.getInstance();
//		  uID = mAuth.getCurrentUser().getUid();

		  // quiz var
		  textColorDefaultRb = mR1.getTextColors();
		  textColorDefaultCD = mTime.getTextColors();

		  QuizDB_BC2 db = new QuizDB_BC2(this);
		  questionList = db.getAllQuestion();

		  questionCountTotal = questionList.size();

		  Collections.shuffle(questionList);

		  showNextQuestion();

		  mNext.setOnClickListener(new View.OnClickListener() {
			   @Override
			   public void onClick(View view) {

					if ( !answered ) {

						 if ( mR1.isChecked() || mR2.isChecked() || mR3.isChecked() || mR4.isChecked() ) {

							  checkAnswer();

						 } else {

							  AlertDialog.Builder al = new AlertDialog.Builder(Qcb2Activity.this);
							  al.setMessage("Please select an answer")
									  .setNegativeButton("OK" , null);
							  al.create();
							  al.show();
						 }
					} else {

						 showNextQuestion();

					}

			   }
		  });

	 }


	 private void showNextQuestion() {

		  mR1.setTextColor(textColorDefaultRb);
		  mR2.setTextColor(textColorDefaultRb);
		  mR3.setTextColor(textColorDefaultRb);
		  mR4.setTextColor(textColorDefaultRb);
		  radioGroup.clearCheck();

		  if ( questionCounter < questionCountTotal ) {

			   currentQuestion = questionList.get(questionCounter);
			   mQuestion.setText(currentQuestion.getQuestionC2b());
			   mR1.setText(currentQuestion.getOption1C2b());
			   mR2.setText(currentQuestion.getOption2C2b());
			   mR3.setText(currentQuestion.getOption3C2b());
			   mR4.setText(currentQuestion.getOption4C2b());

			   questionCounter++;
			   mQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
			   answered = false;
			   mNext.setText("Confirm");

			   timeLeftMillis = COUNTDOWN_IN_MILLIS;
			   startCountDown();

		  } else {

			   finishQuiz();

		  }
	 }

	 private void startCountDown() {

		  countDownTimer = new CountDownTimer(timeLeftMillis , 1000) {
			   @Override
			   public void onTick(long l) {

					timeLeftMillis = l;
					updateCountDownText();

			   }

			   @Override
			   public void onFinish() {

					timeLeftMillis = 0;
					updateCountDownText();
					checkAnswer();

			   }
		  }.start();

	 }

	 private void updateCountDownText() {

		  int minutes = (int) (timeLeftMillis / 1000) / 60;
		  int seconds = (int) (timeLeftMillis / 1000) % 60;

		  String timeFormatted = String.format(Locale.getDefault() , "%02d:%02d" , minutes , seconds);
		  mTime.setText(timeFormatted);

		  if ( timeLeftMillis < 10000 ) {
			   mTime.setTextColor(Color.RED);
			   mTime.setTextSize(30);
		  } else {
			   mTime.setTextColor(textColorDefaultCD);
			   mTime.setTextSize(24);

		  }

	 }

	 private void checkAnswer() {

		  answered = true;

		  countDownTimer.cancel();

		  RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
		  int answerNO = radioGroup.indexOfChild(rbSelected) + 1;

		  if ( answerNO == currentQuestion.getAnswerNoC2b() ) {
			   score++;
			   mScore.setText("Score: " + score);

		  }
		  showSolution();

	 }

	 private void showSolution() {

		  mR1.setTextColor(Color.RED);
		  mR2.setTextColor(Color.RED);
		  mR3.setTextColor(Color.RED);
		  mR4.setTextColor(Color.RED);

		  switch (currentQuestion.getAnswerNoC2b()) {
			   case 1:
					mR1.setTextColor(Color.GREEN);
					mQuestion.setText("Answer A is correct");
					break;
			   case 2:
					mR2.setTextColor(Color.GREEN);
					mQuestion.setText("Answer B is correct");
					break;
			   case 3:
					mR3.setTextColor(Color.GREEN);
					mQuestion.setText("Answer C is correct");
					break;
			   case 4:
					mR4.setTextColor(Color.GREEN);
					mQuestion.setText("Answer D is correct");
					break;
		  }

		  if ( questionCounter < questionCountTotal ) {

			   mNext.setText("Next");

		  } else {

			   mNext.setText("Finish");

		  }
	 }

	 private void finishQuiz() {

		  CheckInternetConn conn = new CheckInternetConn(this);

		  Boolean ch = conn.isConnection();

		  if ( ch ) {

			   //updateData(String.valueOf(score));

			   AlertDialog.Builder al = new AlertDialog.Builder(this);
			   al.setMessage("Congratulation your complete quiz chapter 1 successful \n your score is " + score)
					   .setIcon(R.mipmap.ic_cong)
					   .setNegativeButton("OK" , new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface , int i) {
								 startActivity(new Intent(getApplicationContext() , MainActivity.class));

							}
					   });
			   al.create();
			   al.show();

		  } else {

			   AlertDialog.Builder al = new AlertDialog.Builder(this);
			   al.setMessage("No internet connection \n Score in this quiz not calculate \n try again")
					   .setNegativeButton("OK" , null);
			   al.create();
			   al.show();

		  }

	 }

	 @Override
	 public void onBackPressed() {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  al.setMessage("if you exit for this quiz you are loss score exam.. ")
				  .setCancelable(false)
				  .setPositiveButton("Ok" , new DialogInterface.OnClickListener() {
					   @Override
					   public void onClick(DialogInterface dialogInterface , int i) {
							finishQuiz();
					   }
				  }).setNegativeButton("cancel" , null);
		  al.create();
		  al.show();

	 }

	 @Override
	 protected void onDestroy() {
		  super.onDestroy();

		  if ( countDownTimer != null ) {
			   countDownTimer.cancel();
		  }

	 }


}
