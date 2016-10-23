package com.grino.catinlove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.grino.catinlove.fragments.MainFragment;

import butterknife.BindView;

public class MainActivity
        extends AppCompatActivity {

    @BindView(R.id.toolbar)     Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_main, new MainFragment())
                .commit();
    }


}
