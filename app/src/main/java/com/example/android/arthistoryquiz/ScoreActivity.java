package com.example.android.arthistoryquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Miai on 1/27/2018.
 */

public class ScoreActivity extends PaintingActivity{

    TextView scoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("SCORE", 0);

        scoreTV = findViewById(R.id.score_text);
        scoreTV.setText(String.valueOf(score));
    }
}
