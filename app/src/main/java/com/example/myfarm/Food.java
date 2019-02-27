package com.example.myfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Food extends AppCompatActivity {

    private final AppCompatActivity activity = Food.this;
    private EditText breedtype;
    private EditText breeddetails;
    private Button submit;
    private Dbfood dbfood;
    private Info info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        breedtype=(EditText)findViewById(R.id.breedtype);
        breeddetails=(EditText)findViewById(R.id.breeddetails);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postDataToSQLite();
            }
        });
    }
    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        dbfood = new Dbfood(activity);
        info=new Info();
        info.setBreedtype(breedtype.getText().toString().trim());
        info.setBreeddetails(breeddetails.getText().toString().trim());
        dbfood.breedinfo(info);
        if(dbfood.result!=1){
            // Snack Bar to show success message that record saved successfully
            Toast.makeText(Food.this,"successfully uploaded",Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(getApplicationContext(), FarmOperations.class);
            //startActivity(intent);
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(Food.this,"failed",Toast.LENGTH_LONG).show();
        }
    }
}
