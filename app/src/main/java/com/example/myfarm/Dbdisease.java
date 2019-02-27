package com.example.myfarm;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Dbdisease extends SQLiteOpenHelper {

    public long result;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "DiseaseManager.db";

    // User table name
    private static final String TABLE_USER = "disease";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "type";
    private static final String COLUMN_USER_NAME = "details";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " TEXT,"
            + COLUMN_USER_NAME + " TEXT" + ")";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    /**
     * Constructor
     *
     * @param context
     */
    public Dbdisease(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);

        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param info
     */
    public boolean breedinfo(Info info) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, info.getBreedtype());
        values.put(COLUMN_USER_NAME, info.getBreeddetails());

        // Inserting Row
        result= db.insert(TABLE_USER, null, values);
        db.close();
        if(result==-1) {
            return false;
        }else{
            return true;
        }
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<Info> getAllinfo() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_NAME
        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<Info> userList = new ArrayList<Info>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Info info = new Info();
                info.setBreedtype(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID)));
                info.setBreeddetails(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                // Adding user record to list
                userList.add(info);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }
}
