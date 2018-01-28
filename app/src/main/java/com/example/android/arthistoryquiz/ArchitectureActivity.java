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


public class ArchitectureActivity extends MainActivity {

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
        if (architectureQ1A2.isChecked()) {
            q1score = 1;
            architectureQ1Verify.setText(R.string.correct);
            architectureQ1Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q1score = 0;
            architectureQ1Verify.setText(R.string.wrong);
            architectureQ1Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        String architectureQ2A1Text = architectureQ2A1.getText().toString().toLowerCase();

        if (architectureQ2A1Text.equals("filippo brunelleschi") || architectureQ2A1Text.equals("brunelleschi") || architectureQ2A1Text.equals("brunelleschi filippo")) {
            q2score = 1;
            architectureQ2Verify.setText(R.string.correct);
            architectureQ2Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q2score = 0;
            architectureQ2Verify.setText(R.string.wrong);
            architectureQ2Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ3A1.isChecked()) {
            q3score = 1;
            architectureQ3Verify.setText(R.string.correct);
            architectureQ3Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q3score = 0;
            architectureQ3Verify.setText(R.string.wrong);
            architectureQ3Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        String architectureQ4A1Text = architectureQ4A1.getText().toString().toLowerCase();

        if (architectureQ4A1Text.equals("germany") || architectureQ4A1Text.equals("germania")) {
            q4score = 1;
            architectureQ4Verify.setText(R.string.correct);
            architectureQ4Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q4score = 0;
            architectureQ4Verify.setText(R.string.wrong);
            architectureQ4Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ5A1.isChecked()) {
            q5score = 1;
            architectureQ5Verify.setText(R.string.correct);
            architectureQ5Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q5score = 0;
            architectureQ5Verify.setText(R.string.wrong);
            architectureQ5Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ6A1.isChecked() && architectureQ6A2.isChecked() && architectureQ6A3.isChecked()) {
            q6score = 1;
            architectureQ6Verify.setText(R.string.correct);
            architectureQ6Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q6score = 0;
            architectureQ6Verify.setText(R.string.wrong);
            architectureQ6Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ7A1.isChecked()) {
            q7score = 1;
            architectureQ7Verify.setText(R.string.correct);
            architectureQ7Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q7score = 0;
            architectureQ7Verify.setText(R.string.wrong);
            architectureQ7Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ8A2.isChecked()) {
            q8score = 1;
            architectureQ8Verify.setText(R.string.correct);
            architectureQ8Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q8score = 0;
            architectureQ8Verify.setText(R.string.wrong);
            architectureQ8Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ9A1.isChecked()) {
            q9score = 1;
            architectureQ9Verify.setText(R.string.correct);
            architectureQ9Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q9score = 0;
            architectureQ9Verify.setText(R.string.wrong);
            architectureQ9Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (architectureQ10A2.isChecked()) {
            q10score = 1;
            architectureQ10Verify.setText(R.string.correct);
            architectureQ10Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q10score = 0;
            architectureQ10Verify.setText(R.string.wrong);
            architectureQ10Verify.setTextColor(getResources().getColor(R.color.wrong));
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
     * This method save the score on SharedPreferences.
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
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("SCORE", score);
        startActivity(intent);
    }
}
