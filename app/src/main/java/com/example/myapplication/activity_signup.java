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
private FirebaseAuth mAuth;
private DatabaseReference mDatabase;
private FirebaseDatabase database;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        contact=findViewById(R.id.contact);
        college=findViewById(R.id.college);
        branch=findViewById(R.id.branch);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference("User");
         button=findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Bundle bundle = getIntent().getExtras();
                String email = bundle.getString("email").trim();
                String password = bundle.getString("password").trim();
                String sContact = contact.getText().toString().trim();
                String sCollege = college.getText().toString().trim();
                String sBranch = branch.getText().toString().trim();
                register(email, password, sBranch,sCollege,sContact);
            }
        });
    }
    private void register(String email1, String password1, String branch1,String college1,String contact1) {
        mAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser currentUser = mAuth.getCurrentUser();
                    DatabaseReference dat = mDatabase.child(currentUser.getUid());
                    dat.child("Email").setValue(email1);
                    dat.child("Branch").setValue(branch1);
                    dat.child("College").setValue(college1);
                    dat.child("Contact").setValue(contact1);
                    Toast.makeText(getApplicationContext(), "Registration Success.", Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("contact", contact1);
                    bundle.putString("college", college1);
                    bundle.putString("branch", branch1);
                    bundle.putString("email",email1);
                    Intent intent = new Intent(activity_signup.this, MainActivity4.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Registration failed, please try again! ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    }