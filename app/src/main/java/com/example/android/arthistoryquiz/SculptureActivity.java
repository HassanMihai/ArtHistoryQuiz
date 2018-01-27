package com.example.android.arthistoryquiz;

import android.content.Context;
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

/**
 * Created by Miai on 1/25/2018.
 */

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
            sculptureQ1Verify.setText(R.string.correct);
            sculptureQ1Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ1Verify.setText(R.string.wrong);
            sculptureQ1Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ2A1.isChecked()) {
            q2score = 1;
            sculptureQ2Verify.setText(R.string.correct);
            sculptureQ2Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ2Verify.setText(R.string.wrong);
            sculptureQ2Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        String sculptureQ3A1Text = sculptureQ3A1.getText().toString().toLowerCase();

        if (sculptureQ3A1Text.equals("rodin") || sculptureQ3A1Text.equals("auguste rodin") || sculptureQ3A1Text.equals("rodin auguste")) {
            q3score = 1;
            sculptureQ3Verify.setText(R.string.correct);
            sculptureQ3Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ3Verify.setText(R.string.wrong);
            sculptureQ3Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ4A1.isChecked()) {
            q4score = 1;
            sculptureQ4Verify.setText(R.string.correct);
            sculptureQ4Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ4Verify.setText(R.string.wrong);
            sculptureQ4Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ5A3.isChecked()) {
            q5score = 1;
            sculptureQ5Verify.setText(R.string.correct);
            sculptureQ5Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ5Verify.setText(R.string.wrong);
            sculptureQ5Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ6A2.isChecked()) {
            q6score = 1;
            sculptureQ6Verify.setText(R.string.correct);
            sculptureQ6Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ6Verify.setText(R.string.wrong);
            sculptureQ6Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        String sculptureQ7A1Text = sculptureQ7A1.getText().toString().toLowerCase();

        if (sculptureQ7A1Text.equals("benvenuto cellini") || sculptureQ7A1Text.equals("cellini") || sculptureQ7A1Text.equals("cellini benvenuto")) {
            q7score = 1;
            sculptureQ7Verify.setText(R.string.correct);
            sculptureQ7Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ7Verify.setText(R.string.wrong);
            sculptureQ7Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ8A3.isChecked()) {
            q8score = 1;
            sculptureQ8Verify.setText(R.string.correct);
            sculptureQ8Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ8Verify.setText(R.string.wrong);
            sculptureQ8Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ9A1.isChecked()) {
            q9score = 1;
            sculptureQ9Verify.setText(R.string.correct);
            sculptureQ9Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ9Verify.setText(R.string.wrong);
            sculptureQ9Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        if (sculptureQ10A3.isChecked()) {
            q10score = 1;
            sculptureQ10Verify.setText(R.string.correct);
            sculptureQ10Verify.setTextColor(getResources().getColor(R.color.correct));
        }
        else {
            sculptureQ10Verify.setText(R.string.wrong);
            sculptureQ10Verify.setTextColor(getResources().getColor(R.color.wrong));
        }

        int sculptureScore = calculateScore(q1score, q2score, q3score, q4score, q5score, q6score, q7score, q8score, q9score, q10score);

        saveScore(sculptureScore);

        Toast.makeText(this, getResources().getString(R.string.your_score) + " " + sculptureScore + " " + getResources().getString(R.string.from_score), Toast.LENGTH_SHORT).show();
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
                = PreferenceManager.getDefaultSharedPreferences(SculptureActivity.this);

        SharedPreferences.Editor myEditor = myPreferences.edit();

        myEditor.putInt("SCULPTURE", score);
        myEditor.commit();
    }
}
