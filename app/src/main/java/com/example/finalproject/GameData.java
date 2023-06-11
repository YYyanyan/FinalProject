package com.example.finalproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class GameData extends AppCompatActivity {
    TextView t1r1;
    TextView t2r1;
    TextView t1r2;
    TextView t2r2;
    TextView t1r3;
    TextView t2r3;
    TextView t1r4;
    TextView t2r4;
    TextView t1score;
    TextView t2score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_data);
        Intent data = getIntent();
        //接收比赛统计数据
        Bundle bundle = data.getExtras();
        Log.i(TAG, "onCreate: bundle :" + bundle.getStringArrayList("1").get(1));
        TextView Team1 = findViewById(R.id.Team1);
        Team1.setText(data.getStringExtra("team1"));
        TextView Team2 = findViewById(R.id.Team2);
        Team2.setText(data.getStringExtra("team2"));
        Integer section = Integer.parseInt(bundle.getString("section"));
        ArrayList<TextView> sectionList = new ArrayList<>();
        ArrayList<HashMap<TextView,TextView>> sectionListMap = new ArrayList<>();
        t1r1 = findViewById(R.id.t1r1);
        t2r1 = findViewById(R.id.t2r1);
        t1r2 = findViewById(R.id.t1r2);
        t2r2 = findViewById(R.id.t2r2);
        t1r3 = findViewById(R.id.t1r3);
        t2r3 = findViewById(R.id.t2r3);
        t1r4 = findViewById(R.id.t1r4);
        t2r4 = findViewById(R.id.t2r4);
        t1score = findViewById(R.id.t1score);
        t2score = findViewById(R.id.t2score);
        sectionList.add(t1r1);
        sectionList.add(t2r1);
        sectionList.add(t1r2);
        sectionList.add(t2r2);
        sectionList.add(t1r3);
        sectionList.add(t2r3);
        sectionList.add(t1r4);
        sectionList.add(t2r4);
//        sectionList.add(t1score);
//        sectionList.add(t2score);
        Log.i(TAG, "onCreate: sectionList :" + sectionList);
        for(int i=0 ;i<=6;i+=2) {
            HashMap<TextView, TextView> map = new HashMap<>();
            map.put(sectionList.get(i), sectionList.get(i));
            map.put(sectionList.get(i+1), sectionList.get(i+1));
            sectionListMap.add(map);
        }
        Log.i(TAG, "onCreate: sectionListMap :" + sectionListMap);
        Log.i(TAG, "onCreate: 第一支队伍第一节:"+sectionListMap.get(0).get(sectionList.get(0)));

        //单节分数
        for(int i =0;i<section;i++){
            String key = String.valueOf(i+1);
            Log.i(TAG, "onCreate: "+bundle.getStringArrayList(key).get(1));
            String score1 = bundle.getStringArrayList(key).get(1);
            String score2 = bundle.getStringArrayList(key).get(2);
            Log.i(TAG, "onCreate: score1 : 节数：" + (i + 1) + "分数：" + score1);
            Log.i(TAG, "onCreate: score1 : 节数：" + (i + 1) + "分数：" + score2);
            sectionListMap.get(i).get(sectionList.get(2*i)).setText(score1);
            sectionListMap.get(i).get(sectionList.get(2*i + 1)).setText(score2);

        }
        //全场分数
        String key = String.valueOf(section+1);
        String score1 = bundle.getStringArrayList(key).get(1);
        String score2 = bundle.getStringArrayList(key).get(2);
        t1score.setText(score1);
        t2score.setText(score2);

        //统计数据
        TextView team1Stat = findViewById(R.id.stat_Team1);
        TextView team2Stat = findViewById(R.id.stat_Team2);
        team1Stat.setText(data.getStringExtra("team1"));
        team2Stat.setText(data.getStringExtra("team2"));

        ArrayList<Integer> stat = data.getIntegerArrayListExtra("gameStat");
        Log.i(TAG, "record: stat : "+ stat);
        TextView team1_three = findViewById(R.id.Team1_three);
        team1_three.setText(stat.get(0).toString());
        TextView team2_three = findViewById(R.id.Team2_three);
        team2_three.setText(stat.get(1).toString());
        TextView team1_two = findViewById(R.id.Team1_two);
        team1_two.setText(stat.get(2).toString());
        TextView team2_two = findViewById(R.id.Team2_two);
        team2_two.setText(stat.get(3).toString());
        TextView team1_one = findViewById(R.id.Team1_one);
        team1_one.setText(stat.get(4).toString());
        TextView team2_one = findViewById(R.id.Team2_one);
        team2_one.setText(stat.get(5).toString());
        TextView team1_foul = findViewById(R.id.Team1_foul);
        team1_foul.setText(stat.get(6).toString());
        TextView team2_foul = findViewById(R.id.Team2_foul);
        team2_foul.setText(stat.get(7).toString());




    }
}