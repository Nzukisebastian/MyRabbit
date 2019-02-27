package com.example.myfarm;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends AppCompatActivity {
    private AppCompatActivity activity = MarketActivity.this;
    private TextView textViewName;
    private RecyclerView recyclerViewinfo;
    private List<Info> listUsers;
    private InfoRecyclerAdapter infoRecyclerAdapter;
    private Dbmarket dbmarket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
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
        dbmarket=new Dbmarket(activity);
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
                listUsers.addAll(dbmarket.getAllinfo());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                infoRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
