package com.example.android.arthistoryquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int pScore;
    private int sScore;
    private int aScore;
    private String paintingScore;
    private String sculptureScore;
    private String architectureScore;

    TextView paintingScoreTV;
    TextView sculptureScoreTV;
    TextView architectureScoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        pScore = myPreferences.getInt("PAINTING", 0);
        sScore = myPreferences.getInt("SCULPTURE", 0);
        aScore = myPreferences.getInt("ARCHITECTURE", 0);
        paintingScore = getString(R.string.of_10, pScore);
        sculptureScore = getString(R.string.of_10, sScore);
        architectureScore = getString(R.string.of_10, aScore);

        paintingScoreTV = findViewById(R.id.paintingScore);
        paintingScoreTV.setText(paintingScore);

        sculptureScoreTV = findViewById(R.id.sculptureScore);
        sculptureScoreTV.setText(sculptureScore);

        architectureScoreTV = findViewById(R.id.architectureScore);
        architectureScoreTV.setText(architectureScore);
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        pScore = myPreferences.getInt("PAINTING", 0);
        sScore = myPreferences.getInt("SCULPTURE", 0);
        aScore = myPreferences.getInt("ARCHITECTURE", 0);
        paintingScore = getString(R.string.of_10, pScore);
        sculptureScore = getString(R.string.of_10, sScore);
        architectureScore = getString(R.string.of_10, aScore);

        paintingScoreTV.setText(paintingScore);
        sculptureScoreTV.setText(sculptureScore);
        architectureScoreTV.setText(architectureScore);
    }

    public void paintingQuiz(View view) {
        Intent intent = new Intent(this, PaintingActivity.class);
        startActivity(intent);
    }

    public void sculptureQuiz(View view) {
        Intent intent = new Intent(this, SculptureActivity.class);
        startActivity(intent);
    }

    public void architectureQuiz(View view) {
        Intent intent = new Intent(this, ArchitectureActivity.class);
        startActivity(intent);
    }
}
