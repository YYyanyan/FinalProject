package com.example.finalproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAdapter extends ArrayAdapter {

    private static final String TAG = "MyAdapter";

    public MyAdapter(Context context, int resource, ArrayList<ArrayList<String>> list) {
        super(context, resource, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArrayList<String> result = (ArrayList<String>) getItem(position);
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.game_list,parent,false);
        }
        TextView gameDate = itemView.findViewById(R.id.Date);
        TextView gameTime = itemView.findViewById(R.id.Time);
        TextView Team1 = itemView.findViewById(R.id.Team1);
        TextView Team2 = itemView.findViewById(R.id.Team2);
        TextView score1 = itemView.findViewById(R.id.Score1);
        TextView score2 = itemView.findViewById(R.id.Score2);

        gameDate.setText(result.get(0));
        gameTime.setText(result.get(1));
        Team1.setText(result.get(2));
        Team2.setText(result.get(3));
        score1.setText(result.get(4));
        score2.setText(result.get(5));

        Log.i(TAG, "getView: gameDate" + gameDate.getText());
        Log.i(TAG, "getView: gameTime" + gameTime.getText());
        Log.i(TAG, "getView: Team1" + Team1.getText());
        Log.i(TAG, "getView: Team2" + Team2.getText());
        Log.i(TAG, "getView: score1" + score1.getText());
        Log.i(TAG, "getView: score2" + score2.getText());



        return itemView;
    }
}