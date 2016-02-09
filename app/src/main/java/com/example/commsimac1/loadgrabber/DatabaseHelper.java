package com.example.commsimac1.loadgrabber;

/**
 * Created by CommsiMac1 on 09/02/16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/*
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cjfad on 08/02/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "transactions.db";
    public static final String TABLE_NAME = "transactions";

    SQLiteDatabase db;
    public static final String TABLE_CREATE = "create table transactions(id integer primary key,number text, amount double);";



    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public boolean insertTransaction(String id,int amount){
        //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        //Date date = new Date();


        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("number", id);
        values.put("amount", amount);
        db.insert(TABLE_NAME, null, values);
        db.close();

        return true;
    }
    public Cursor getTotal(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor res =  db.rawQuery("select (select sum(amount) from transactions where transtype = 1) - (select sum(amount) from transactions where transtype = 2)", null );
        Cursor res =  db.rawQuery("select sum(amount) from transactions where number = " + id + "", null );
        return res;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
        Log.d("MyApp", "CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

