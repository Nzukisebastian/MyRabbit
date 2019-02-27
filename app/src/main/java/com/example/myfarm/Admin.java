package com.example.myfarm;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class Admin extends AppCompatActivity implements View.OnClickListener  {
    private final AppCompatActivity activity = Admin.this;
    private NestedScrollView nestedScrollView;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private AppCompatButton appCompatButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide();
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        appCompatButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view== appCompatButtonLogin){
       String email= textInputEditTextEmail.getText().toString().trim();
       String password= textInputEditTextPassword.getText().toString().trim();
        if(email.equals("admin@gmail.com")&& password.equals("admin")) {
            Intent accountsIntent = new Intent(activity, Breeds.class);
            startActivity(accountsIntent);
        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }}
    }
}

