package com.grino.catinlove;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;

    private Player cat;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ctx = getApplicationContext();
        cat = new Player(ctx, "Влюбленный кот");

    }

    @OnClick(R.id.fab)
    public void fabClick(){
        Action test = new Action(ctx, "Поспать на подушке");
        test.setExperience(1);
        test.resources.setFood((int)(Math.random() * 5));
        test.indicators.setEnergy(-3);
        test.indicators.setSatiety(+2);
        test.indicators.setMood(+1);

        cat.doTick(test);

        Snackbar.make(toolbar, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
