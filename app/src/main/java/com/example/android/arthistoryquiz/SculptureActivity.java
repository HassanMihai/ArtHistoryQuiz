package com.example.android.arthistoryquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class SculptureActivity extends MainActivity {

    RadioButton sculptureQ1A3;
    RadioButton sculptureQ2A1;
    EditText sculptureQ3A1;
    RadioButton sculptureQ4A1;
    RadioButton sculptureQ5A3;
    RadioButton sculptureQ6A2;
    EditText sculptureQ7A1;
    RadioButton sculptureQ8A3;
    RadioButton sculptureQ9A1;
    RadioButton sculptureQ10A3;

    TextView sculptureQ1Verify;
    TextView sculptureQ2Verify;
    TextView sculptureQ3Verify;
    TextView sculptureQ4Verify;
    TextView sculptureQ5Verify;
    TextView sculptureQ6Verify;
    TextView sculptureQ7Verify;
    TextView sculptureQ8Verify;
    TextView sculptureQ9Verify;
    TextView sculptureQ10Verify;

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
        setContentView(R.layout.sculpture);

        sculptureQ1A3 = findViewById(R.id.sculptureQ1A3);
        sculptureQ2A1 = findViewById(R.id.sculptureQ2A1);
        sculptureQ3A1 = findViewById(R.id.sculptureQ3A1);
        sculptureQ4A1 = findViewById(R.id.sculptureQ4A1);
        sculptureQ5A3 = findViewById(R.id.sculptureQ5A3);
        sculptureQ6A2 = findViewById(R.id.sculptureQ6A2);
        sculptureQ7A1 = findViewById(R.id.sculptureQ7A1);
        sculptureQ8A3 = findViewById(R.id.sculptureQ8A3);
        sculptureQ9A1 = findViewById(R.id.sculptureQ9A1);
        sculptureQ10A3 = findViewById(R.id.sculptureQ10A3);
        
        sculptureQ1Verify = findViewById(R.id.sculptureQ1Verify);
        sculptureQ2Verify = findViewById(R.id.sculptureQ2Verify);
        sculptureQ3Verify = findViewById(R.id.sculptureQ3Verify);
        sculptureQ4Verify = findViewById(R.id.sculptureQ4Verify);
        sculptureQ5Verify = findViewById(R.id.sculptureQ5Verify);
        sculptureQ6Verify = findViewById(R.id.sculptureQ6Verify);
        sculptureQ7Verify = findViewById(R.id.sculptureQ7Verify);
        sculptureQ8Verify = findViewById(R.id.sculptureQ8Verify);
        sculptureQ9Verify = findViewById(R.id.sculptureQ9Verify);
        sculptureQ10Verify = findViewById(R.id.sculptureQ10Verify);
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
     * This method checks the answers and setText if answers are correct or wrong.
     */
    public void submitAnswers(View view) {
        if (sculptureQ1A3.isChecked()) {
            q1score = 1;
            q1check = getString(R.string.correct);
            displayQ1Check();
        }
        else {
            q1score = 0;
            q1check = getString(R.string.wrong);
            displayQ1Check();
        }

        if (sculptureQ2A1.isChecked()) {
            q2score = 1;
            q2check = getString(R.string.correct);
            displayQ2Check();
        }
        else {
            q2score = 0;
            q2check = getString(R.string.wrong);
            displayQ2Check();
        }

        String sculptureQ3A1Text = sculptureQ3A1.getText().toString().toLowerCase();

        if (sculptureQ3A1Text.equals(getString(R.string.sculptureQ3Aaugusterodin).toLowerCase()) || sculptureQ3A1Text.equals(getString(R.string.sculptureQ3Arodinauguste).toLowerCase()) || sculptureQ3A1Text.equals(getString(R.string.sculptureQ3Arodin).toLowerCase())) {
            q3score = 1;
            q3check = getString(R.string.correct);
            displayQ3Check();
        }
        else {
            q3score = 0;
            q3check = getString(R.string.wrong);
            displayQ3Check();
        }

        if (sculptureQ4A1.isChecked()) {
            q4score = 1;
            q4check = getString(R.string.correct);
            displayQ4Check();
        }
        else {
            q4score = 0;
            q4check = getString(R.string.wrong);
            displayQ4Check();
        }

        if (sculptureQ5A3.isChecked()) {
            q5score = 1;
            q5check = getString(R.string.correct);
            displayQ5Check();
        }
        else {
            q5score = 0;
            q5check = getString(R.string.wrong);
            displayQ5Check();
        }

        if (sculptureQ6A2.isChecked()) {
            q6score = 1;
            q6check = getString(R.string.correct);
            displayQ6Check();
        }
        else {
            q6score = 0;
            q6check = getString(R.string.wrong);
            displayQ6Check();
        }

        String sculptureQ7A1Text = sculptureQ7A1.getText().toString().toLowerCase();

        if (sculptureQ7A1Text.equals(getString(R.string.sculptureQ7Abenvenutocellini).toLowerCase()) || sculptureQ7A1Text.equals(getString(R.string.sculptureQ7Acellini).toLowerCase()) || sculptureQ7A1Text.equals(getString(R.string.sculptureQ7Acellinibenvenuto).toLowerCase())) {
            q7score = 1;
            q7check = getString(R.string.correct);
            displayQ7Check();
        }
        else {
            q7score = 0;
            q7check = getString(R.string.wrong);
            displayQ7Check();
        }

        if (sculptureQ8A3.isChecked()) {
            q8score = 1;
            q8check = getString(R.string.correct);
            displayQ8Check();
        }
        else {
            q8score = 0;
            q8check = getString(R.string.wrong);
            displayQ8Check();
        }

        if (sculptureQ9A1.isChecked()) {
            q9score = 1;
            q9check = getString(R.string.correct);
            displayQ9Check();
        }
        else {
            q9score = 0;
            q9check = getString(R.string.wrong);
            displayQ9Check();
        }

        if (sculptureQ10A3.isChecked()) {
            q10score = 1;
            q10check = getString(R.string.correct);
            displayQ10Check();
        }
        else {
            q10score = 0;
            q10check = getString(R.string.wrong);
            displayQ10Check();
        }

        int sculptureScore = calculateScore(q1score, q2score, q3score, q4score, q5score, q6score, q7score, q8score, q9score, q10score);

        saveScore(sculptureScore);
        viewScore(sculptureScore);
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
     * This method save the last score on SharedPreferences.
     */
    public void saveScore(int score) {
        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(SculptureActivity.this);

        SharedPreferences.Editor myEditor = myPreferences.edit();

        myEditor.putInt("SCULPTURE", score);
        myEditor.commit();
    }

    /**
     * This method show the score in ScoreActivity.
     */
    public void viewScore(int score) {
        String yourScore = getString(R.string.you_answered, score);
        yourScore += getString(R.string.of_questions);

        Toast.makeText(this, yourScore, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }

    /**
     * This method sets and display text if answer for question 1 is correct or wrong.
     */
    public void displayQ1Check() {
        if (q1check.equals(getString(R.string.correct))){
            sculptureQ1Verify.setText(q1check);
            sculptureQ1Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q1check.equals(getString(R.string.wrong))) {
            String q1wrong = q1check;
            q1wrong += "\n" + getString(R.string.correct_answer);
            q1wrong += " " + getString(R.string.sculptureQ1A3);
            sculptureQ1Verify.setText(q1wrong);
            sculptureQ1Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 2 is correct or wrong.
     */
    public void displayQ2Check() {
        if (q2check.equals(getString(R.string.correct))){
            sculptureQ2Verify.setText(q2check);
            sculptureQ2Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q2check.equals(getString(R.string.wrong))) {
            String q2wrong = q2check;
            q2wrong += "\n" + getString(R.string.correct_answer);
            q2wrong += " " + getString(R.string.sculptureQ2A1);
            sculptureQ2Verify.setText(q2wrong);
            sculptureQ2Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 3 is correct or wrong.
     */
    public void displayQ3Check() {
        if (q3check.equals(getString(R.string.correct))){
            sculptureQ3Verify.setText(q3check);
            sculptureQ3Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q3check.equals(getString(R.string.wrong))) {
            String q3wrong = q3check;
            q3wrong += "\n" + getString(R.string.correct_answer);
            q3wrong += " " + getString(R.string.sculptureQ3Aaugusterodin);
            sculptureQ3Verify.setText(q3wrong);
            sculptureQ3Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 4 is correct or wrong.
     */
    public void displayQ4Check() {
        if (q4check.equals(getString(R.string.correct))){
            sculptureQ4Verify.setText(q4check);
            sculptureQ4Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q4check.equals(getString(R.string.wrong))) {
            String q4wrong = q4check;
            q4wrong += "\n" + getString(R.string.correct_answer);
            q4wrong += " " + getString(R.string.sculptureQ4A1);
            sculptureQ4Verify.setText(q4wrong);
            sculptureQ4Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 5 is correct or wrong.
     */
    public void displayQ5Check() {
        if (q5check.equals(getString(R.string.correct))){
            sculptureQ5Verify.setText(q5check);
            sculptureQ5Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q5check.equals(getString(R.string.wrong))){
            String q5wrong = q5check;
            q5wrong += "\n" + getString(R.string.correct_answer);
            q5wrong += " " + getString(R.string.sculptureQ5A3);
            sculptureQ5Verify.setText(q5wrong);
            sculptureQ5Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 6 is correct or wrong.
     */
    public void displayQ6Check() {
        if (q6check.equals(getString(R.string.correct))){
            sculptureQ6Verify.setText(q5check);
            sculptureQ6Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q6check.equals(getString(R.string.wrong))) {
            String q6wrong = q6check;
            q6wrong += "\n" + getString(R.string.correct_answer);
            q6wrong += " " + getString(R.string.sculptureQ6A2);
            sculptureQ6Verify.setText(q6wrong);
            sculptureQ6Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 7 is correct or wrong.
     */
    public void displayQ7Check() {
        if (q7check.equals(getString(R.string.correct))){
            sculptureQ7Verify.setText(q7check);
            sculptureQ7Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q7check.equals(getString(R.string.wrong))) {
            String q7wrong = q7check;
            q7wrong += "\n" + getString(R.string.correct_answer);
            q7wrong += " " + getString(R.string.sculptureQ7Abenvenutocellini);
            sculptureQ7Verify.setText(q7wrong);
            sculptureQ7Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 8 is correct or wrong.
     */
    public void displayQ8Check() {
        if (q8check.equals(getString(R.string.correct))){
            sculptureQ8Verify.setText(q8check);
            sculptureQ8Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q8check.equals(getString(R.string.wrong))) {
            String q8wrong = q8check;
            q8wrong += "\n" + getString(R.string.correct_answer);
            q8wrong += " " + getString(R.string.sculptureQ8A3);
            sculptureQ8Verify.setText(q8wrong);
            sculptureQ8Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 9 is correct or wrong.
     */
    public void displayQ9Check() {
        if (q9check.equals(getString(R.string.correct))){
            sculptureQ9Verify.setText(q9check);
            sculptureQ9Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q9check.equals(getString(R.string.wrong))) {
            String q9wrong = q9check;
            q9wrong += "\n" + getString(R.string.correct_answer);
            q9wrong += " " + getString(R.string.sculptureQ9A1);
            sculptureQ9Verify.setText(q9wrong);
            sculptureQ9Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 1 is correct or wrong.
     */
    public void displayQ10Check() {
        if (q10check.equals(getString(R.string.correct))){
            sculptureQ10Verify.setText(q10check);
            sculptureQ10Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q10check.equals(getString(R.string.wrong))) {
            String q10wrong = q10check;
            q10wrong += "\n" + getString(R.string.correct_answer);
            q10wrong += " " + getString(R.string.sculptureQ10A3);
            sculptureQ10Verify.setText(q10wrong);
            sculptureQ10Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }
}
