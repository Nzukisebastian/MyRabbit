package com.example.myfarm;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Breeds extends AppCompatActivity {
    private final AppCompatActivity activity = Breeds.this;
    private EditText breedtype;
    private EditText breeddetails;
    private Button submit;
    private Dbhelperbreed dbhelperbreed;
    private Info info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds);
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
        dbhelperbreed = new Dbhelperbreed(activity);
        info=new Info();
        info.setBreedtype(breedtype.getText().toString().trim());
            info.setBreeddetails(breeddetails.getText().toString().trim());
            dbhelperbreed.breedinfo(info);
        if(dbhelperbreed.result!=1){
            // Snack Bar to show success message that record saved successfully
            Toast.makeText(Breeds.this,"successfully uploaded",Toast.LENGTH_LONG).show();
           // Intent intent = new Intent(getApplicationContext(),Breeding.class);
            //startActivity(intent);
        } else {
            // Snack Bar to show error message that record already exists
            Toast.makeText(Breeds.this,"failed",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        RelativeLayout main_view=(RelativeLayout)findViewById(R.id.menu);
        switch(item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,Breeds.class));
                //main_view.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,Diseases.class));
                // main_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,Products.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_pple:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,Food.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.market:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,Marketing.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_miss:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,FarmOperations.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_logout:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,MarketActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_mpesa:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,House.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_post:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,Breeding.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
