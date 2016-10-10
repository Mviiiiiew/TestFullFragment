package com.strsoftware.strposn.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.activity.ProductAddActivity;
import com.strsoftware.strposn.adapter.productAdapter;
import com.strsoftware.strposn.dao.ProductDAO;
import com.strsoftware.strposn.model.ProductList;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ProductFragment extends Fragment implements View.OnClickListener {
    ImageButton btn_add_product;
    ListView listview_product;

    public ProductFragment() {
        super();
    }

    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_product, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        listview_product=(ListView)rootView.findViewById(R.id.listview_product);
        btn_add_product=(ImageButton)rootView.findViewById(R.id.btn_add_product);
        btn_add_product.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        final ProductDAO productDAO = new ProductDAO(getActivity());
        productDAO.open();
        final ArrayList<ProductList> myProductList = productDAO.getAllProductList();
        productDAO.close();


        final productAdapter objAdapter = new productAdapter(getActivity(),myProductList);
        listview_product.setAdapter(objAdapter);

        listview_product.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // Toast.makeText(getActivity(),"Click Long Successfully",Toast.LENGTH_SHORT).show();



                AlertDialog.Builder alertDialogder  = new AlertDialog.Builder(getActivity());
                alertDialogder.setTitle(" Delete Yes / No ?" );
                //alertDialogder.setMessage("Do yo want Delete Item "+objAdapter.getUnitName(position));
                alertDialogder.setMessage("Do yo want Delete Item "+((ProductList)objAdapter.getItem(position)).getProductText());
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

                        ProductList productList = new ProductList();
                        productList.setId((int) objAdapter.getItemId(position));
                        ProductDAO productListDAODel  = new ProductDAO(getActivity());
                        productListDAODel.open();
                        productListDAODel.delete(productList);
                        productListDAODel.close();

                        myProductList.remove(position);
                        objAdapter.notifyDataSetChanged();
                        // dialog.dismiss();



                    }
                });
                alertDialogder.show();


                return false;
            }
        });

        listview_product.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"Click Short Successfully"+"   "+ objAdapter.getItemId(position),Toast.LENGTH_SHORT).show();
            }
        });
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
        if(btn_add_product == v){
            Intent intent = new Intent(getContext(), ProductAddActivity.class);
            startActivity(intent);
        }
    }
}
