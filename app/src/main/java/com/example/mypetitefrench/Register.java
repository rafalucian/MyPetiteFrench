package com.example.mypetitefrench;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.login.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Register extends AppCompatActivity {

    EditText username;
    EditText password;
    Button register;
    EditText email;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FirebaseApp.initializeApp(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        email = findViewById(R.id.email);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString() == null) {
                    Toast.makeText(Register.this, "Username Required", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.getText().toString() == null) {
                    Toast.makeText(Register.this, "Email Required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.getText().toString() == null || password.getText().toString().length() < 6) {
                    Toast.makeText(Register.this, "Password required/Required password must be longer than 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                createAcc(email.getText().toString(), password.getText().toString());
            }

        });

    }


    private void createAcc(String email, String pass) {
        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Register.this, "New User Created", Toast.LENGTH_SHORT).show();

                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    user.sendEmailVerification();
                    firebaseAuth.signOut();
                    Intent intent = new Intent(Register.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Register.this, "Error!" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


