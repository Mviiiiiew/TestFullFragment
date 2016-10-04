package com.strsoftware.strposn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.activity.SaleActivity;
import com.strsoftware.strposn.adapter.unitAdapter;
import com.strsoftware.strposn.dao.UnitDAO;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class UnitFragment extends Fragment implements View.OnClickListener {

    ListView lvUnit;
   android.widget.Button btn_add_unit;


    public UnitFragment() {
        super();
    }

    public static UnitFragment newInstance() {
        UnitFragment fragment = new UnitFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_unit, container, false);
        initInstances(rootView);


/*
        ArrayAdapter<UnitList> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1,
        myListUnit);
        lvUnit.setAdapter(adapter);
*/
        return rootView;

    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        lvUnit = (ListView) rootView.findViewById(R.id.lvUnit);
        btn_add_unit = (android.widget.Button) rootView.findViewById(R.id.btn_add_unit);
        btn_add_unit.setOnClickListener(this);



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
    public void onResume() {

        super.onResume();
        UnitDAO unitDAO = new UnitDAO(getActivity());
        unitDAO.open();
        ArrayList<UnitList> myListUnit = unitDAO.getAllUnitList();



        unitAdapter objAdapter = new unitAdapter(getActivity(),R.layout.list_item_unit,myListUnit);
        lvUnit.setAdapter(objAdapter);
        unitDAO.close();
    }

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
        if (v == btn_add_unit) {
            Intent intent = new Intent(getActivity(), SaleActivity.class);
            startActivity(intent);
        }


    }
}
