package com.strsoftware.strposn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
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

        Cursor cursor = database.rawQuery("SELECT * FROM unit_list where delete_flag = 'N';",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            UnitList bean = new UnitList();
            bean.setId(cursor.getInt(0));
            bean.setUnitText(cursor.getString(1));
            unitList.add(bean);
            cursor.moveToNext();


        }
        cursor.close();
        return unitList;
    }
    public int  add(UnitList unitList){
        String query = "Select count(*) from unit_list where unit_text = ? AND delete_flag = ?";
        SQLiteStatement stmt = database.compileStatement(query);
        stmt.bindString(1,unitList.getUnitText());
        stmt.bindString(2,"N");
        int count_row = (int)stmt.simpleQueryForLong();
        if(stmt !=null) stmt.close();
        if( count_row != 0){
            return 0;
        }else{
            ContentValues values = new ContentValues();
            values.put("unit_text",unitList.getUnitText());
            this.database.insert("unit_list",null,values);
            return 1;
        }

        //Log.d("Todo List Demo ","Add OK !!!");


    }
    public void  delete(UnitList unitList){
        //UnitList delUnitlist = unitList;
        //String sqlText = "DELETE FROM unit_list WHERE id=" + delUnitlist.getId();
        this.database.execSQL("UPDATE unit_list set delete_flag = 'Y' where id_unit = "+ unitList.getId());

    }

}
