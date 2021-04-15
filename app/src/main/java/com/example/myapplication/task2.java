package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class task2 extends AppCompatActivity {
    private Button buttonmove;
    EditText pass1,pass2,password1;
    String password,p;
    int flag=1;
    int flag1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString("email");
             password = bundle.getString("password");
            EditText email1 = findViewById(R.id.email);
             password1 = findViewById(R.id.password);
             p = password1.getText().toString().trim();
            email1.setText(email);
            password1.setText(password);
        }
        pass1 = findViewById(R.id.password);
        pass2 = findViewById(R.id.password2);
        String p1 = pass1.getText().toString().trim();
        String p2 = pass2.getText().toString().trim();

        buttonmove = findViewById(R.id.button4);
        buttonmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (pass1.length() < 6 && pass1.length() > 0) {
                        LayoutInflater inflator = getLayoutInflater();
                        View layout = inflator.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.toast));
                        TextView toastText = layout.findViewById(R.id.message);
                        toastText.setText("Password too short min 6 characters");
                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();
                        flag = 0;
                    }
                     if (!pass1.getText().toString().trim().equals(pass2.getText().toString().trim())) {

                        LayoutInflater inflator = getLayoutInflater();
                        View layout = inflator.inflate(R.layout.custom_layout, (ViewGroup) findViewById(R.id.toast));
                        TextView toastText = layout.findViewById(R.id.message);
                        toastText.setText("Password not same retype!");
                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();
                        flag = 0;
                    }
                     else
                     {
                         flag=1;
                     }
                    if ((pass1.getText().toString().trim().equals(pass2.getText().toString().trim()))&& flag == 1) {
                        Intent intent = new Intent(task2.this, activity_signup.class);
                        startActivity(intent);
                    }


            }
        });
    }
}