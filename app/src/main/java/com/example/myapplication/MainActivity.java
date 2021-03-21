package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button buttonmove;
    Button btn;
    EditText et1;
    EditText et2;
    String st1;
    String st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonmove=findViewById(R.id.button4);
        btn=findViewById(R.id.button4);
        et1=findViewById(R.id.email);
        et1=findViewById(R.id.password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,task2.class);
                st1=et1.getText().toString();
                st2=et2.getText().toString();
                i.putExtra("email",st1);
                i.putExtra("password",st2);
                startActivity(i);
                finish();

            }
        });
        buttonmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivityTwo();
            }
        });

    }
    private void moveToActivityTwo(){
        Intent intent=new Intent(MainActivity.this,task2.class );
        startActivity(intent);
    }
}