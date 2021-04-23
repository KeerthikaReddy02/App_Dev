package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {
    String contact,college,branch,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            contact = bundle.getString("contact");
            college = bundle.getString("college");
            branch = bundle.getString("branch");
            email=bundle.getString("email");
        }
        ImageView img = (ImageView) findViewById(R.id.profile);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("contact1", contact);
                bundle.putString("college1", college);
                bundle.putString("branch1", branch);
                bundle.putString("email1",email);
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}