package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class task2 extends AppCompatActivity {
    private Button buttonmove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        buttonmove = findViewById(R.id.button4);
        EditText username;
        username =(EditText)findViewById(R.id.email);
        EditText password;
        password =(EditText)findViewById(R.id.password);
        EditText password2;
        password2 =(EditText)findViewById(R.id.password2);

        buttonmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivityTwo();
            }
        });
    }

    private void moveToActivityTwo() {
        Intent intent = new Intent(task2.this, signup.class);
        startActivity(intent);
    }
}