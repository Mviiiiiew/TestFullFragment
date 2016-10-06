package com.strsoftware.strposn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.fragment.ProductAddFragment;

public class ProductAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainerAddProduct, ProductAddFragment.newInstance())
                .commit();
    }
}
