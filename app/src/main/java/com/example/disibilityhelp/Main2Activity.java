package com.example.disibilityhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button divBy2,divBy3,divBy8,divBy9,divBy10,divBy11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        divBy2 = findViewById(R.id.divBy2);
        divBy3 = findViewById(R.id.divBy3);
        divBy8 = findViewById(R.id.divBy8);
        divBy9 = findViewById(R.id.divBy9);
        divBy10 = findViewById(R.id.divBy10);
        divBy11 = findViewById(R.id.divBy11);

        divBy2.setOnClickListener(this);
        divBy3.setOnClickListener(this);
        divBy8.setOnClickListener(this);
        divBy9.setOnClickListener(this);
        divBy10.setOnClickListener(this);
        divBy11.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        Intent intent;

        switch(id) {
            case R.id.divBy2:
                intent = new Intent(Main2Activity.this, com.example.disibilityhelp.Main3Activity.class);
                intent.putExtra("operation", "by2");
                startActivity(intent);
                break;
            case R.id.divBy3:
                intent = new Intent(Main2Activity.this, com.example.disibilityhelp.Main3Activity.class);
                intent.putExtra("operation", "by3");
                startActivity(intent);
                break;
            case R.id.divBy8:
                intent = new Intent(Main2Activity.this, com.example.disibilityhelp.Main3Activity.class);
                intent.putExtra("operation", "by8");
                startActivity(intent);
                break;
            case R.id.divBy9:
                intent = new Intent(Main2Activity.this, com.example.disibilityhelp.Main3Activity.class);
                intent.putExtra("operation", "by9");
                startActivity(intent);
                break;
            case R.id.divBy10:
                intent = new Intent(Main2Activity.this, com.example.disibilityhelp.Main3Activity.class);
                intent.putExtra("operation", "by10");
                startActivity(intent);
                break;
            case R.id.divBy11:
                intent = new Intent(Main2Activity.this, com.example.disibilityhelp.Main3Activity.class);
                intent.putExtra("operation", "by11");
                startActivity(intent);
                break;
        }

    }
}
