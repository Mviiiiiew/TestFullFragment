package com.strsoftware.strposn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.fragment.SaleMainFragment;

public class SaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);


                    getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainersale,SaleMainFragment.newInstance())
                    .commit();

    }
}
