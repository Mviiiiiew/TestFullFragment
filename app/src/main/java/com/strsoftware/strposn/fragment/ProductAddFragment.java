package com.strsoftware.strposn.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.adapter.spinnerUnitAdapter;
import com.strsoftware.strposn.dao.ProductDAO;
import com.strsoftware.strposn.dao.UnitDAO;
import com.strsoftware.strposn.model.ProductList;
import com.strsoftware.strposn.model.UnitList;
import com.strsoftware.strposn.util.Util_String;

import java.util.ArrayList;

import static com.strsoftware.strposn.R.id.txt_product_name;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductAddFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private UnitDAO mUnitDAO;


    private spinnerUnitAdapter mSpinnerUnitAdapter;
    private UnitList mSelectedUnit;
    Button btn_product_add;
    EditText txt_product_name;
    Spinner spinner_unit;
    public ProductAddFragment() {
        super();
    }

    public static ProductAddFragment newInstance() {
        ProductAddFragment fragment = new ProductAddFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_product, container, false);
        initInstances(rootView);
       final UnitDAO mUnitDAO = new UnitDAO(getActivity());
        mUnitDAO.open();
        final  ArrayList<UnitList> unitList = mUnitDAO.getAllUnitList();
        mUnitDAO.close();
        mSpinnerUnitAdapter = new spinnerUnitAdapter(getActivity(),unitList);
        spinner_unit.setAdapter(mSpinnerUnitAdapter);
       // spinner_unit.setOnItemClickListener(this);
        return rootView;
    }
   /* final UnitDAO unitDAO = new UnitDAO(getActivity());
    unitDAO.open();
    final ArrayList<UnitList> myListUnit = unitDAO.getAllUnitList();
    unitDAO.close();*/

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        spinner_unit = (Spinner)rootView.findViewById(R.id.spinner_unit);
        btn_product_add = (Button)rootView.findViewById(R.id.btn_product_add);
        txt_product_name = (EditText)rootView.findViewById(R.id.txt_product_name);
        btn_product_add.setOnClickListener(this);
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
        int ex = 0;
        if (v == btn_product_add) {
            if (txt_product_name.getText().toString().trim().replaceAll(" ", "").matches("")) {
                Toast.makeText(getContext(), "  Not Name Product", Toast.LENGTH_SHORT).show();
            } else {
                ProductList productList = new ProductList();
                productList.setProductText(Util_String.getGennerlateString(txt_product_name.getText().toString()));
                ProductDAO productDAO = new ProductDAO(getContext());
                productDAO.open();
                ex = productDAO.add(productList);
                productDAO.close();
                if (ex == 0) {
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
                } else {
                    getActivity().finish();
                }
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mSelectedUnit = (UnitList) mSpinnerUnitAdapter.getItem(position);


    }
}
