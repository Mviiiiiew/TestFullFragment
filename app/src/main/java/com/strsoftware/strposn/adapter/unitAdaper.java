package com.strsoftware.strposn.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wasabi on 9/30/2016.
 */

public class unitAdaper  extends ArrayAdapter<UnitList>{

    ArrayList<UnitList> unitList = new ArrayList<>();
    public unitAdaper(Context context, int resource, ArrayList<UnitList> objects) {
        super(context, resource, objects);
        unitList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_unit,null);
        TextView textview = (TextView) convertView.findViewById(R.id.txt_unit_name);
        TextView textview2 = (TextView) convertView.findViewById(R.id.txt_price);
        TextView textView3 = (TextView)  convertView.findViewById(R.id.txt_id);
        textview.setText(unitList.get(position).getUnitText());
        textview2.setText(unitList.get(position).getPriceText());
        textView3.setText(unitList.get(position).getId()+"");
        return convertView;
    }
}
