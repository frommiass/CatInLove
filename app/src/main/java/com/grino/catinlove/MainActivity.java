package com.grino.catinlove;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Player cat;
    private FloatingActionButton fab;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ctx = getApplicationContext();
        cat = new Player(ctx, "Влюбленный кот");

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {fabClick();
            }
        });
    }

    public void fabClick(){
        Action test = new Action(ctx, "Поспать на подушке");
        test.setExperience(1);
        test.resources.setFood((int)(Math.random() * 5));
        test.indicators.setEnergy(-1);
        test.indicators.setSatiety(-2);
        test.indicators.setMood(+2);

        cat.doTick();

        Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
