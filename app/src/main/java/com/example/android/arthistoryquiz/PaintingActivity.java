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

        if (paintingQ1A1.isChecked()) {
            q1score = 1;
            paintingQ1Verify.setText(R.string.correct);
            paintingQ1Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q1score = 0;
            paintingQ1Verify.setText(R.string.wrong);
            paintingQ1Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ2A1.isChecked()) {
            q2score = 1;
            paintingQ2Verify.setText(R.string.correct);
            paintingQ2Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q2score = 0;
            paintingQ2Verify.setText(R.string.wrong);
            paintingQ2Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ3A3.isChecked()) {
            q3score = 1;
            paintingQ3Verify.setText(R.string.correct);
            paintingQ3Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q3score = 0;
            paintingQ3Verify.setText(R.string.wrong);
            paintingQ3Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ4A3.isChecked()) {
            q4score = 1;
            paintingQ4Verify.setText(R.string.correct);
            paintingQ4Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q4score = 0;
            paintingQ4Verify.setText(R.string.wrong);
            paintingQ4Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ5A3.isChecked()) {
            q5score = 1;
            paintingQ5Verify.setText(R.string.correct);
            paintingQ5Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q5score = 0;
            paintingQ5Verify.setText(R.string.wrong);
            paintingQ5Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ6A1.isChecked() && paintingQ6A2.isChecked() && !paintingQ6A3.isChecked()) {
            q6score = 1;
            paintingQ6Verify.setText(R.string.correct);
            paintingQ6Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q6score = 0;
            paintingQ6Verify.setText(R.string.wrong);
            paintingQ6Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ7A1.isChecked()) {
            q7score = 1;
            paintingQ7Verify.setText(R.string.correct);
            paintingQ7Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q7score = 0;
            paintingQ7Verify.setText(R.string.wrong);
            paintingQ7Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ8A1.isChecked()) {
            q8score = 1;
            paintingQ8Verify.setText(R.string.correct);
            paintingQ8Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q8score = 0;
            paintingQ8Verify.setText(R.string.wrong);
            paintingQ8Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (paintingQ9A3.isChecked()) {
            q9score = 1;
            paintingQ9Verify.setText(R.string.correct);
            paintingQ9Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q9score = 0;
            paintingQ9Verify.setText(R.string.wrong);
            paintingQ9Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        String paintingQ10A1Text = paintingQ10A1.getText().toString();

        if (paintingQ10A1Text.equals("1")) {
            q10score = 1;
            paintingQ10Verify.setText(R.string.correct);
            paintingQ10Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            q10score = 0;
            paintingQ10Verify.setText(R.string.wrong);
            paintingQ10Verify.setTextColor(getResources().getColor(R.color.wrong));
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
}