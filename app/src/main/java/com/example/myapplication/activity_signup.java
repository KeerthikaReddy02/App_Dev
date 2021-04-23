package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_signup extends AppCompatActivity {
EditText contact,college,branch;
String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        contact=findViewById(R.id.contact);
        college=findViewById(R.id.college);
        branch=findViewById(R.id.branch);
        Bundle bundle = getIntent().getExtras();
         email = bundle.getString("email");
        Button button=findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sContact = contact.getText().toString().trim();
                String sCollege = college.getText().toString().trim();
                String sBranch = branch.getText().toString().trim();
                Bundle bundle = new Bundle();
                bundle.putString("contact", sContact);
                bundle.putString("college", sCollege);
                bundle.putString("branch", sBranch);
                bundle.putString("email",email);
                Intent intent=new Intent(activity_signup.this,MainActivity4.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}