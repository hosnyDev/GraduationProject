package com.academy.motatwera.Fragment.Book.Book_Ezzat.Q_CZ1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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

public class Qcz1Activity extends AppCompatActivity {

	 // view
	 private TextView mScore, mQuestionCount, mTime, mQuestion;
	 private RadioGroup radioGroup;
	 private RadioButton mR1, mR2, mR3, mR4;
	 private FButton mNext;

	 // quiz class
	 private static final long COUNTDOWN_IN_MILLIS = 30000;
	 private List<QuestionZC1> questionList;
	 private ColorStateList textColorDefaultRb;
	 private ColorStateList textColorDefaultCD;
	 private CountDownTimer countDownTimer;
	 private long timeLeftMillis;

	 private int questionCounter, questionCountTotal;
	 private QuestionZC1 currentQuestion;
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
		  getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE , WindowManager.LayoutParams.FLAG_SECURE);
		  setContentView(R.layout.activity_qcz1);

		  // view
		  mScore = findViewById(R.id.ScoreQ1z);
		  mQuestionCount = findViewById(R.id.countQuestionQ1z);
		  mTime = findViewById(R.id.timeQ1z);
		  mQuestion = findViewById(R.id.questionQ1z);
		  radioGroup = findViewById(R.id.radioGroupQ1z);
		  mR1 = findViewById(R.id.radio1Q1z);
		  mR2 = findViewById(R.id.radio2Q1z);
		  mR3 = findViewById(R.id.radio3Q1z);
		  mR4 = findViewById(R.id.radio4Q1z);
		  mNext = findViewById(R.id.btnQ1z);

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

		  QuizDB_ZC1 db = new QuizDB_ZC1(this);
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

							  AlertDialog.Builder al = new AlertDialog.Builder(Qcz1Activity.this);
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
			   mQuestion.setText(currentQuestion.getQuestionC1z());
			   mR1.setText(currentQuestion.getOption1C1z());
			   mR2.setText(currentQuestion.getOption2C1z());
			   mR3.setText(currentQuestion.getOption3C1z());
			   mR4.setText(currentQuestion.getOption4C1z());

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

		  if ( answerNO == currentQuestion.getAnswerNoC1z() ) {
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

		  switch (currentQuestion.getAnswerNoC1z()) {
			   case 1:
					mR1.setTextColor(Color.BLUE);
					mQuestion.setText("Answer A is correct");
					break;
			   case 2:
					mR2.setTextColor(Color.BLUE);
					mQuestion.setText("Answer B is correct");
					break;
			   case 3:
					mR3.setTextColor(Color.BLUE);
					mQuestion.setText("Answer C is correct");
					break;
			   case 4:
					mR4.setTextColor(Color.BLUE);
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
			   al.setMessage("Congratulation your complete quiz chapter 1zzz successful \n your score is " + score)
					   .setIcon(getResources().getDrawable(R.drawable.ic_cong))
					   .setTitle("")
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
			   al.setIcon(getResources().getDrawable( R.drawable.ic_no_internet));
			   al.setTitle("")
					   .setMessage("No internet connection \n Score in this quiz not calculate \n try again")
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
				  .setIcon(R.drawable.ic_exit)
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
