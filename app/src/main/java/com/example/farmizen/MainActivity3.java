package com.example.farmizen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity3 extends AppCompatActivity {

    private TextView backtologin;
    private EditText username;
    private EditText email;
    private EditText crtpass;
    private EditText conpass;
    private MaterialButton signup;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        backtologin = findViewById(R.id.btlgn);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        crtpass = findViewById(R.id.crtpass);
        conpass = findViewById(R.id.conpass);
        signup = findViewById(R.id.signup);
        firebaseAuth = FirebaseAuth.getInstance();
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this, MainActivity2.class));
                finish();
            }
        });

        signup.setOnClickListener(view -> {
            if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(crtpass.getText().toString()) || TextUtils.isEmpty(conpass.getText().toString())) {
                Toast.makeText(MainActivity3.this, "The Field is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!crtpass.getText().toString().equals(conpass.getText().toString())) {
                Toast.makeText(MainActivity3.this, "Password not matched", Toast.LENGTH_SHORT).show();
                return;
            }
            firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), conpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                        Toast.makeText(MainActivity3.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity3.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}