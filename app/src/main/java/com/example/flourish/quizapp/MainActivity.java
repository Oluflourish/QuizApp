package com.example.flourish.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int correctAnswers = 0;
    int number = 0;
    boolean isAllQuestionAnswered;
    boolean isQuestionOneAnswered, isQuestionTwoAnswered, isQuestionThreeAnswered, isQuestionFiveAnswered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isCorrectOptions(false);
    }

    public void checkQuestionOne() {
        RadioButton optionOneA = (RadioButton) findViewById(R.id.optionOneA);
        boolean isOptionOneA = optionOneA.isChecked();
        RadioButton optionOneB = (RadioButton) findViewById(R.id.optionOneB);
        boolean isOptionOneB = optionOneB.isChecked();
        RadioButton optionOneC = (RadioButton) findViewById(R.id.optionOneC);
        boolean isOptionOneC = optionOneC.isChecked();
        RadioButton optionOneD = (RadioButton) findViewById(R.id.optionOneD);
        boolean isOptionOneD = optionOneD.isChecked();

        isQuestionOneAnswered = isOptionOneA || isOptionOneB || isOptionOneC || isOptionOneD;

        if (isOptionOneC) {
            correctAnswers = correctAnswers + 20;
        }
    }

    public void checkQuestionTwo() {
        RadioButton optionTwoA = (RadioButton) findViewById(R.id.optionTwoA);
        boolean isOptionTwoA = optionTwoA.isChecked();
        RadioButton optionTwoB = (RadioButton) findViewById(R.id.optionTwoB);
        boolean isOptionTwoB = optionTwoB.isChecked();
        RadioButton optionTwoC = (RadioButton) findViewById(R.id.optionTwoC);
        boolean isOptionTwoC = optionTwoC.isChecked();
        RadioButton optionTwoD = (RadioButton) findViewById(R.id.optionTwoD);
        boolean isOptionTwoD = optionTwoD.isChecked();

        isQuestionTwoAnswered = isOptionTwoA || isOptionTwoB || isOptionTwoC || isOptionTwoD;

        if (isOptionTwoB) {
            correctAnswers = correctAnswers + 20;
        }
    }

    public void checkQuestionThree() {
        EditText answerFieldFour = (EditText) findViewById(R.id.answerFieldFour);
        // Convert to String and trim off space after the answer
        String answerFour = answerFieldFour.getText().toString().trim();

        if (answerFour.equalsIgnoreCase("java")) {
            correctAnswers = correctAnswers + 20;
        }

        isQuestionThreeAnswered = !answerFour.equals("");

    }

    public void checkQuestionFour() {
        TextView answerFieldFour = (TextView) findViewById(R.id.number_text_view);
        String answerFour = answerFieldFour.getText().toString();
        int intValue = Integer.parseInt(answerFour);
        if (intValue == -2) {
            correctAnswers = correctAnswers + 20;
        }
    }

    public void increment(View view) {
        number++;
        display(number);
    }

    public void decrement(View view) {
        number--;
        display(number);
    }

    public void display(int num){
        TextView textView = (TextView) findViewById(R.id.number_text_view);
        textView.setText("" + num);
    }

    public void checkQuestionFive() {
        CheckBox optionFiveA = (CheckBox) findViewById(R.id.optionFiveA);
        boolean isOptionFiveA = optionFiveA.isChecked();
        CheckBox optionFiveB = (CheckBox) findViewById(R.id.optionFiveB);
        boolean isOptionFiveB = optionFiveB.isChecked();
        CheckBox optionFiveC = (CheckBox) findViewById(R.id.optionFiveC);
        boolean isOptionFiveC = optionFiveC.isChecked();
        CheckBox optionFiveD = (CheckBox) findViewById(R.id.optionFiveD);
        boolean isOptionFiveD = optionFiveD.isChecked();

        isQuestionFiveAnswered = isOptionFiveA || isOptionFiveB || isOptionFiveC || isOptionFiveD;

        if (isOptionFiveB) {
            correctAnswers = correctAnswers + 10;
        }
        if (isOptionFiveD) {
            correctAnswers = correctAnswers + 10;
        }

    }

    public void submitQuiz(View view) {
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFive();

        isAllQuestionAnswered = isQuestionOneAnswered && isQuestionTwoAnswered &&
                isQuestionThreeAnswered && isQuestionFiveAnswered;

        if(isAllQuestionAnswered){
            Toast.makeText(MainActivity.this, "Your score is " + correctAnswers + "/100", Toast.LENGTH_SHORT).show();
            isCorrectOptions(true);
            correctAnswers = 0;
        } else {
            Toast.makeText(MainActivity.this, "Please attempt all Questions", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetQuiz(View view) {
        correctAnswers = 0;
        number = 0;
        isAllQuestionAnswered = false;
        setContentView(R.layout.activity_main);
        isCorrectOptions(false);
    }

    public void isCorrectOptions(boolean input){
        ImageView correctOptionOneC = (ImageView) findViewById(R.id.correctOptionOneC);
        ImageView correctOptionTwoB = (ImageView) findViewById(R.id.correctOptionTwoB);
        TextView correctAnswerThree = (TextView) findViewById(R.id.correctAnswerThree);
        TextView correctAnswerFour = (TextView) findViewById(R.id.correctAnswerFour);
        ImageView correctOptionFiveB = (ImageView) findViewById(R.id.correctOptionFiveB);
        ImageView correctOptionFiveD = (ImageView) findViewById(R.id.correctOptionFiveD);

        if(input) {
            correctOptionOneC.setVisibility(View.VISIBLE);
            correctOptionTwoB.setVisibility(View.VISIBLE);
            correctAnswerThree.setVisibility(View.VISIBLE);
            correctAnswerFour.setVisibility(View.VISIBLE);
            correctOptionFiveB.setVisibility(View.VISIBLE) ;
            correctOptionFiveD.setVisibility(View.VISIBLE) ;
        }

        if(!input) {
            correctOptionOneC.setVisibility(View.GONE);
            correctOptionTwoB.setVisibility(View.GONE);
            correctAnswerThree.setVisibility(View.GONE);
            correctAnswerFour.setVisibility(View.GONE);
            correctOptionFiveB.setVisibility(View.GONE);
            correctOptionFiveD.setVisibility(View.GONE);
        }
    }

}
