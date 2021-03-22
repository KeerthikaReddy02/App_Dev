package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class task2 extends AppCompatActivity {
    private Button buttonmove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString("email");
            String password = bundle.getString("password");
            TextView email1 = findViewById(R.id.email);
            TextView password1 = findViewById(R.id.password);
            email1.setText(email);
            password1.setText(password);
        }
        buttonmove = findViewById(R.id.button4);
        buttonmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(task2.this, activity_signup.class);
                startActivity(intent);
            }
        });
    }
}