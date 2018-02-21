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
import android.widget.Toast;

public class ArchitectureActivity extends MainActivity {

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

    private int q1score;
    private int q2score;
    private int q3score;
    private int q4score;
    private int q5score;
    private int q6score;
    private int q7score;
    private int q8score;
    private int q9score;
    private int q10score;
    private String q1check;
    private String q2check;
    private String q3check;
    private String q4check;
    private String q5check;
    private String q6check;
    private String q7check;
    private String q8check;
    private String q9check;
    private String q10check;

    RadioButton architectureQ1A2;
    EditText architectureQ2A1;
    RadioButton architectureQ3A1;
    EditText architectureQ4A1;
    RadioButton architectureQ5A1;
    CheckBox architectureQ6A1;
    CheckBox architectureQ6A2;
    CheckBox architectureQ6A3;
    RadioButton architectureQ7A1;
    RadioButton architectureQ8A2;
    RadioButton architectureQ9A1;
    RadioButton architectureQ10A2;
    TextView architectureQ1Verify;
    TextView architectureQ2Verify;
    TextView architectureQ3Verify;
    TextView architectureQ4Verify;
    TextView architectureQ5Verify;
    TextView architectureQ6Verify;
    TextView architectureQ7Verify;
    TextView architectureQ8Verify;
    TextView architectureQ9Verify;
    TextView architectureQ10Verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.architecture);
        architectureQ1A2 = findViewById(R.id.architectureQ1A2);
        architectureQ2A1 = findViewById(R.id.architectureQ2A1);
        architectureQ3A1 = findViewById(R.id.architectureQ3A1);
        architectureQ4A1 = findViewById(R.id.architectureQ4A1);
        architectureQ5A1 = findViewById(R.id.architectureQ5A1);
        architectureQ6A1 = findViewById(R.id.architectureQ6A1);
        architectureQ6A2 = findViewById(R.id.architectureQ6A2);
        architectureQ6A3 = findViewById(R.id.architectureQ6A3);
        architectureQ7A1 = findViewById(R.id.architectureQ7A1);
        architectureQ8A2 = findViewById(R.id.architectureQ8A2);
        architectureQ9A1 = findViewById(R.id.architectureQ9A1);
        architectureQ10A2 = findViewById(R.id.architectureQ10A2);
        architectureQ1Verify = findViewById(R.id.architectureQ1Verify);
        architectureQ2Verify = findViewById(R.id.architectureQ2Verify);
        architectureQ3Verify = findViewById(R.id.architectureQ3Verify);
        architectureQ4Verify = findViewById(R.id.architectureQ4Verify);
        architectureQ5Verify = findViewById(R.id.architectureQ5Verify);
        architectureQ6Verify = findViewById(R.id.architectureQ6Verify);
        architectureQ7Verify = findViewById(R.id.architectureQ7Verify);
        architectureQ8Verify = findViewById(R.id.architectureQ8Verify);
        architectureQ9Verify = findViewById(R.id.architectureQ9Verify);
        architectureQ10Verify = findViewById(R.id.architectureQ10Verify);
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
     * The source of this method is:
     * https://stackoverflow.com/questions/8697499/hide-keyboard-when-user-taps-anywhere-else-on-the-screen-in-android/37390091#37390091
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
        if (architectureQ1A2.isChecked()) {
            q1score = 1;
            q1check = getString(R.string.correct);
            displayQ1Check();
        }
        else {
            q1score = 0;
            q1check = getString(R.string.wrong);
            displayQ1Check();
        }

        String architectureQ2A1Text = architectureQ2A1.getText().toString().toLowerCase();

        if (architectureQ2A1Text.equals(getString(R.string.architectureQ2Afillipobrunelleschi).toLowerCase()) || architectureQ2A1Text.equals(getString(R.string.architectureQ2Abrunelleschi).toLowerCase()) || architectureQ2A1Text.equals(getString(R.string.architectureQ2Abrunelleschifillipo).toLowerCase())) {
            q2score = 1;
            q2check = getString(R.string.correct);
            displayQ2Check();
        }
        else {
            q2score = 0;
            q2check = getString(R.string.wrong);
            displayQ2Check();
        }

        if (architectureQ3A1.isChecked()) {
            q3score = 1;
            q3check = getString(R.string.correct);
            displayQ3Check();
        }
        else {
            q3score = 0;
            q3check = getString(R.string.wrong);
            displayQ3Check();
        }

        String architectureQ4A1Text = architectureQ4A1.getText().toString().toLowerCase();

        if (architectureQ4A1Text.equals(getString(R.string.architectureQ4A).toLowerCase())) {
            q4score = 1;
            q4check = getString(R.string.correct);
            displayQ4Check();
        }
        else {
            q4score = 0;
            q4check = getString(R.string.wrong);
            displayQ4Check();
        }

        if (architectureQ5A1.isChecked()) {
            q5score = 1;
            q5check = getString(R.string.correct);
            displayQ5Check();
        }
        else {
            q5score = 0;
            q5check = getString(R.string.wrong);
            displayQ5Check();
        }

        if (architectureQ6A1.isChecked() && architectureQ6A2.isChecked() && architectureQ6A3.isChecked()) {
            q6score = 1;
            q6check = getString(R.string.correct);
            displayQ6Check();
        }
        else {
            q6score = 0;
            q6check = getString(R.string.wrong);
            displayQ6Check();
        }

        if (architectureQ7A1.isChecked()) {
            q7score = 1;
            q7check = getString(R.string.correct);
            displayQ7Check();
        }
        else {
            q7score = 0;
            q7check = getString(R.string.wrong);
            displayQ7Check();
        }

        if (architectureQ8A2.isChecked()) {
            q8score = 1;
            q8check = getString(R.string.correct);
            displayQ8Check();
        }
        else {
            q8score = 0;
            q8check = getString(R.string.wrong);
            displayQ8Check();
        }

        if (architectureQ9A1.isChecked()) {
            q9score = 1;
            q9check = getString(R.string.correct);
            displayQ9Check();
        }
        else {
            q9score = 0;
            q9check = getString(R.string.wrong);
            displayQ9Check();
        }

        if (architectureQ10A2.isChecked()) {
            q10score = 1;
            q10check = getString(R.string.correct);
            displayQ10Check();
        }
        else {
            q10score = 0;
            q10check = getString(R.string.wrong);
            displayQ10Check();
        }

        int architectureScore = calculateScore(q1score, q2score, q3score, q4score, q5score, q6score, q7score, q8score, q9score, q10score);
        saveScore(architectureScore);
        viewScore(architectureScore);
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
                = PreferenceManager.getDefaultSharedPreferences(ArchitectureActivity.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        myEditor.putInt("ARCHITECTURE", score);
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
            architectureQ1Verify.setText(q1check);
            architectureQ1Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q1check.equals(getString(R.string.wrong))) {
            String q1wrong = q1check;
            q1wrong += "\n" + getString(R.string.correct_answer);
            q1wrong += " " + getString(R.string.architectureQ1A2);
            architectureQ1Verify.setText(q1wrong);
            architectureQ1Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 2 is correct or wrong.
     */
    public void displayQ2Check() {
        if (q2check.equals(getString(R.string.correct))){
            architectureQ2Verify.setText(q2check);
            architectureQ2Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q2check.equals(getString(R.string.wrong))) {
            String q2wrong = q2check;
            q2wrong += "\n" + getString(R.string.correct_answer);
            q2wrong += " " + getString(R.string.architectureQ2Afillipobrunelleschi);
            architectureQ2Verify.setText(q2wrong);
            architectureQ2Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 3 is correct or wrong.
     */
    public void displayQ3Check() {
        if (q3check.equals(getString(R.string.correct))){
            architectureQ3Verify.setText(q3check);
            architectureQ3Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q3check.equals(getString(R.string.wrong))) {
            String q3wrong = q3check;
            q3wrong += "\n" + getString(R.string.correct_answer);
            q3wrong += " " + getString(R.string.architectureQ3A1);
            architectureQ3Verify.setText(q3wrong);
            architectureQ3Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 4 is correct or wrong.
     */
    public void displayQ4Check() {
        if (q4check.equals(getString(R.string.correct))){
            architectureQ4Verify.setText(q4check);
            architectureQ4Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q4check.equals(getString(R.string.wrong))) {
            String q4wrong = q4check;
            q4wrong += "\n" + getString(R.string.correct_answer);
            q4wrong += " " + getString(R.string.architectureQ4A);
            architectureQ4Verify.setText(q4wrong);
            architectureQ4Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 5 is correct or wrong.
     */
    public void displayQ5Check() {
        if (q5check.equals(getString(R.string.correct))){
            architectureQ5Verify.setText(q5check);
            architectureQ5Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q5check.equals(getString(R.string.wrong))) {
            String q5wrong = q5check;
            q5wrong += "\n" + getString(R.string.correct_answer);
            q5wrong += " " + getString(R.string.architectureQ5A1);
            architectureQ5Verify.setText(q5wrong);
            architectureQ5Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 6 is correct or wrong.
     */
    public void displayQ6Check() {
        if (q6check.equals(getString(R.string.correct))){
            architectureQ6Verify.setText(q5check);
            architectureQ6Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q6check.equals(getString(R.string.wrong))) {
            String q6wrong = q6check;
            q6wrong += "\n" + getString(R.string.correct_answer);
            q6wrong += " " + getString(R.string.architectureQ6A1);
            q6wrong += " " + getString(R.string.architectureQ6A2);
            q6wrong += " " + getString(R.string.architectureQ6A3);
            architectureQ6Verify.setText(q6wrong);
            architectureQ6Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 7 is correct or wrong.
     */
    public void displayQ7Check() {
        if (q7check.equals(getString(R.string.correct))){
            architectureQ7Verify.setText(q7check);
            architectureQ7Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q7check.equals(getString(R.string.wrong))) {
            String q7wrong = q7check;
            q7wrong += "\n" + getString(R.string.correct_answer);
            q7wrong += " " + getString(R.string.architectureQ7A1);
            architectureQ7Verify.setText(q7wrong);
            architectureQ7Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 8 is correct or wrong.
     */
    public void displayQ8Check() {
        if (q8check.equals(getString(R.string.correct))){
            architectureQ8Verify.setText(q8check);
            architectureQ8Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q8check.equals(getString(R.string.wrong))) {
            String q8wrong = q8check;
            q8wrong += "\n" + getString(R.string.correct_answer);
            q8wrong += " " + getString(R.string.architectureQ8A2);
            architectureQ8Verify.setText(q8wrong);
            architectureQ8Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 9 is correct or wrong.
     */
    public void displayQ9Check() {
        if (q9check.equals(getString(R.string.correct))){
            architectureQ9Verify.setText(q9check);
            architectureQ9Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q9check.equals(getString(R.string.wrong))) {
            String q9wrong = q9check;
            q9wrong += "\n" + getString(R.string.correct_answer);
            q9wrong += " " + getString(R.string.architectureQ9A1);
            architectureQ9Verify.setText(q9wrong);
            architectureQ9Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }

    /**
     * This method sets and display text if answer for question 10 is correct or wrong.
     */
    public void displayQ10Check() {
        if (q10check.equals(getString(R.string.correct))){
            architectureQ10Verify.setText(q10check);
            architectureQ10Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else if (q10check.equals(getString(R.string.wrong))) {
            String q10wrong = q10check;
            q10wrong += "\n" + getString(R.string.correct_answer);
            q10wrong += " " + getString(R.string.architectureQ10A2);
            architectureQ10Verify.setText(q10wrong);
            architectureQ10Verify.setTextColor(getResources().getColor(R.color.wrong));
        }
    }
}
