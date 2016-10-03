package com.strsoftware.strposn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

/**
 * Created by Wasabi on 9/27/2016.
 */

public class UnitDAO {
    private SQLiteDatabase database;
    private DbHelperUnit dbHelperUnit;
    public  UnitDAO(Context context){
        dbHelperUnit = new DbHelperUnit(context);
    }
    public void open(){
        database = dbHelperUnit.getWritableDatabase();
    }
    public void close() {
        dbHelperUnit.close();
    }

    public ArrayList<UnitList> getAllUnitList(){

        ArrayList<UnitList> unitList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM unit_list;",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            UnitList bean = new UnitList();
            bean.setId(cursor.getInt(0));
            bean.setUnitText(cursor.getString(1));
            bean.setPriceText(cursor.getString(2));
            unitList.add(bean);
            cursor.moveToNext();


        }
        cursor.close();
        return unitList;
    }
    public void  add(UnitList unitList){
        ContentValues values = new ContentValues();
        values.put("unit_text",unitList.getUnitText());
        values.put("price_text",unitList.getPriceText());
        this.database.insert("unit_list",null,values);

        //Log.d("Todo List Demo ","Add OK !!!");


    }

}
