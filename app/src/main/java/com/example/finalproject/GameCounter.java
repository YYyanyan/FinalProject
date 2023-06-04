package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class GameCounter extends AppCompatActivity {
    String game_date;
    String game_time;
    TextView team1;
    TextView team2;
    Integer edit_sections;
    Integer edit_bonus;
    Integer edit_player_num;
    private static final String TAG = "GameCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_counter);
        team1 = findViewById(R.id.TeamA_name);
        team2 = findViewById(R.id.TeamB_name);
        Intent intent = getIntent();
        game_date = intent.getStringExtra("game_date");
        game_time = intent.getStringExtra("game_time");

        String TeamA_name = intent.getStringExtra("TeamA_name");
        team1.setText(TeamA_name);
        String TeamB_name = intent.getStringExtra("TeamB_name");
        team2.setText(TeamB_name);

        edit_sections = intent.getIntExtra("sections",0);
        edit_bonus = intent.getIntExtra("bonus",0);
        edit_player_num = intent.getIntExtra("player_num",0);

        Log.i(TAG, "onActivityResult: game_date =" + game_date);
        Log.i(TAG, "onActivityResult: game_time =" + game_time);
        Log.i(TAG, "onActivityResult: TeamA_name =" + TeamA_name);
        Log.i(TAG, "onActivityResult: TeamB_name =" + TeamB_name);
        Log.i(TAG, "onActivityResult: edit_sections =" + edit_sections);
        Log.i(TAG, "onActivityResult: edit_bonus =" + edit_bonus);
        Log.i(TAG, "onActivityResult: edit_player_num =" + edit_player_num);
    }


}