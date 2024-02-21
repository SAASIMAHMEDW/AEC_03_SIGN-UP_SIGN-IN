package com.example.signuplogin1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {

    Button signin_btn;
    TextInputEditText signin_email,signin_password;
    TextView signupp_btn;

    String USERNAME,PASSWORD;
    String SUP_USERNAME,SUP_PASSWORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);
        inisilizer();
        getIntentUPdata();
        handleSignInBtn();
        handleSignUpBtn();
    }

    public void inisilizer(){
        signin_btn = findViewById(R.id.signin_btn);
        signin_email = findViewById(R.id.signin_email);
        signin_password = findViewById(R.id.signin_password);
        signupp_btn = findViewById(R.id.signupp_btn);

    }

    public void handleSignInBtn(){
        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USERNAME = signin_email.getText().toString();
                PASSWORD = signin_password.getText().toString();
                if(USERNAME.equals(SUP_USERNAME) && PASSWORD.equals(SUP_PASSWORD)){
                    Intent home = new Intent(SignInActivity.this,HomeActivity.class);
                    home.putExtra("IN_USERNAME",USERNAME);
                    home.putExtra("IN_PASSWORD",PASSWORD);
                    startActivity(home);
                    finishAffinity();
                }else {
                    Toast.makeText(SignInActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void getIntentUPdata(){
        Intent signIN = getIntent();
        SUP_USERNAME = signIN.getStringExtra("SUP_USERNAME");
        SUP_PASSWORD = signIN.getStringExtra("SUP_PASSWORD");
    }
    public void handleSignUpBtn(){
        signupp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(home);
            }
        });
    }
}