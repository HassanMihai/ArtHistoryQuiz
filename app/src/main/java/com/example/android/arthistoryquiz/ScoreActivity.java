package com.example.android.arthistoryquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreActivity extends MainActivity{

    private int score;
    ImageView emoteIV;
    TextView congratsTV;
    TextView scoreTV;
    TextView checkAnswersTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        Intent mIntent = getIntent();
        score = mIntent.getIntExtra("SCORE", 0);

        emoteIV = findViewById(R.id.emote_image);
        congratsTV = findViewById(R.id.congratulation_text);
        scoreTV = findViewById(R.id.score_text);
        checkAnswersTV = findViewById(R.id.check_answers_text);

        if(score == 10) {
            emoteIV.setImageResource(R.drawable.great);
            congratsTV.setText(getString(R.string.amazing));
            congratsTV.setTextColor(getResources().getColor(R.color.correct));
            checkAnswersTV.setText(getString(R.string.congratulation));
            checkAnswersTV.setTextColor(getResources().getColor(R.color.correct));
        }

        if(score < 10 && score >= 6) {
            emoteIV.setImageResource(R.drawable.good);
            congratsTV.setText(getString(R.string.good));
            congratsTV.setTextColor(getResources().getColor(R.color.correct));
            checkAnswersTV.setText(getString(R.string.check_answers));
            checkAnswersTV.setTextColor(getResources().getColor(R.color.wrong));
        }

        if(score == 0 || score < 6) {
            emoteIV.setImageResource(R.drawable.notgood);
            congratsTV.setText(getString(R.string.bad));
            congratsTV.setTextColor(getResources().getColor(R.color.wrong));
            checkAnswersTV.setText(getString(R.string.check_answers));
            checkAnswersTV.setTextColor(getResources().getColor(R.color.wrong));
        }

        String yourScore = getString(R.string.you_answered, score);
        yourScore += getString(R.string.of_questions);
        scoreTV.setText(yourScore);
    }

    public void verifyAnswers(View view){
        if (score == 10) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            finish();
        }
    }
}
