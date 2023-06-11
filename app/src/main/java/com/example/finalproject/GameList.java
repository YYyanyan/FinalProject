package com.example.finalproject;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class GameList extends ListActivity implements AdapterView.OnItemClickListener{

    public ArrayList<ArrayList<String>> listItems;
    public ArrayList<String> result;
    private static final String TAG = "GameList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //接收比赛结果数据
        Intent data = getIntent();
        result = new ArrayList<>();
        result = data.getStringArrayListExtra("gameResult");


        //生成列表
        initListView();
        //执行单击任务
        getListView().setOnItemClickListener(GameList.this);
    }


    private void initListView() {
        listItems = new ArrayList<>();
        listItems.add(result);
        MyAdapter myAdapter = new MyAdapter(this, R.layout.game_list, listItems);
        this.setListAdapter(myAdapter);
        Log.i(TAG, "initListView: success " );
    }
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i(TAG, "onItemClick: 单击执行");
        //接收比赛统计数据
        Intent data = getIntent();
        Bundle bundle = data.getExtras();
        ArrayList<Integer> stat = data.getIntegerArrayListExtra("gameStat");
        Log.i(TAG, "record: stat : "+ stat);
        Log.i(TAG, "record: bundle(): " + bundle.getStringArrayList("1"));
        Log.i(TAG, "onItemClick: section:" + bundle.getString("section"));

        //打开新窗口
        Intent dataActivity = new Intent(this,GameData.class);
        ArrayList<String> result = (ArrayList<String>) getListView().getItemAtPosition(i);
        Log.i(TAG, "onItemClick: result:" +result);
        dataActivity.putExtra("team1",result.get(2));
        dataActivity.putExtra("team2",result.get(3));
        dataActivity.putExtra("gameStat",stat);
        dataActivity.putExtras(bundle);
        startActivity(dataActivity);
//        startActivity(calActivity);

    }


}