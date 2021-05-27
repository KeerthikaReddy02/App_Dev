package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class activity_signup extends AppCompatActivity {
EditText contact,college,branch;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        contact=findViewById(R.id.contact);
        college=findViewById(R.id.college);
        branch=findViewById(R.id.branch);
         button=findViewById(R.id.button4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle bundle = getIntent().getExtras();
                String email = bundle.getString("email").trim();
                String sContact = contact.getText().toString().trim();
                String sCollege = college.getText().toString().trim();
                String sBranch = branch.getText().toString().trim();
                Bundle bundle1 = new Bundle();
                bundle1.putString("contact", sContact);
                bundle1.putString("college", sCollege);
                bundle1.putString("branch", sBranch);
                bundle1.putString("email",email);
                Intent intent = new Intent(activity_signup.this, MainActivity4.class);
                intent.putExtras(bundle1);
                startActivity(intent);
                finish();
            }
        });
    }

}