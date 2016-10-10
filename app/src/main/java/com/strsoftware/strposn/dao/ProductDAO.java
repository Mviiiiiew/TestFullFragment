package com.strsoftware.strposn.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.strsoftware.strposn.model.ProductList;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

/**
 * Created by Wasabi on 10/5/2016.
 */

public class ProductDAO {
    private SQLiteDatabase database;
    private DbHelperUnit dbHelperProduct;
    public ProductDAO (Context context){
        dbHelperProduct = new DbHelperUnit(context);
    }
    public void open(){
        database = dbHelperProduct.getWritableDatabase();
    }
    public void close(){
        dbHelperProduct.close();
    }
    public ArrayList<ProductList> getAllProductList(){

        ArrayList<ProductList> productList = new ArrayList<>();

        Cursor cursor = database.rawQuery("select pl.id_product,pl.product_text,pl.id_unit,ul.unit_text from product_list pl " +
                "inner join  unit_list ul on pl.id_unit = ul.id_unit and   ul.delete_flag = 'N' " +
                "where pl.delete_flag = 'N';",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ProductList bean = new ProductList();
            bean.setId(cursor.getInt(0));
            bean.setProductText(cursor.getString(1));
            bean.setUnitList(new UnitList(cursor.getInt(2),cursor.getString(3)));
            productList.add(bean);
            cursor.moveToNext();


        }
        cursor.close();
        return productList;
    }
    public int  add(ProductList productList){
        String query = "Select count(*) from product_list where product_text = ? AND delete_flag = ?";
        SQLiteStatement stmt = database.compileStatement(query);
        stmt.bindString(1,productList.getProductText());
        stmt.bindString(2,"N");
        int count_row = (int)stmt.simpleQueryForLong();
        if(stmt !=null) stmt.close();
        if( count_row != 0){
            return 0;
        }else{
            ContentValues values = new ContentValues();
            values.put("product_text",productList.getProductText());
            values.put("id_unit",productList.getUnitList().getId());
            this.database.insert("product_list",null,values);
            return 1;
        }

        //Log.d("Todo List Demo ","Add OK !!!");


    }
    public void  delete(ProductList productList){
        //UnitList delUnitlist = unitList;
        //String sqlText = "DELETE FROM unit_list WHERE id=" + delUnitlist.getId();
        this.database.execSQL("UPDATE product_list set delete_flag = 'Y' where id_product = "+ productList.getId());

    }
}
