package com.example.myfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Breeding extends AppCompatActivity {
    private final AppCompatActivity activity = Breeding.this;
    private EditText breedtype;
    private EditText breeddetails;
    private Button submit;
    private Dbbreeding dbbreeding;
    private Info info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeding);
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
        dbbreeding = new Dbbreeding(activity);
        info=new Info();
        info.setBreedtype(breedtype.getText().toString().trim());
        info.setBreeddetails(breeddetails.getText().toString().trim());
        dbbreeding.breedinfo(info);
        if(dbbreeding.result!=1){
            // Snack Bar to show success message that record saved successfully
            Toast.makeText(Breeding.this,"successfully uploaded",Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(getApplicationContext(), Food.class);
          // startActivity(intent);
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(Breeding.this,"failed",Toast.LENGTH_LONG).show();
        }
    }
}
