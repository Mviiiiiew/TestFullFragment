package com.strsoftware.strposn.databaseUnit;

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


    private static final String tableUnitCreateSQL = "CREATE TABLE unit_list("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "unit_text TEXT"+
            ");";

    private static final String tableUnitCreateSQL2 = "CREATE TABLE unit_list2("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "unit_text TEXT"+
            ");";

    public DbHelperUnit(Context context) {
        super(context, databaseName, null, databaseVersion);
        this.myContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableUnitCreateSQL);
        db.execSQL(tableUnitCreateSQL2);
        String insertData1 = "INSERT INTO unit_list (unit_text) VALUES ('Todo Text 1');";
        String insertData2 = "INSERT INTO unit_list2 (unit_text) VALUES ('Todo Text 2');";
        db.execSQL(insertData1);
        db.execSQL(insertData2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
