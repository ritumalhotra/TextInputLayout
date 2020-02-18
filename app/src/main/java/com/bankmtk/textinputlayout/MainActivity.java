package com.bankmtk.textinputlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    TextInputEditText login;
    TextInputEditText password;

    Pattern checkLogin = Pattern.compile("^[A-Z][a-z]{2,}$");
    Pattern checkPassword = Pattern.compile("^(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.inputLoginName);
        password = findViewById(R.id.inputPassword);

        login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) return;
                TextView tv = (TextView)v;
                validate(tv,checkLogin,"It's not name!");
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)return;
                TextView tv = (TextView)v;
                validate(tv,checkPassword,"Very simple password!");
            }
        });
    }
    private void validate(TextView tv, Pattern check, String message){
        String value = tv.getText().toString();
        if (check.matcher(value).matches()){
            hideError(tv);
        }
        else {
            showError(tv,message);
        }
    }
    private void showError(TextView view,String message){
        view.setError(message);
    }
    private void hideError(TextView view){
        view.setError(null);
    }
}
