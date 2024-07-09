package com.example.coffee_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.coffee_application.MainActivity;
import com.example.coffee_application.R;
import com.example.coffee_application.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void Sign_In(View view) {
        startActivity(new Intent(LoginActivity.this, SignInActivity.class));
    }

    public void Login(View view) {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

 */

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper( this);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(email.equals("") || password.equals(""))
                    Toast.makeText(LoginActivity.this, "All fields are mandatory ", Toast.LENGTH_SHORT).show();
                    else {
                    Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);


                    if (checkCredentials == true){
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}