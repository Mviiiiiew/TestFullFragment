package com.strsoftware.strposn.fragment;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.activity.SaleActivity;
import com.strsoftware.strposn.activity.SearchResultsActivity;
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
    Toolbar my_toolbar;


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
        my_toolbar = (Toolbar) rootView.findViewById(R.id.my_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(my_toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.my_tb_title);



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
        final UnitDAO unitDAO = new UnitDAO(getActivity());
        unitDAO.open();
        final ArrayList<UnitList> myListUnit = unitDAO.getAllUnitList();
        unitDAO.close();


        final unitAdapter objAdapter = new unitAdapter(getActivity(), myListUnit);
        lvUnit.setAdapter(objAdapter);

        lvUnit.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // Toast.makeText(getActivity(),"Click Long Successfully",Toast.LENGTH_SHORT).show();


                AlertDialog.Builder alertDialogder = new AlertDialog.Builder(getActivity());
                alertDialogder.setTitle(" Delete Yes / No ?");
                //alertDialogder.setMessage("Do yo want Delete Item "+objAdapter.getUnitName(position));
                alertDialogder.setMessage("Do yo want Delete Item " + ((UnitList) objAdapter.getItem(position)).getUnitText());
                alertDialogder.setCancelable(false);
                alertDialogder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                alertDialogder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        UnitList unitlist = new UnitList();
                        unitlist.setId((int) objAdapter.getItemId(position));
                        UnitDAO unitListDAODel = new UnitDAO(getActivity());
                        unitListDAODel.open();
                        unitListDAODel.delete(unitlist);
                        unitListDAODel.close();
                        myListUnit.remove(position);
                        objAdapter.notifyDataSetChanged();

                        // dialog.dismiss();


                    }
                });
                alertDialogder.show();


                return false;
            }
        });

        lvUnit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Click Short Successfully" + "   " + objAdapter.getItemId(position), Toast.LENGTH_SHORT).show();
            }
        });
        /*lvUnit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),String.valueOf(objAdapter.getItemId(position)),
                        Toast.LENGTH_SHORT).show();


            }
        });*/
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
