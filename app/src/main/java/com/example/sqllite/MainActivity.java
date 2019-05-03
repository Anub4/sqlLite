package com.example.sqllite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity {
    private EditText etWord, etMeaning;
    private Button btnAddWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMeaning = findViewById(R.id.etMeaning);
        etWord = findViewById(R.id.etWord);
        btnAddWord= findViewById(R.id.btnAddWord);

        final MyHelper myHelper =new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase =myHelper.getWritableDatabase();

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = myHelper.InsertData(etWord.getText().toString(), etMeaning.getText().toString(),sqLiteDatabase);
                if (id > 0 ){
                    Toast.makeText(MainActivity.this, "Success" + id , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    public void deleteRowActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, DeleteActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}
