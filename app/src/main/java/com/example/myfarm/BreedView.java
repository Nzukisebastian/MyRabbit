package com.example.myfarm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BreedView extends AppCompatActivity {

    private AppCompatActivity activity = BreedView.this;
    private TextView textViewName;
    private RecyclerView recyclerViewinfo;
    private List<Info> listUsers;
    private InfoRecyclerAdapter infoRecyclerAdapter;
    private Dbhelperbreed dbhelperbreed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_view);
        //views
        textViewName = (TextView) findViewById(R.id.textViewName);
        recyclerViewinfo = (RecyclerView) findViewById(R.id.recyclerViewinfor);
        //initobjects
        listUsers = new ArrayList<>();
        infoRecyclerAdapter = new InfoRecyclerAdapter(listUsers);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewinfo.setLayoutManager(mLayoutManager);
        recyclerViewinfo.setItemAnimator(new DefaultItemAnimator());
        recyclerViewinfo.setHasFixedSize(true);
        recyclerViewinfo.setAdapter(infoRecyclerAdapter);
        dbhelperbreed=new Dbhelperbreed(activity);
        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);
        getDataFromSQLite();
    }
    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(dbhelperbreed.getAllinfo());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                infoRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        LinearLayout main_view=(LinearLayout) findViewById(R.id.usermain);
        switch(item.getItemId()){
            case R.id.menu_red:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,BreedView.class));
                //main_view.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,DiseaseActivity.class));
                // main_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_yellow:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,ProductActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_pple:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,FoodActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.market:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,MarketActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_miss:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,FarmActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_logout:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,LoginActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_mpesa:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,HouseActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            case R.id.menu_post:
                if(item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                startActivity(new Intent(this,BreedingActivity.class));
                //main_view.setBackgroundColor(Color.YELLOW);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
