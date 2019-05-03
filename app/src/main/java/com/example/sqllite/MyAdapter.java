package com.example.sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import helper.Word;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Word> listWords;

    public  MyAdapter(Context context, List<Word> listWords){
        this.context = context;
        this.listWords = listWords;
    }

    @Override
    public int getCount() {
        return listWords.size();
    }

    @Override
    public Object getItem(int position) {
        return listWords.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(android.R.layout.simple_list_item_1, null);
        TextView text = v.findViewById(android.R.id.text1);
        text.setText(listWords.get(position).getWord());
        return v;
    }
}
