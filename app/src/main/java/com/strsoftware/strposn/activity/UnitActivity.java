package com.strsoftware.strposn.activity;

import android.app.SearchManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.adapter.unitAdapter;
import com.strsoftware.strposn.dao.UnitDAO;
import com.strsoftware.strposn.fragment.UnitFragment;
import com.strsoftware.strposn.model.UnitList;

import java.util.ArrayList;

public class UnitActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainerUnit, UnitFragment.newInstance())
                .commit();



    }

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));


        return super.onCreateOptionsMenu(menu);
    }
}
