package com.strsoftware.strposn.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Wasabi on 9/27/2016.
 */

public class DbHelperUnit extends SQLiteOpenHelper {
    private static final String databaseName = "Unit.sqlite";
    private static final int databaseVersion = 1;
    Context myContext;


    private static final String tableUnitCreateSQL = "CREATE TABLE unit_list("
            +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"unit_text TEXT NOT NULL,"
            +"price_text TEXT NOT NULL"
            +");";



    public DbHelperUnit(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableUnitCreateSQL);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
