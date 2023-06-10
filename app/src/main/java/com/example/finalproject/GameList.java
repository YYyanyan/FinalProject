package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameList extends ListActivity {

    public ArrayList<ArrayList<String>> listItems;
    public ArrayList<String> result;
    private static final String TAG = "GameList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //接收比赛结果数据
        Intent data = new Intent();
        result = data.getStringArrayListExtra("gameResult");
        Log.i(TAG, "onActivityResult: result = " + result.toString());
        initListView();
    }


    private void initListView() {
        listItems = new ArrayList<>();
        listItems.add(result);
        MyAdapter myAdapter = new MyAdapter(this, R.layout.game_list, listItems);
        this.setListAdapter(myAdapter);
    }
}