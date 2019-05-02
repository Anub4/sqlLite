package com.example.sqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import helper.MyHelper;
import helper.Word;

public class DisplayWordActivity extends AppCompatActivity {

    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);

        lv1 = findViewById(R.id.lv1);
        LoadWord();
    }

    private void LoadWord() {
        final MyHelper myHelper = new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Word> wordList= new ArrayList<>();
        wordList = myHelper.GetAllWOrds(sqLiteDatabase);

        HashMap<String , String> hashMap = new HashMap<>();

        for (int i =0; i < wordList.size(); i++){
            hashMap.put(wordList.get(i).getWord(),wordList.get(i).getMeaning());
        }

        ArrayAdapter <String> stringArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>(hashMap.keySet()));
        lv1.setAdapter(stringArrayAdapter);
    }

    public List<Word> GetWordByName(String word, SQLiteDatabase db){
        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from  tblWord where Word = ?", new String[]{word} );
        if(cursor.getCount() > 0)
        {
            while (cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
            }
        }
        return dictionaryList;
    }
}
