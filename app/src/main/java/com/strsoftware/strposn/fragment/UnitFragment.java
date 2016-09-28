package com.strsoftware.strposn.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.databaseUnit.UnitDAO;
import com.strsoftware.strposn.databaseUnit.UnitList;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class UnitFragment extends Fragment {

    ListView lvUnit;

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
        UnitDAO unitDAO = new UnitDAO(getActivity());
        unitDAO.open();
        ArrayList<UnitList> myListUnit = unitDAO.getAllUnitList();

        ArrayAdapter<UnitList> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_expandable_list_item_1,
                myListUnit);

        lvUnit.setAdapter(adapter);

        unitDAO.close();
        return rootView;

    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        lvUnit = (ListView) rootView.findViewById(R.id.lvUnit);

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
}
