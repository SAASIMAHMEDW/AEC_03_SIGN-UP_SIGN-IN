package com.example.signuplogin1b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    TextInputEditText userName,userAge,userUsername,userEmail,userPassword,userConfirmPassword;
    Button signupx_btn;
    RadioButton userGenderMale,userGenderFemale;
    TextView signin_btn_reg;
    String NAME,AGE,USERNAME,EMAIL,PASSWORD,CPASSWORD,GENDER;
    Boolean status;
    Boolean conditionFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        initailizer();
        handleSignINBtn();
        signupx_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInputFieldData();
                if (status) {

                    if (validatePasswordLen(PASSWORD)){
                        if (validChar(PASSWORD)){
                            Toast.makeText(SignUpActivity.this, "CREATED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                            handleUPtoINintent();
                        }else {
                            userPassword.setError("must contain small capital number special char");
                        }
                    }
                    else {
                        userPassword.setError("password must be 8 char long");
                    }
                }
                else
                    userConfirmPassword.setError("Password is must be same");
            }
        });
    }
    public void initailizer(){
        userName = findViewById(R.id.userName);
        userAge = findViewById(R.id.userAge);
        userUsername = findViewById(R.id.userUsername);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        userConfirmPassword = findViewById(R.id.userConfirmPassword);
        userGenderMale = findViewById(R.id.userGenderMale);
        userGenderFemale = findViewById(R.id.userGenderFemale);
        signin_btn_reg = findViewById(R.id.signin_btn_reg);
        signupx_btn = findViewById(R.id.signupx_btn);
    }
    public void getUserInputFieldData(){
        USERNAME = Objects.requireNonNull(userUsername.getText()).toString();
        PASSWORD = Objects.requireNonNull(userPassword.getText()).toString();
        CPASSWORD = Objects.requireNonNull(userConfirmPassword.getText()).toString();
        if (PASSWORD.equals(CPASSWORD)){
            status = true;
        }else {
            status = false;
        }

    }
    public boolean validatePasswordLen(String password){
//        Toast.makeText(this, String.valueOf(password.length()), Toast.LENGTH_SHORT).show();
        //length must be 8
        if (password.length()<8){
            return false;
        }else {
            return true;
        }
    }
    public static boolean validChar(String password){
        //        contain letter, number, special chars
        if (isValidPassword(password)) {
//            System.out.println("Valid password!");
            return true;
        } else {
            return false;
//            System.out.println("Invalid password! Please make sure your password meets the requirements.");
        }
    }
    public static boolean isValidPassword(String password) {
        // Check length
        if (password.length() <= 8) {
            return false;
        }

        // Check for lowercase, uppercase, digit, and special character
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                // Assuming special characters are anything not in [a-zA-Z0-9]
                hasSpecial = true;
            }
        }
        return hasLowercase && hasUppercase && hasDigit && hasSpecial;
    }

    public void handleUPtoINintent(){
        Intent signIN = new Intent(SignUpActivity.this, SignInActivity.class);
        signIN.putExtra("SUP_USERNAME",USERNAME);
        signIN.putExtra("SUP_PASSWORD",PASSWORD);
        startActivity(signIN);
        finishAffinity();
    }

    public void handleSignINBtn(){
        signin_btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(home);
                finishAffinity();
            }
        });
    }


}


/*



    public boolean valid(String password){
//        contain letter, number, special chars

        int asciiValueA = 65;
        StringBuilder caps_letter = new StringBuilder();
        // Iterate through ASCII values from A to Z
        for (int i = 0; i < 26; i++) {
            String temp = String.valueOf((char) (asciiValueA + i));
            caps_letter.append(temp);
        }

        String special = "@#&$";
        String number = "0123456789";

        int lenP = password.length();


//        caps
        boolean caps = false;
        for (int i = 0; i < lenP; i++) {
            for (int j = 0; j < 26; j++) {
                if (String.valueOf(password.charAt(i)).equals(String.valueOf(caps_letter.charAt(j)))) {
                    caps=true;
                }
            }
            if (caps)
                break;
        }

//        number
        boolean num = false;
        for (int i = 0; i < lenP; i++) {
            for (int j = 0; j < 26; j++) {
                if (String.valueOf(password.charAt(i)).equals(String.valueOf(number.charAt(j)))) {
                    num=true;
                }
            }
            if (num)
                break;
        }


        return false;
    }

    public boolean smallCharValidator(String password){
        int lenP = password.length();
        int asciiValuea = 97;
        StringBuilder smal_letter = new StringBuilder();
        // Iterate through ASCII values from A to Z
        for (int i = 0; i < 26; i++) {
            String temp = String.valueOf((char) (asciiValuea + i));
            smal_letter.append(temp);
        }
        //        small
        boolean small = false;
        for (int i = 0; i < lenP; i++) {
            for (int j = 0; j < 26; j++) {
                if (String.valueOf(password.charAt(i)).equals(String.valueOf(smal_letter.charAt(j)))) {
                    small=true;
                }
            }
            if (small)
                break;
        }
        return false;
    }
 */