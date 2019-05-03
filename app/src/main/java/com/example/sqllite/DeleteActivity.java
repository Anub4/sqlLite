package com.example.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class DeleteActivity extends AppCompatActivity {

    private Button btnDelete, btnUpdate;
    private ListView lv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        btnDelete = findViewById(R.id.btnDelete);
        lv2 = findViewById(R.id.lv2);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}
