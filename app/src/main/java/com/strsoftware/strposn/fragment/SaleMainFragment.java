package com.strsoftware.strposn.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gc.materialdesign.views.Button;
import com.strsoftware.strposn.R;
import com.strsoftware.strposn.dao.UnitDAO;
import com.strsoftware.strposn.model.UnitList;




/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SaleMainFragment extends Fragment implements View.OnClickListener {
    EditText txt_name_unit;
    EditText txt_name_price;
    android.widget.Button btn_add;


    public SaleMainFragment() {
        super();
    }

    public static SaleMainFragment newInstance() {
        SaleMainFragment fragment = new SaleMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sale_main, container, false);
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {
        btn_add = (android.widget.Button) rootView.findViewById(R.id.btn_add);
        txt_name_price = (EditText) rootView.findViewById(R.id.txt_name_price);
        txt_name_unit = (EditText) rootView.findViewById(R.id.txt_name_unit);
        btn_add.setOnClickListener(this);

        // Init 'View' instance(s) with rootView.findViewById here
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    @Override
    public void onClick(View v) {
        Log.d("v:",v.toString());
        if (v == btn_add) {
            UnitList unitList = new UnitList();
            unitList.setUnitText(String.valueOf(txt_name_unit.getText()));
            unitList.setPriceText(String.valueOf(txt_name_price.getText()));
            UnitDAO unitDAO = new UnitDAO(getContext());
            unitDAO.open();
            unitDAO.add(unitList);
            unitDAO.close();
            getActivity().finish();


        }

    }




}
