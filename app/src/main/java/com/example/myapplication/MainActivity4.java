package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity4 extends AppCompatActivity {
    String contact,college,branch,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        BottomNavigationView bottomNav=findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
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


    private BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment=null;
            switch (item.getItemId())
            {
                case R.id.home:
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.open_book:
                    selectedFragment=new OpenBookFragment();
                    break;
                case R.id.plus:
                    selectedFragment=new PlusFragment();
                    break;
                case R.id.renew:
                    selectedFragment=new renewFragment();
                    break;
                case R.id.user:
                    selectedFragment=new UserFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frag, selectedFragment).commit();
            return true;
        }
    };
}