package com.strsoftware.strposn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.strsoftware.strposn.R;
import com.strsoftware.strposn.fragment.UnitFragment;

public class UnitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.contentContainerUnit, UnitFragment.newInstance())
                .commit();
    }
}
