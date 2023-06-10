package com.example.finalproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class GameData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_data);
        Intent data = getIntent();
        //接收比赛统计数据
        Bundle bundle = data.getExtras();
        TextView Team1 = findViewById(R.id.Team1);
        Team1.setText(data.getStringExtra("team1"));
        TextView Team2 = findViewById(R.id.Team2);
        Team2.setText(data.getStringExtra("team2"));

        Log.i(TAG, "record: bundle(): " + bundle.getStringArrayList("5"));
        try {
            TextView t1r1 = findViewById(R.id.t1r1);
            String score = bundle.getStringArrayList("1").get(1);
            Log.i(TAG, "onCreate: score = " + score);
            t1r1.setText(score);

            TextView t2r1 = findViewById(R.id.t2r1);
            score = bundle.getStringArrayList("1").get(2);
            t2r1.setText(score);

            TextView t1r2 = findViewById(R.id.t1r2);
            score = bundle.getStringArrayList("2").get(1);
            t1r2.setText(score);

            TextView t2r2 = findViewById(R.id.t2r2);
            score = bundle.getStringArrayList("2").get(2);
            t2r2.setText(score);

            TextView t1r3 = findViewById(R.id.t1r3);
            score = bundle.getStringArrayList("3").get(1);
            t1r3.setText(score);

            TextView t2r3 = findViewById(R.id.t2r3);
            score = bundle.getStringArrayList("3").get(2);
            t2r3.setText(score);

            TextView t1r4 = findViewById(R.id.t1r4);
            score = bundle.getStringArrayList("4").get(1);
            t1r4.setText(score);

            TextView t2r4 = findViewById(R.id.t2r4);
            score = bundle.getStringArrayList("4").get(2);
            t2r4.setText(score);

            TextView t1score = findViewById(R.id.t1score);
            score = bundle.getStringArrayList("5").get(1);
            t1score.setText(score);

            TextView t2score = findViewById(R.id.t2score);
            score = bundle.getStringArrayList("5").get(2);
            t2score.setText(score);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}