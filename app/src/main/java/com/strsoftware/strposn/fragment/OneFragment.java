package com.strsoftware.strposn.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gc.materialdesign.views.ButtonRectangle;
import com.strsoftware.strposn.R;
import com.strsoftware.strposn.activity.SaleActivity;
import com.strsoftware.strposn.activity.TestPrintActivity;
import com.strsoftware.strposn.activity.UnitActivity;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class OneFragment extends Fragment implements View.OnClickListener {
    ButtonRectangle btnSingle;
    ButtonRectangle btnUnit;


    public OneFragment() {
        super();
    }

    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        btnSingle = (ButtonRectangle) rootView.findViewById(R.id.btnSingle);
        btnUnit = (ButtonRectangle) rootView.findViewById(R.id.btnUnit);
        btnSingle.setRippleSpeed(150);
        btnUnit.setRippleSpeed(150);
        btnUnit.setOnClickListener(this);
        btnSingle.setOnClickListener(this);



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
        if(btnUnit == v){
            Intent intent =new Intent(getContext(), UnitActivity.class);
            startActivity(intent);

        }


        }

    }

