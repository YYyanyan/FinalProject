package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameCounter extends AppCompatActivity {
    String game_date;
    String game_time;
    String TeamA_name;
    String TeamB_name;
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
    TextView cur_section;

    public List<ArrayList> data;
    public Integer cur_section_num;
    public Integer scoreA_num;
    public Integer scoreB_num;
    public Integer foul_num_A;
    public Integer foul_num_B;
    private static final String TAG = "GameCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_counter);

        // 接收创建界面数据
        team1 = findViewById(R.id.TeamA_name);
        team2 = findViewById(R.id.TeamB_name);
        Intent intent = getIntent();
        game_date = intent.getStringExtra("game_date");
        game_time = intent.getStringExtra("game_time");
        TeamA_name = intent.getStringExtra("TeamA_name");
        team1.setText(TeamA_name);
        TeamB_name = intent.getStringExtra("TeamB_name");
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
        cur_section = findViewById(R.id.cur_section);
        cur_section_num = Integer.parseInt(cur_section.getText().toString());
        scoreA_num = Integer.parseInt(scoreA.getText().toString());
        scoreB_num = Integer.parseInt(scoreB.getText().toString());
        foul_num_A = Integer.parseInt(foulA.getText().toString());
        foul_num_B = Integer.parseInt(foulB.getText().toString());

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
    public void save_sec_Data(View reset){
        //保存本节数据
        ArrayList<String> sec_result = null;
        if( cur_section_num ==1){
            sec_result.add(cur_section_num.toString());
            sec_result.add(scoreA_num.toString());
            sec_result.add(scoreB_num.toString());
            data.add(sec_result);
        } else if (cur_section_num<edit_sections) {
            Integer cur_scoreA = scoreA_num-Integer.parseInt(data.get(-1).get(1).toString());
            Integer cur_scoreB = scoreB_num-Integer.parseInt(data.get(-1).get(2).toString());
            sec_result.add(cur_section_num.toString());
            sec_result.add(cur_scoreA.toString());
            sec_result.add(cur_scoreB.toString());
            data.add(sec_result);
        }
        Log.i(TAG, "save_sec_Data: " + sec_result.toString());

        //更改节数
        if(cur_section_num<edit_sections) {
            cur_section_num += 1;
            cur_section.setText(cur_section_num.toString());
        }else{
            Toast.makeText(this, "已经是最后一节，请点击结束比赛", Toast.LENGTH_LONG).show();
            return;
        }
        Log.i(TAG, "save_sec_Data: cur_section : " + cur_section.toString());

    }

    public void saveData(View view){
        //保存最后一节及总分数据
        Log.i(TAG, "saveData: scoreA = " + scoreA_num.toString());
        Log.i(TAG, "saveData: scoreB = " + scoreB_num.toString());
        if(cur_section_num==edit_sections) {
            ArrayList<String>  sec_result = new ArrayList<>();
            ArrayList<String> final_result = new ArrayList<>();
            Integer cur_scoreA = scoreA_num-Integer.parseInt(data.get(-1).get(1).toString());
            Integer cur_scoreB = scoreB_num-Integer.parseInt(data.get(-1).get(2).toString());
            sec_result.add(cur_section_num.toString());
            sec_result.add(cur_scoreA.toString());
            sec_result.add(cur_scoreB.toString());
            data.add(sec_result);
            final_result.add("f");
            final_result.add(scoreA_num.toString());
            final_result.add(scoreB_num.toString());
            data.add(final_result);

            //传输数据到GameData
            Intent GameDataActivity = new Intent(this,GameList.class);
            Bundle bundle = new Bundle();
            Integer i =1;
            for (ArrayList<String> dataitem : data) {
                bundle.putStringArrayList(i.toString(), dataitem);
                i+=1;
            }
            GameDataActivity.putExtras(bundle);
//            setResult(1,GameDataActivity);

            //传输数据到GameList
            Intent GameListActivity = new Intent(this,GameList.class);
            ArrayList<String> game= new ArrayList<String>();
            game.add(game_date);
            game.add(game_time);
            game.add(TeamA_name);
            game.add(TeamB_name);
            game.add(scoreA_num.toString());
            game.add(scoreB_num.toString());
            GameListActivity.putExtra("gameResult",game);
//            setResult(2,GameListActivity);

        }else{
            Toast.makeText(this, "比赛还未结束", Toast.LENGTH_LONG).show();
            return;
        }

    }


    }



