package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity5 extends AppCompatActivity {
    String contact, college, branch, email;
    Button openmenu;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            contact = bundle.getString("contact1");
            college = bundle.getString("college1");
            branch = bundle.getString("branch1");
            email = bundle.getString("email1");
            EditText eContact = findViewById(R.id.contact);
            EditText eCollege = findViewById(R.id.college);
            EditText eBranch = findViewById(R.id.branch);
            EditText eEmail = findViewById(R.id.email);
            eContact.setText(contact);
            eCollege.setText(college);
            eBranch.setText(branch);
            eEmail.setText(email);
        }
        View openMenu = findViewById(R.id.button);
        openMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(MainActivity5.this,openMenu);
                popupMenu.getMenuInflater().inflate(R.menu.menu_val,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId())
                        {
                            case R.id.logout:
                            {

                                Intent intent1 = new Intent(MainActivity5.this, MainActivity.class);
                                startActivity(intent1);return true;}
                            default:return false;
                        }

                    }
                });
                popupMenu.show();
            }
        });
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ImageView img = (ImageView) findViewById(R.id.backarrow);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("contact", contact);
                bundle1.putString("college", college);
                bundle1.putString("branch", branch);
                bundle1.putString("email", email);
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
    }

    public void logout(final View view) {
        FirebaseAuth.getInstance().signOut();
        GoogleSignIn.getClient(this,new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build())
                .signOut().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                startActivity(new Intent(view.getContext(),MainActivity.class));

            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity5.this,"Signout Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

}