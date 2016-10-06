package com.strsoftware.strposn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.model.ProductList;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

/**
 * Created by Wasabi on 10/5/2016.
 */

public class productAdapter extends BaseAdapter {
    private  static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<ProductList> myProductList;

    public productAdapter(Activity activity,ArrayList<ProductList> myProductList) {
        this.myProductList = myProductList;
        this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return myProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myProductList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.list_item_product,null);
        TextView textview = (TextView) v.findViewById(R.id.txt_name_product);
        TextView textView2 = (TextView)  v.findViewById(R.id.txt_id_producr);
        ProductList productList = myProductList.get(position);
        textview.setText(productList.getProductText());
        textView2.setText(productList.getId()+"");
        return v;
    }
}
