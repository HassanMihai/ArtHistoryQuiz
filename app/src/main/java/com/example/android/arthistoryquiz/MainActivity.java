package com.example.android.arthistoryquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView paintingScoreTV;
    TextView sculptureScoreTV;
    TextView architectureScoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences myPreferences
                = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        int pScore = myPreferences.getInt("PAINTING", 0);

        int sScore = myPreferences.getInt("SCULPTURE", 0);

        int aScore = myPreferences.getInt("ARCHITECTURE", 0);

        String paintingScore = pScore + "/10";
        String sculptureScore = sScore + "/10";
        String architectureScore = aScore + "/10";

        paintingScoreTV = findViewById(R.id.paintingScore);
        paintingScoreTV.setText(paintingScore);

        sculptureScoreTV = findViewById(R.id.sculptureScore);
        sculptureScoreTV.setText(sculptureScore);

        architectureScoreTV = findViewById(R.id.architectureScore);
        architectureScoreTV.setText(architectureScore);

    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
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
