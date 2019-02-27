package com.example.myfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FarmOperations extends AppCompatActivity {
    private final AppCompatActivity activity = FarmOperations.this;
    private EditText breedtype;
    private EditText breeddetails;
    private Button submit;
    private Dbfarm dbfarm;
    private Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_operations);
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
        dbfarm = new Dbfarm(activity);
        info=new Info();
        info.setBreedtype(breedtype.getText().toString().trim());
        info.setBreeddetails(breeddetails.getText().toString().trim());
        dbfarm.breedinfo(info);
        if(dbfarm.result!=1){
            // Snack Bar to show success message that record saved successfully
            Toast.makeText(FarmOperations.this,"successfully uploaded",Toast.LENGTH_LONG).show();
           // Intent intent = new Intent(getApplicationContext(),House.class);
            //startActivity(intent);
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(FarmOperations.this,"failed",Toast.LENGTH_LONG).show();
        }
    }
}
