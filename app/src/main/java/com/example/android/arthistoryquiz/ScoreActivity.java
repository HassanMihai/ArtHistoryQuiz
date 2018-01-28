package com.example.android.arthistoryquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Miai on 1/27/2018.
 */

public class ScoreActivity extends PaintingActivity{

    ImageView emoteIV;
    TextView congratTV;
    TextView scoreTV;
    TextView checkAnswersTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("SCORE", 0);

        emoteIV = findViewById(R.id.emote_image);
        congratTV = findViewById(R.id.congratulation_text);
        scoreTV = findViewById(R.id.score_text);
        checkAnswersTV = findViewById(R.id.check_answers_text);

        if(score == 10) {
            emoteIV.setImageResource(R.drawable.great);
            congratTV.setText(getResources().getString(R.string.amazing));
            congratTV.setTextColor(getResources().getColor(R.color.correct));
            checkAnswersTV.setText(getResources().getString(R.string.congratulation));
            checkAnswersTV.setTextColor(getResources().getColor(R.color.correct));
        }

        if(score < 10 && score >= 6) {
            emoteIV.setImageResource(R.drawable.good);
            congratTV.setText(getResources().getString(R.string.good));
            congratTV.setTextColor(getResources().getColor(R.color.correct));
            checkAnswersTV.setText(getResources().getString(R.string.check_answers));
            checkAnswersTV.setTextColor(getResources().getColor(R.color.wrong));
        }

        if(score == 0 || score < 6) {
            emoteIV.setImageResource(R.drawable.notgood);
            congratTV.setText(getResources().getString(R.string.bad));
            congratTV.setTextColor(getResources().getColor(R.color.wrong));
            checkAnswersTV.setText(getResources().getString(R.string.check_answers));
            checkAnswersTV.setTextColor(getResources().getColor(R.color.wrong));
        }

        String yourScore = getResources().getString(R.string.you_answered);
        yourScore += " " + String.valueOf(score);
        yourScore += " " + getResources().getString(R.string.of_questions);

        scoreTV.setText(yourScore);
    }
}
