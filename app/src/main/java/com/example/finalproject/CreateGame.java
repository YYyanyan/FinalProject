package com.example.finalproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CreateGame extends AppCompatActivity {
    EditText date;
    EditText time;
    EditText team1;
    EditText team2;
    EditText edit_sections;
    EditText edit_bonus;
    EditText edit_player_num;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);
        date = findViewById(R.id.game_date);
        time = findViewById(R.id.game_time);
        team1 = findViewById(R.id.TeamA_name);
        team2 = findViewById(R.id.TeamB_name);
        edit_sections = findViewById(R.id.sections);
        edit_bonus = findViewById(R.id.bonus);
        edit_player_num = findViewById(R.id.player_num);


    }    
       
//        String date = intent.getStringExtra("game_date");
//        String time = intent.getStringExtra("game_time");
//        String team1 = intent.getStringExtra("team1");
//        String team2 = intent.getStringExtra("team2");
//        Integer sections = intent.getIntExtra("sections",0);
//        Integer bonus = intent.getIntExtra("bonus",0);
//        Integer player_num = intent.getIntExtra("player_num",0);


    public void create(View save){
        Log.i(TAG, "creat ");
        String game_date = date.getText().toString();
        String game_time = time.getText().toString();
        String TeamA_name = team1.getText().toString();
        String TeamB_name = team2.getText().toString();
        String sections = edit_sections.getText().toString();
        String bonus = edit_bonus.getText().toString();
        String player_num = edit_player_num.getText().toString();

        //传输数据
        Intent GameCounterActivity = new Intent(this,GameCounter.class);
        GameCounterActivity.putExtra("game_date",game_date);
        GameCounterActivity.putExtra("game_time",game_time);
        GameCounterActivity.putExtra("TeamA_name",TeamA_name);
        GameCounterActivity.putExtra("TeamB_name",TeamB_name);
        GameCounterActivity.putExtra("sections",Integer.parseInt(sections));
        GameCounterActivity.putExtra("bonus",Integer.parseInt(bonus));
        GameCounterActivity.putExtra("player_num",Integer.parseInt(player_num));

        startActivity(GameCounterActivity);

    }
}