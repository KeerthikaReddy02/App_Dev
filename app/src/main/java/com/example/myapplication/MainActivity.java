package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Eemail,Epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Eemail=findViewById(R.id.email);
       Epassword=findViewById(R.id.password);
       Button button=findViewById(R.id.button4);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email=Eemail.getText().toString().trim();
               String password=Epassword.getText().toString().trim();
               Bundle bundle=new Bundle();
               bundle.putString("email",email);
               bundle.putString("password",password);
               Intent intent=new Intent(MainActivity.this,task2.class);
               intent.putExtras(bundle);
               startActivity(intent);
           }
       });
    }
}