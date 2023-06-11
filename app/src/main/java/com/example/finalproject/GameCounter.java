package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameCounter extends AppCompatActivity {
    String game_date;
    String game_time;
    String TeamA_name;
    String TeamB_name;
    TextView team1;
    TextView team2;
    TextView date;
    TextView time;
    TextView type;
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

    public ArrayList<ArrayList<String>> data;
    public Integer cur_section_num;
    public Integer scoreA_num;
    public Integer scoreB_num;
    public Integer foul_num_A;
    public Integer foul_num_B;

    public Integer ThreePoint_A=0;
    public Integer ThreePoint_B=0;
    public Integer TwoPoint_A=0;
    public Integer TwoPoint_B=0;
    public Integer OnePoint_A=0;
    public Integer OnePoint_B=0;
    public Integer TotalFoul_A=0;
    public Integer TotalFoul_B=0;

    private static final String TAG = "GameCounter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_counter);

        // 接收创建界面数据
        team1 = findViewById(R.id.TeamA_name);
        team2 = findViewById(R.id.TeamB_name);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        type = findViewById(R.id.type);

        Intent intent = getIntent();
        game_date = intent.getStringExtra("game_date");
        game_time = intent.getStringExtra("game_time");
        edit_sections = intent.getIntExtra("sections",0);
        edit_bonus = intent.getIntExtra("bonus",0);
        edit_player_num = intent.getIntExtra("player_num",0);
        TeamA_name = intent.getStringExtra("TeamA_name");
        TeamB_name = intent.getStringExtra("TeamB_name");
        team1.setText(TeamA_name);
        team2.setText(TeamB_name);
        date.setText(game_date);
        time.setText(game_time);
        type.setText(edit_player_num.toString() + "v" + edit_player_num.toString() );


        Log.i(TAG, "onActivityResult: game_date =" + game_date);
        Log.i(TAG, "onActivityResult: game_time =" + game_time);
        Log.i(TAG, "onActivityResult: TeamA_name =" + TeamA_name);
        Log.i(TAG, "onActivityResult: TeamB_name =" + TeamB_name);
        Log.i(TAG, "onActivityResult: edit_sections =" + edit_sections);
        Log.i(TAG, "onActivityResult: edit_bonus =" + edit_bonus);
        Log.i(TAG, "onActivityResult: edit_player_num =" + edit_player_num);

        data = new ArrayList<>();
    }
    public void click(View btn){
        //实现记录比分功能及单项数据统计功能

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
            ThreePoint_A +=1;
        }else if(btn.getId() == R.id.twoA ){
            scoreA_num += 2;
            scoreA.setText(String.valueOf(scoreA_num));
            TwoPoint_A +=1;
        }else if(btn.getId() == R.id.oneA ){
            scoreA_num += 1;
            scoreA.setText(String.valueOf(scoreA_num));
            OnePoint_A+=1;
        }else if(btn.getId() == R.id.threeB ){
            scoreB_num += 3;
            scoreB.setText(String.valueOf(scoreB_num));
            ThreePoint_B+=1;
        }else if(btn.getId() == R.id.twoB ){
            scoreB_num += 2;
            scoreB.setText(String.valueOf(scoreB_num));
            TwoPoint_B+=1;
        }else if(btn.getId() == R.id.oneB ){
            scoreB_num += 1;
            scoreB.setText(String.valueOf(scoreB_num));
            OnePoint_B+=1;
        } else if(btn.getId() == R.id.foulA ){
            foul_num_A += 1;
            foulA.setText(String.valueOf(foul_num_A));
            TotalFoul_A+=1;
        } else if(btn.getId() == R.id.foulB ){
            foul_num_B += 1;
            foulB.setText(String.valueOf(foul_num_B));
            TotalFoul_B+=1;
        }

        if (foul_num_A>=edit_bonus){
            A_full_foul.setText("已犯满");
        }
        if (foul_num_B>=edit_bonus){
            B_full_foul.setText("已犯满");
        }


    }
    public void save_sec_Data(View view){
        //保存本节数据
        ArrayList<String> sec_result = new ArrayList<>();
        Log.i(TAG, "save_sec_Data: cur_section_num=" + cur_section_num.toString());
        Log.i(TAG, "save_sec_Data: scoreA_num=" + scoreA_num.toString());
        Log.i(TAG, "save_sec_Data: scoreB_num=" + scoreB_num.toString());
        Log.i(TAG, "save_sec_Data: data :" +data);
        if( cur_section_num == 1) {
            sec_result.add(cur_section_num.toString());
            sec_result.add(scoreA_num.toString());
            sec_result.add(scoreB_num.toString());
            Log.i(TAG, "save_sec_Data: " + sec_result);
            data.add(sec_result);
        } else if (cur_section_num<edit_sections) {
            Log.i(TAG, "save_sec_Data: 上一节A分数 ：" +data.get(cur_section_num-2).get(1));
            Log.i(TAG, "save_sec_Data: 上一节B分数 ：" +data.get(cur_section_num-2).get(2));
            Integer cur_scoreA= scoreA_num;
            Integer cur_scoreB = scoreB_num;
            for(int i =0;i<cur_section_num-1;i++){
                cur_scoreA = cur_scoreA-Integer.parseInt(data.get(i).get(1));
                cur_scoreB = cur_scoreB-Integer.parseInt(data.get(i).get(2));
            }
            sec_result.add(cur_section_num.toString());
            sec_result.add(cur_scoreA.toString());
            sec_result.add(cur_scoreB.toString());
            Log.i(TAG, "save_sec_Data: " + sec_result);
            data.add(sec_result);

        }
        Log.i(TAG, "save_sec_Data: data :" + data);
        //更改节数
        if(cur_section_num<edit_sections) {
            cur_section_num += 1;
            cur_section.setText(cur_section_num.toString());
        }else{
            Toast.makeText(this, "已经是最后一节，请点击结束比赛", Toast.LENGTH_LONG).show();
            return;
        }
        Log.i(TAG, "save_sec_Data: cur_section : " + cur_section_num.toString());

        //清零犯规数
        foul_num_A =0;
        foulA.setText(String.valueOf(foul_num_A));
        foul_num_B = 0;
        foulB.setText(String.valueOf(foul_num_B));
        A_full_foul.setText("");
        B_full_foul.setText("");


    }

    public void saveData(View view){
        //保存最后一节及总分数据
        Log.i(TAG, "saveData: scoreA = " + scoreA_num.toString());
        Log.i(TAG, "saveData: scoreB = " + scoreB_num.toString());
        if(cur_section_num==edit_sections) {
            ArrayList<String>  sec_result = new ArrayList<>();
            ArrayList<String> final_result = new ArrayList<>();
            Integer cur_scoreA= scoreA_num;
            Integer cur_scoreB = scoreB_num;
            for(int i =0;i<cur_section_num-1;i++){
                cur_scoreA = cur_scoreA-Integer.parseInt(data.get(i).get(1));
                cur_scoreB = cur_scoreB-Integer.parseInt(data.get(i).get(2));
            }
            sec_result.add(cur_section_num.toString());
            sec_result.add(cur_scoreA.toString());
            sec_result.add(cur_scoreB.toString());
            Log.i(TAG, "save_sec_Data: " + sec_result);
            data.add(sec_result);
            Log.i(TAG, "save_sec_Data: data :" + data);

            final_result.add("f");
            final_result.add(scoreA_num.toString());
            final_result.add(scoreB_num.toString());
            data.add(final_result);
            Log.i(TAG, "save_sec_Data: data :" + data);


            //比赛列表数据
            Intent GameListActivity = new Intent(this,MainActivity.class);
            ArrayList<String> game= new ArrayList<>();
            game.add(game_date);
            game.add(game_time);
            game.add(TeamA_name);
            game.add(TeamB_name);
            game.add(scoreA_num.toString());
            game.add(scoreB_num.toString());
            game.add(edit_player_num.toString());
            Log.i(TAG, "saveData: game :" + game);


            //比分数据
            Bundle bundle = new Bundle();
            bundle.putString("section",edit_sections.toString());
            Integer i =1;
            for (ArrayList<String> dataitem : data) {
                Log.i(TAG, "saveData: dataitem :" + dataitem );
                bundle.putStringArrayList(i.toString(), dataitem);
                i+=1;
            }
            //统计数据
            ArrayList<Integer> stat = new ArrayList<>();
            stat.add(ThreePoint_A);
            stat.add(ThreePoint_B);
            stat.add(TwoPoint_A);
            stat.add(TwoPoint_B);
            stat.add(OnePoint_A);
            stat.add(OnePoint_B);
            stat.add(TotalFoul_A);
            stat.add(TotalFoul_B);
            Log.i(TAG, "saveData: stat:" + stat);

            //传输
            GameListActivity.putExtras(bundle);
            GameListActivity.putExtra("gameStat",stat);
            GameListActivity.putExtra("gameResult",game);
            startActivity(GameListActivity);
//            setResult(2,GameListActivity);

        }else{
            Toast.makeText(this, "比赛还未结束", Toast.LENGTH_LONG).show();
            return;
        }

    }


    }



