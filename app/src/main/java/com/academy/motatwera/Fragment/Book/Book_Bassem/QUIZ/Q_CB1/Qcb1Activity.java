package com.academy.motatwera.Fragment.Book.Book_Bassem.QUIZ.Q_CB1;

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

public class Qcb1Activity extends AppCompatActivity {


	 // view
	 private TextView mScore, mQuestionCount, mTime, mQuestion;
	 private RadioGroup radioGroup;
	 private RadioButton mR1, mR2, mR3, mR4;
	 private FButton mNext;

	 // quiz class
	 private static final long COUNTDOWN_IN_MILLIS = 30000;
	 private List<QuestionBC1> questionList;
	 private ColorStateList textColorDefaultRb;
	 private ColorStateList textColorDefaultCD;
	 private CountDownTimer countDownTimer;
	 private long timeLeftMillis;

	 private int questionCounter, questionCountTotal;
	 private QuestionBC1 currentQuestion;
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
		  setContentView(R.layout.activity_qcb1);


		  // view
		  mScore = findViewById(R.id.ScoreQ1b);
		  mQuestionCount = findViewById(R.id.countQuestionQ1b);
		  mTime = findViewById(R.id.timeQ1b);
		  mQuestion = findViewById(R.id.questionQ1b);
		  radioGroup = findViewById(R.id.radioGroupQ1b);
		  mR1 = findViewById(R.id.radio1Q1b);
		  mR2 = findViewById(R.id.radio2Q1b);
		  mR3 = findViewById(R.id.radio3Q1b);
		  mR4 = findViewById(R.id.radio4Q1b);
		  mNext = findViewById(R.id.btnQ1b);

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

		  QuizDB_BC1 db = new QuizDB_BC1(this);
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

							  AlertDialog.Builder al = new AlertDialog.Builder(Qcb1Activity.this);
							  al.setMessage(R.string.please_select)
									  .setNegativeButton(R.string.ok , null);
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
			   mQuestion.setText(currentQuestion.getQuestionC1());
			   mR1.setText(currentQuestion.getOption1C1());
			   mR2.setText(currentQuestion.getOption2C1());
			   mR3.setText(currentQuestion.getOption3C1());
			   mR4.setText(currentQuestion.getOption4C1());

			   questionCounter++;
			   mQuestionCount.setText(getString(R.string.q) + questionCounter + "/" + questionCountTotal);
			   answered = false;
			   mNext.setText(getString(R.string.con));

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

		  if ( answerNO == currentQuestion.getAnswerNoC1() ) {
			   score++;
			   mScore.setText(getString(R.string.scor) + score);

		  }
		  showSolution();

	 }

	 private void showSolution() {

		  mR1.setTextColor(Color.RED);
		  mR2.setTextColor(Color.RED);
		  mR3.setTextColor(Color.RED);
		  mR4.setTextColor(Color.RED);

		  switch (currentQuestion.getAnswerNoC1()) {
			   case 1:
					mR1.setTextColor(Color.GREEN);
					mQuestion.setText(getString(R.string.A));
					break;
			   case 2:
					mR2.setTextColor(Color.GREEN);
					mQuestion.setText(getString(R.string.B));
					break;
			   case 3:
					mR3.setTextColor(Color.GREEN);
					mQuestion.setText(getString(R.string.C));
					break;
			   case 4:
					mR4.setTextColor(Color.GREEN);
					mQuestion.setText(getString(R.string.D));
					break;
		  }

		  if ( questionCounter < questionCountTotal ) {

			   mNext.setText(getString(R.string.Next));

		  } else {

			   mNext.setText(getString(R.string.Finish));

		  }
	 }

	 private void finishQuiz() {

		  CheckInternetConn conn = new CheckInternetConn(this);

		  Boolean ch = conn.isConnection();

		  if ( ch ) {

			   //updateData(String.valueOf(score));

			   AlertDialog.Builder al = new AlertDialog.Builder(this);
			   al.setMessage(getString(R.string.complete) + score)
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
			   al.setMessage(R.string.not)
					   .setNegativeButton(R.string.ok_ , null);
			   al.create();
			   al.show();

		  }

	 }

	 @Override
	 public void onBackPressed() {

		  AlertDialog.Builder al = new AlertDialog.Builder(this);
		  al.setMessage(R.string.arelo)
				  .setCancelable(false)
				  .setPositiveButton(R.string.ok_ , new DialogInterface.OnClickListener() {
					   @Override
					   public void onClick(DialogInterface dialogInterface , int i) {
							finishQuiz();
					   }
				  }).setNegativeButton(R.string.cancel , null);
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
