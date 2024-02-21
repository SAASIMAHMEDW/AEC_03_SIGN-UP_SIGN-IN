package com.example.signuplogin1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class HomeActivity extends AppCompatActivity {

    Button home_signup_btn;
    TextInputEditText home_email,home_password;
    String HOME_USERNAME,HOME_PASSWORD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        inisilizer();
        getIntentUPdata();
        setData();
        handleHomeSignUpBTN();
    }
    public void inisilizer(){
        home_email = findViewById(R.id.home_email);
        home_password = findViewById(R.id.home_password);
        home_signup_btn = findViewById(R.id.home_signup_btn);

    }
    public void getIntentUPdata(){
        Intent signIN = getIntent();
        HOME_USERNAME = signIN.getStringExtra("IN_USERNAME");
        HOME_PASSWORD = signIN.getStringExtra("IN_PASSWORD");
    }

    public void setData(){
        home_email.setEnabled(false);
        home_email.setText(HOME_USERNAME);
        home_password.setEnabled(false);
        home_password.setText(HOME_PASSWORD);
    }
    public void  handleHomeSignUpBTN(){
        home_signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(HomeActivity.this,SignUpActivity.class);
                startActivity(signup);
                finishAffinity();
            }
        });

    }

}