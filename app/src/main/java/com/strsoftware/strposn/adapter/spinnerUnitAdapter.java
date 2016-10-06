package com.strsoftware.strposn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

/**
 * Created by Wasabi on 10/6/2016.
 */

public class spinnerUnitAdapter extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<UnitList> myUnitListSpinner;

    public spinnerUnitAdapter(Activity activity,ArrayList<UnitList> myUnitListSpinner) {
        this.myUnitListSpinner = myUnitListSpinner;
        this.activity = activity;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myUnitListSpinner.size();
    }

    @Override
    public Object getItem(int position) {
        return myUnitListSpinner.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myUnitListSpinner.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.list_item_spinner,null);
        TextView textview = (TextView) v.findViewById(R.id.txt_unit_name_spinner);
        UnitList unitList = myUnitListSpinner.get(position);
        textview.setText(unitList.getUnitText());

        return v;
    }
}
