package com.example.sqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import helper.Word;

public class DisplayWordActivity extends AppCompatActivity {

    private ListView lv1;
    private Button btn1;
    private EditText et1;
    List<Word> wordList;
    final MyHelper myHelper = new MyHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);

        lv1 = findViewById(R.id.lv1);
        et1 = findViewById(R.id.et1);
        btn1 = findViewById(R.id.btn1);

        wordList = myHelper.GetAllWOrds();
        final MyAdapter adapter = new MyAdapter(this, wordList);

        lv1.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordList.clear();
                wordList.addAll(myHelper.GetWordByName(et1.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });
    }
}
