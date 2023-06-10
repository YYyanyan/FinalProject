package com.example.finalproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<String> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void config(View btn){
        //打开创建窗口
        Intent configActivity = new Intent(this,CreateGame.class);
        startActivity(configActivity);

    }
    public void record(View btn){
        //接收比赛结果数据
        Intent list = getIntent();
        result = new ArrayList<>();
        result = list.getStringArrayListExtra("gameResult");
        Log.i(TAG, "GameList: result = " + result);

        //接收比赛统计数据
        Intent data = getIntent();
        Bundle bundle = data.getExtras();
        Log.i(TAG, "record: bundle(): " + bundle.getStringArrayList("1"));

        //打开比赛记录窗口并传输比赛数据
        Intent recordActivity = new Intent(this,GameList.class);
        recordActivity.putExtra("gameResult",result);
        recordActivity.putExtras(bundle);
        startActivity(recordActivity);
    }

}