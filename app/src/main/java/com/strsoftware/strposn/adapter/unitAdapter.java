package com.strsoftware.strposn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

/**
 * Created by Wasabi on 10/3/2016.
 */

public class unitAdapter extends ArrayAdapter {

    ArrayList<UnitList> unitList = new ArrayList<>();
    public unitAdapter(Context context, int resource, ArrayList<UnitList> objects) {
        super(context, resource, objects);
        unitList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }




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