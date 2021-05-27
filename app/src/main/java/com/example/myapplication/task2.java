package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;

public class task2 extends AppCompatActivity {
    SignInButton btSignIn;
    GoogleSignInClient googleSignInClient;
    private Button buttonmove;
    private FirebaseAuth mAuth;
    FirebaseAuth firebaseAuth;
    EditText pass1,pass2,password1;
    EditText email;
    String password,p,email1,p1;
    int flag=1;
    int flag1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        mAuth = FirebaseAuth.getInstance();
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
        email=findViewById(R.id.email);

        pass1 = findViewById(R.id.password);
        pass2 = findViewById(R.id.password2);
         p1 = pass1.getText().toString().trim();
        String p2 = pass2.getText().toString().trim();

        buttonmove = findViewById(R.id.button4);
        buttonmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1=email.getText().toString().trim();
                String p1 = pass2.getText().toString().trim();
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
                } else {
                    flag = 1;
                }
                if ((pass1.getText().toString().trim().equals(pass2.getText().toString().trim())) && flag == 1) {
                    register(email1, p1);
                    Bundle bundle1 = new Bundle();
                    Intent intent = new Intent(task2.this, activity_signup.class);
                    bundle1.putString("email", email1);
                    bundle1.putString("password", p1);
                    intent.putExtras(bundle1);
                    startActivity(intent);
                }


            }
        });
    }



    private void register(String email, String pass) {
        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Registration Success.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(task2.this, activity_signup.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Registration failed, please try again! ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}