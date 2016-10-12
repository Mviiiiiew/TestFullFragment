package com.strsoftware.strposn.activity;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.adapter.unitAdapter;
import com.strsoftware.strposn.dao.UnitDAO;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity {

    Toolbar my_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        my_toolbar = (Toolbar)findViewById(R.id.search_results_toolbar);
        setSupportActionBar(my_toolbar);



        Intent searchIntent = getIntent();
        if (Intent.ACTION_SEARCH.equals(searchIntent.getAction())) {
            String query = searchIntent.getStringExtra(SearchManager.QUERY);
            getSupportActionBar().setTitle(query);
            Toast.makeText(SearchResultsActivity.this, query, Toast.LENGTH_SHORT).show();
        }




    }


}
