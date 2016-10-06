package com.strsoftware.strposn.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.dao.ProductDAO;
import com.strsoftware.strposn.model.ProductList;
import com.strsoftware.strposn.util.Util_String;

import static com.strsoftware.strposn.R.id.txt_product_name;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductAddFragment extends Fragment implements View.OnClickListener {
    Button btn_product_add;
    EditText txt_product_name;
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
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
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
}
