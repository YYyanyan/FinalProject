package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    TextView scoreA;
    TextView scoreB;
    TextView foulA;
    TextView foulB;
    TextView A_full_foul;
    TextView B_full_foul;
    private static final String TAG = "GameCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_counter);

        // 接收数据
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
    public void click(View btn){
        //实现计数功能
        scoreA = findViewById(R.id.scoreA);
        scoreB = findViewById(R.id.scoreB);
        foulA = findViewById(R.id.foul_num_A);
        foulB = findViewById(R.id.foul_num_B);
        A_full_foul = findViewById(R.id.A_full_foul);
        B_full_foul = findViewById(R.id.B_full_foul);
        Integer scoreA_num = Integer.parseInt(scoreA.getText().toString());
        Integer scoreB_num = Integer.parseInt(scoreB.getText().toString());
        Integer foul_num_A = Integer.parseInt(foulA.getText().toString());
        Integer foul_num_B = Integer.parseInt(foulB.getText().toString());

        if(btn.getId() == R.id.threeA ){
            scoreA_num += 3;
            scoreA.setText(String.valueOf(scoreA_num));
        }else if(btn.getId() == R.id.twoA ){
            scoreA_num += 2;
            scoreA.setText(String.valueOf(scoreA_num));
        }else if(btn.getId() == R.id.oneA ){
            scoreA_num += 1;
            scoreA.setText(String.valueOf(scoreA_num));
        }else if(btn.getId() == R.id.threeB ){
            scoreB_num += 3;
            scoreB.setText(String.valueOf(scoreB_num));
        }else if(btn.getId() == R.id.twoB ){
            scoreB_num += 2;
            scoreB.setText(String.valueOf(scoreB_num));
        }else if(btn.getId() == R.id.oneB ){
            scoreB_num += 3;
            scoreB.setText(String.valueOf(scoreB_num));
        } else if(btn.getId() == R.id.foulA ){
            foul_num_A += 1;
            foulA.setText(String.valueOf(foul_num_A));
        } else if(btn.getId() == R.id.foulB ){
            foul_num_B += 1;
            foulB.setText(String.valueOf(foul_num_B));
        }

        if (foul_num_A>=edit_bonus){
            A_full_foul.setText("已犯满");
        }
        if (foul_num_B>=edit_bonus){
            B_full_foul.setText("已犯满");
        }


    }
    public void reset(View reset){
        scoreA.setText("0");
        scoreB.setText("0");
        Log.i(TAG, "reset: " + "0");

    }



}