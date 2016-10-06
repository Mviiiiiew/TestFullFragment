package com.strsoftware.strposn.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.Button;
import com.strsoftware.strposn.R;
import com.strsoftware.strposn.dao.UnitDAO;
import com.strsoftware.strposn.model.UnitList;
import com.strsoftware.strposn.util.Util_String;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SaleMainFragment extends Fragment implements View.OnClickListener {
    EditText txt_name_unit;

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
        int ex=0 ;
        if (v == btn_add) {
            if(txt_name_unit.getText().toString().trim().replaceAll(" ","").matches("")){
                Toast.makeText(getContext(),"  Not Name Unit",Toast.LENGTH_SHORT).show();
            }else{
                UnitList unitList = new UnitList();
                unitList.setUnitText(Util_String.getGennerlateString(txt_name_unit.getText().toString()));
                UnitDAO unitDAO = new UnitDAO(getContext());
                unitDAO.open();
                ex = unitDAO.add(unitList);
                unitDAO.close();
                if(ex == 0) {
                    AlertDialog.Builder alertDialogder = new AlertDialog.Builder(getContext());

                    alertDialogder.setMessage("ซ้ำนะ");
                    alertDialogder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
                    AlertDialog alertDialog = alertDialogder.create();
                    // show alert
                    alertDialog.show();
                }else{
                    getActivity().finish();
                }
            }
            //getActivity().finish();


        }
        //Log.d("Database Status:",ex+"");

    }




}
