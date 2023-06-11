package com.example.finalproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

    }




    public void create(View save){
        Log.i(TAG, "creat ");


            date = findViewById(R.id.game_date);
            time = findViewById(R.id.game_time);
            team1 = findViewById(R.id.TeamA_name);
            team2 = findViewById(R.id.TeamB_name);
            edit_sections = findViewById(R.id.sections);
            edit_bonus = findViewById(R.id.bonus);
            edit_player_num = findViewById(R.id.player_num);

            if(date.getText().toString().trim().equals("")|
                    time.getText().toString().trim().equals("")|
                    team1.getText().toString().trim().equals("")|
                    team2.getText().toString().trim().equals("")|
                    edit_sections.getText().toString().trim().equals("")|
                    edit_bonus.getText().toString().trim().equals("")|
                    edit_player_num.getText().toString().trim().equals(""))
            {
                Toast.makeText(this, "请输入完整内容", Toast.LENGTH_SHORT).show();
            }else if (Integer.parseInt(edit_sections.getText().toString())>4){
                Toast.makeText(this, "节数应小于等于4", Toast.LENGTH_SHORT).show();
            }else {
                try {


                    String game_date = date.getText().toString();
                    String game_time = time.getText().toString();
                    String TeamA_name = team1.getText().toString();
                    String TeamB_name = team2.getText().toString();
                    String sections = edit_sections.getText().toString();
                    String bonus = edit_bonus.getText().toString();
                    String player_num = edit_player_num.getText().toString();

                    //传输数据
                    Intent GameCounterActivity = new Intent(this, GameCounter.class);
                    GameCounterActivity.putExtra("game_date", game_date);
                    GameCounterActivity.putExtra("game_time", game_time);
                    GameCounterActivity.putExtra("TeamA_name", TeamA_name);
                    GameCounterActivity.putExtra("TeamB_name", TeamB_name);
                    GameCounterActivity.putExtra("sections", Integer.parseInt(sections));
                    GameCounterActivity.putExtra("bonus", Integer.parseInt(bonus));
                    GameCounterActivity.putExtra("player_num", Integer.parseInt(player_num));

                    startActivity(GameCounterActivity);
                }catch (NumberFormatException e){
                    Toast.makeText(this, "节数应小于等于4", Toast.LENGTH_SHORT).show();
                }
            }




    }
}