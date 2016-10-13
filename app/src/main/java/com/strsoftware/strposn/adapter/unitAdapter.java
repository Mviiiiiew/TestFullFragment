package com.strsoftware.strposn.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

/**
 * Created by Wasabi on 10/3/2016.
 */

public class unitAdapter extends BaseAdapter implements Filterable {
    private  static Activity activity;
    private static LayoutInflater inflater;

     ArrayList<UnitList> myUnitList;
     CustomFilter filter;
    ArrayList<UnitList>  filterList;

    public unitAdapter(Activity activity,ArrayList<UnitList> myUnitList) {
        this.myUnitList = myUnitList;
        this.activity = activity;
        this.filterList = myUnitList;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return myUnitList.size();
    }

    @Override
    public Object getItem(int position) {
        return myUnitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myUnitList.get(position).getId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null){
            v = inflater.inflate(R.layout.list_item_unit,null);
        }
        TextView textview = (TextView) v.findViewById(R.id.txt_unit_name);
        TextView textView3 = (TextView)  v.findViewById(R.id.txt_id);
        UnitList unitList = myUnitList.get(position);
        textview.setText(unitList.getUnitText());
        textView3.setText(unitList.getId()+"");

        return v;
    }

    @Override
    public Filter getFilter() {

        if(filter == null){
            filter = new CustomFilter();
        }


        return filter;
    }



    class CustomFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint != null && constraint.length()>0)
            {
                constraint = constraint.toString().toUpperCase();

                ArrayList<UnitList> filters = new ArrayList<>();
                for(int i=0;i<filterList.size();i++)
                {
                    if(filterList.get(i).getUnitText().toUpperCase().contains(constraint)){
                        UnitList u=new UnitList(filterList.get(i).getId(),filterList.get(i).getUnitText());
                        filters.add(u);
                    }
                }
                results.count = filters.size();
                results.values=filters;
            }else
            {
                results.count = filterList.size();
                results.values=filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            myUnitList = (ArrayList<UnitList>) results.values;
            notifyDataSetChanged();
        }
    }


}
