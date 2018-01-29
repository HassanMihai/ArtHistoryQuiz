package com.example.android.arthistoryquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class PaintingActivity extends MainActivity {

    RadioButton paintingQ1A1;
    RadioButton paintingQ2A1;
    RadioButton paintingQ3A3;
    RadioButton paintingQ4A3;
    RadioButton paintingQ5A3;
    CheckBox paintingQ6A1;
    CheckBox paintingQ6A2;
    CheckBox paintingQ6A3;
    RadioButton paintingQ7A1;
    RadioButton paintingQ8A1;
    RadioButton paintingQ9A3;
    EditText paintingQ10A1;

    TextView paintingQ1Verify;
    TextView paintingQ2Verify;
    TextView paintingQ3Verify;
    TextView paintingQ4Verify;
    TextView paintingQ5Verify;
    TextView paintingQ6Verify;
    TextView paintingQ7Verify;
    TextView paintingQ8Verify;
    TextView paintingQ9Verify;
    TextView paintingQ10Verify;

    int q1score = 0;
    int q2score = 0;
    int q3score = 0;
    int q4score = 0;
    int q5score = 0;
    int q6score = 0;
    int q7score = 0;
    int q8score = 0;
    int q9score = 0;
    int q10score = 0;

    static final String QUESTION_ONE = "q1check";
    static final String QUESTION_TWO = "q2check";
    static final String QUESTION_THREE = "q3check";
    static final String QUESTION_FOUR = "q4check";
    static final String QUESTION_FIVE = "q5check";
    static final String QUESTION_SIX = "q6check";
    static final String QUESTION_SEVEN = "q7check";
    static final String QUESTION_EIGHT = "q8check";
    static final String QUESTION_NINE = "q9check";
    static final String QUESTION_TEN = "q10check";

    String q1check = "";
    String q2check = "";
    String q3check = "";
    String q4check = "";
    String q5check = "";
    String q6check = "";
    String q7check = "";
    String q8check = "";
    String q9check = "";
    String q10check = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painting);

        paintingQ1A1 = findViewById(R.id.paintingQ1A1);
        paintingQ2A1 = findViewById(R.id.paintingQ2A1);
        paintingQ3A3 = findViewById(R.id.paintingQ3A3);
        paintingQ4A3 = findViewById(R.id.paintingQ4A3);
        paintingQ5A3 = findViewById(R.id.paintingQ5A3);
        paintingQ6A1 = findViewById(R.id.paintingQ6A1);
        paintingQ6A2 = findViewById(R.id.paintingQ6A2);
        paintingQ6A3 = findViewById(R.id.paintingQ6A3);
        paintingQ7A1 = findViewById(R.id.paintingQ7A1);
        paintingQ8A1 = findViewById(R.id.paintingQ8A1);
        paintingQ9A3 = findViewById(R.id.paintingQ9A3);
        paintingQ10A1 = findViewById(R.id.paintingQ10A1);
        paintingQ1Verify = findViewById(R.id.paintingQ1Verify);
        paintingQ2Verify = findViewById(R.id.paintingQ2Verify);
        paintingQ3Verify = findViewById(R.id.paintingQ3Verify);
        paintingQ4Verify = findViewById(R.id.paintingQ4Verify);
        paintingQ5Verify = findViewById(R.id.paintingQ5Verify);
        paintingQ6Verify = findViewById(R.id.paintingQ6Verify);
        paintingQ7Verify = findViewById(R.id.paintingQ7Verify);
        paintingQ8Verify = findViewById(R.id.paintingQ8Verify);
        paintingQ9Verify = findViewById(R.id.paintingQ9Verify);
        paintingQ10Verify = findViewById(R.id.paintingQ10Verify);
    }

    /**
     * This method saves the state of textView that displays if the
     * answers are correct or wrong.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(QUESTION_ONE, q1check);
        outState.putString(QUESTION_TWO, q2check);
        outState.putString(QUESTION_THREE, q3check);
        outState.putString(QUESTION_FOUR, q4check);
        outState.putString(QUESTION_FIVE, q5check);
        outState.putString(QUESTION_SIX, q6check);
        outState.putString(QUESTION_SEVEN, q7check);
        outState.putString(QUESTION_EIGHT, q8check);
        outState.putString(QUESTION_NINE, q9check);
        outState.putString(QUESTION_TEN, q10check);
    }

    /**
     * This method restores the state of textView that displays if the
     * answers are correct or wrong.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        q1check = savedInstanceState.getString(QUESTION_ONE);
        q2check = savedInstanceState.getString(QUESTION_TWO);
        q3check = savedInstanceState.getString(QUESTION_THREE);
        q4check = savedInstanceState.getString(QUESTION_FOUR);
        q5check = savedInstanceState.getString(QUESTION_FIVE);
        q6check = savedInstanceState.getString(QUESTION_SIX);
        q7check = savedInstanceState.getString(QUESTION_SEVEN);
        q8check = savedInstanceState.getString(QUESTION_EIGHT);
        q9check = savedInstanceState.getString(QUESTION_NINE);
        q10check = savedInstanceState.getString(QUESTION_TEN);
        displayQ1Check();
        displayQ2Check();
        displayQ3Check();
        displayQ4Check();
        displayQ5Check();
        displayQ6Check();
        displayQ7Check();
        displayQ8Check();
        displayQ9Check();
        displayQ10Check();
    }

    /**
     * This method hides keyboard when EditText lose focus.
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * This method checks the answers if are correct or wrong.
     */
    public void submitAnswers(View view) {

        if (paintingQ1A1.isChecked()) {
            q1score = 1;
            q1check = getResources().getString(R.string.correct);
            displayQ1Check();
        }
        else {
            q1score = 0;
            q1check = getResources().getString(R.string.wrong);
            displayQ1Check();
        }

        if (paintingQ2A1.isChecked()) {
            q2score = 1;
            q2check = getResources().getString(R.string.correct);
            displayQ2Check();
        }
        else {
            q2score = 0;
            q2check = getResources().getString(R.string.wrong);
            displayQ2Check();
        }

        if (paintingQ3A3.isChecked()) {
            q3score = 1;
            q3check = getResources().getString(R.string.correct);
            displayQ3Check();
        }
        else {
            q3score = 0;
            q3check = getResources().getString(R.string.wrong);
            displayQ3Check();
        }

        if (paintingQ4A3.isChecked()) {
            q4score = 1;
            q4check = getResources().getString(R.string.correct);
            displayQ4Check();
        }
        else {
            q4score = 0;
            q4check = getResources().getString(R.string.wrong);
            displayQ4Check();
        }

        if (paintingQ5A3.isChecked()) {
            q5score = 1;
            q5check = getResources().getString(R.string.correct);
            displayQ5Check();
        }
        else {
            q5score = 0;
            q5check = getResources().getString(R.string.wrong);
            displayQ5Check();
        }

        if (paintingQ6A1.isChecked() && paintingQ6A2.isChecked() && !paintingQ6A3.isChecked()) {
            q6score = 1;
            q6check = getResources().getString(R.string.correct);
            displayQ6Check();
        }
        else {
            q6score = 0;
            q6check = getResources().getString(R.string.wrong);
            displayQ6Check();
        }

        if (paintingQ7A1.isChecked()) {
            q7score = 1;
            q7check = getResources().getString(R.string.correct);
            displayQ7Check();
        }
        else {
            q7score = 0;
            q7check = getResources().getString(R.string.wrong);
            displayQ7Check();
        }

        if (paintingQ8A1.isChecked()) {
            q8score = 1;
            q8check = getResources().getString(R.string.correct);
            displayQ8Check();
        }
        else {
            q8score = 0;
            q8check = getResources().getString(R.string.wrong);
            displayQ8Check();
        }

        if (paintingQ9A3.isChecked()) {
            q9score = 1;
            q9check = getResources().getString(R.string.correct);
            displayQ9Check();
        }
        else {
            q9score = 0;
            q9check = getResources().getString(R.string.wrong);
            displayQ9Check();
        }

        String paintingQ10A1Text = paintingQ10A1.getText().toString();

        if (paintingQ10A1Text.equals("1")) {
            q10score = 1;
            q10check = getResources().getString(R.string.correct);
            displayQ10Check();
        }
        else {
            q10score = 0;
            q10check = getResources().getString(R.string.wrong);
            displayQ10Check();
        }

        int paintingScore = calculateScore(q1score, q2score, q3score, q4score, q5score, q6score, q7score, q8score, q9score, q10score);

        saveScore(paintingScore);

        viewScore(paintingScore);
    }

    /**
     * This method calculate the score.
     */
    public int calculateScore(int q1score, int q2score, int q3score, int q4score, int q5score,
                              int q6score, int q7score, int q8score, int q9score, int q10score) {
        int score;
        score = q1score + q2score + q3score + q4score + q5score + q6score + q7score + q8score + q9score + q10score;

        return score;
    }

    /**
     * This method save the score on SharedPreferences.
     */
    public void saveScore(int score) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(PaintingActivity.this);

        SharedPreferences.Editor myEditor = myPreferences.edit();

        myEditor.putInt("PAINTING", score);
        myEditor.commit();
    }

    /**
     * This method show the score in ScoreActivity.
     */
    public void viewScore(int score) {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

    /**
     * This method sets and display text if answer for question 1 is correct or wrong.
     */
    public void displayQ1Check() {
        if (q1check.equals(getResources().getString(R.string.correct))){
            paintingQ1Verify.setText(q1check);
            paintingQ1Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q1check.equals(getResources().getString(R.string.wrong))) {
            String q1wrong = q1check;
            q1wrong += "\n" + getResources().getString(R.string.correct_answer);
            q1wrong += " " + getResources().getString(R.string.paintingQ1A1);
            paintingQ1Verify.setText(q1wrong);
            paintingQ1Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 2 is correct or wrong.
     */
    public void displayQ2Check() {
        if (q2check.equals(getResources().getString(R.string.correct))){
            paintingQ2Verify.setText(q2check);
            paintingQ2Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q2check.equals(getResources().getString(R.string.wrong))) {
            String q2wrong = q2check;
            q2wrong += "\n" + getResources().getString(R.string.correct_answer);
            q2wrong += " " + getResources().getString(R.string.paintingQ2A1);
            paintingQ2Verify.setText(q2wrong);
            paintingQ2Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 3 is correct or wrong.
     */
    public void displayQ3Check() {
        if (q3check.equals(getResources().getString(R.string.correct))){
            paintingQ3Verify.setText(q3check);
            paintingQ3Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q3check.equals(getResources().getString(R.string.wrong))) {
            String q3wrong = q3check;
            q3wrong += "\n" + getResources().getString(R.string.correct_answer);
            q3wrong += " " + getResources().getString(R.string.paintingQ3A3);
            paintingQ3Verify.setText(q3wrong);
            paintingQ3Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 4 is correct or wrong.
     */
    public void displayQ4Check() {
        if (q4check.equals(getResources().getString(R.string.correct))){
            paintingQ4Verify.setText(q4check);
            paintingQ4Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q4check.equals(getResources().getString(R.string.wrong))) {
            String q4wrong = q4check;
            q4wrong += "\n" + getResources().getString(R.string.correct_answer);
            q4wrong += " " + getResources().getString(R.string.paintingQ4A3);
            paintingQ4Verify.setText(q4wrong);
            paintingQ4Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 5 is correct or wrong.
     */
    public void displayQ5Check() {
        if (q5check.equals(getResources().getString(R.string.correct))){
            paintingQ5Verify.setText(q5check);
            paintingQ5Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q5check.equals(getResources().getString(R.string.wrong))) {
            String q5wrong = q5check;
            q5wrong += "\n" + getResources().getString(R.string.correct_answer);
            q5wrong += " " + getResources().getString(R.string.paintingQ5A3);
            paintingQ5Verify.setText(q5wrong);
            paintingQ5Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 6 is correct or wrong.
     */
    public void displayQ6Check() {
        if (q6check.equals(getResources().getString(R.string.correct))){
            paintingQ6Verify.setText(q5check);
            paintingQ6Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q6check.equals(getResources().getString(R.string.wrong))) {
            String q6wrong = q6check;
            q6wrong += "\n" + getResources().getString(R.string.correct_answer);
            q6wrong += " " + getResources().getString(R.string.paintingQ6A1);
            q6wrong += " " + getResources().getString(R.string.paintingQ6A2);
            paintingQ6Verify.setText(q6wrong);
            paintingQ6Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 7 is correct or wrong.
     */
    public void displayQ7Check() {
        if (q7check.equals(getResources().getString(R.string.correct))){
            paintingQ7Verify.setText(q7check);
            paintingQ7Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q7check.equals(getResources().getString(R.string.wrong))) {
            String q7wrong = q7check;
            q7wrong += "\n" + getResources().getString(R.string.correct_answer);
            q7wrong += " " + getResources().getString(R.string.paintingQ7A1);
            paintingQ7Verify.setText(q7wrong);
            paintingQ7Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 8 is correct or wrong.
     */
    public void displayQ8Check() {
        if (q8check.equals(getResources().getString(R.string.correct))){
            paintingQ8Verify.setText(q8check);
            paintingQ8Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q8check.equals(getResources().getString(R.string.wrong))) {
            String q8wrong = q8check;
            q8wrong += "\n" + getResources().getString(R.string.correct_answer);
            q8wrong += " " + getResources().getString(R.string.paintingQ8A1);
            paintingQ8Verify.setText(q8wrong);
            paintingQ8Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 9 is correct or wrong.
     */
    public void displayQ9Check() {
        if (q9check.equals(getResources().getString(R.string.correct))){
            paintingQ9Verify.setText(q9check);
            paintingQ9Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q9check.equals(getResources().getString(R.string.wrong))) {
            String q9wrong = q9check;
            q9wrong += "\n" + getResources().getString(R.string.correct_answer);
            q9wrong += " " + getResources().getString(R.string.paintingQ9A3);
            paintingQ9Verify.setText(q9wrong);
            paintingQ9Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 10 is correct or wrong.
     */
    public void displayQ10Check() {
        if (q10check.equals(getResources().getString(R.string.correct))){
            paintingQ10Verify.setText(q10check);
            paintingQ10Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q10check.equals(getResources().getString(R.string.wrong))) {
            String q10wrong = q10check;
            q10wrong += "\n" + getResources().getString(R.string.correct_answer);
            q10wrong += " " + getResources().getString(R.string.paintingQ10A);
            paintingQ10Verify.setText(q10wrong);
            paintingQ10Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }
}