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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Eemail,Epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Eemail = findViewById(R.id.email);
        Epassword = findViewById(R.id.password);
        Button button = findViewById(R.id.button4);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(Epassword.length()<6&&Epassword.length()>0)
               {
                   LayoutInflater inflator=getLayoutInflater();
                   View layout=inflator.inflate(R.layout.custom_layout,(ViewGroup)findViewById(R.id.toast));
                   TextView toastText=layout.findViewById(R.id.message);
                   toastText.setText("Password too short min 6 characters");
                   Toast toast =new Toast(getApplicationContext());
                   toast.setGravity(Gravity.BOTTOM,0,0);
                   toast.setDuration(Toast.LENGTH_LONG);
                   toast.setView(layout);
                   toast.show();
               }
               else
               {
                   String email = Eemail.getText().toString().trim();
                   String password = Epassword.getText().toString().trim();
                   Bundle bundle = new Bundle();
                   bundle.putString("email", email);
                   bundle.putString("password", password);
                   Intent intent = new Intent(MainActivity.this, task2.class);
                   intent.putExtras(bundle);
                   startActivity(intent);
               }
           }
       });

    }
}