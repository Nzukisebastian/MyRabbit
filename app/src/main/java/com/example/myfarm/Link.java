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

public class Link extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = Link.this;
    private NestedScrollView nestedScrollView;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private AppCompatButton appCompatButtonLogin;
    private AppCompatButton textViewLinkRegister;
    private InputValidation inputValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        appCompatButtonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);
        textViewLinkRegister = (AppCompatButton) findViewById(R.id.textViewLinkRegister);
        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view== appCompatButtonLogin){
            Intent accountsIntent = new Intent(activity, LoginActivity.class);
            startActivity(accountsIntent);
        }else if(view==textViewLinkRegister){
            Intent Intent = new Intent(activity, Admin.class);
            startActivity(Intent);
        }
    }
}
