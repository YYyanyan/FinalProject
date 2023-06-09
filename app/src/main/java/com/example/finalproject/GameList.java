package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameList extends ListActivity {

    private ArrayList<HashMap<String, String>> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initListView() {
        listItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "Rate： " + i); // 标题文字
            map.put("ItemDetail", "detail" + i); // 详情描述
            listItems.add(map);
        }
        MyAdapter myAdapter = new MyAdapter(this, R.layout.game_list, listItems);
        this.setListAdapter(myAdapter);
    }
}