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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    private TextView signup;
    private TextView login;
    private EditText email;
    private EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        signup.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity3.class));
            finish();
        });
        login.setOnClickListener(view -> {
            String email = this.email.getText().toString();
            String password = pass.getText().toString();
            if (email == null || password == null) {
                Toast.makeText(this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity2.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity2.this, MainActivity4.class));
                        finish();
                    } else {
                        Toast.makeText(MainActivity2.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }
}