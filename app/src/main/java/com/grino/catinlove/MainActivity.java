package com.grino.catinlove;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.tab_layout) TabLayout tabs;
    @BindView(R.id.view_pager) ViewPager pager;
    @BindView(R.id.recycler_view) RecyclerView recycler;

    @BindView(R.id.pb_1) ProgressBar pbSatiety;
    @BindView(R.id.pb_2) ProgressBar pbMoon;
    @BindView(R.id.pb_3) ProgressBar pbEnergy;

    private Player cat;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ctx = getApplicationContext();

        setSupportActionBar(toolbar);
        setupViewPager(pager);
        tabs.setupWithViewPager(pager);
        recycler.setLayoutManager(new LinearLayoutManager(ctx));

        //При первом запуске запросить имя у пользователя
        cat = new Player(ctx, "Влюбленный кот");
        updateIndicators(cat);
    }

    @OnClick(R.id.fab)
    public void fabClick(){
        Action test = new Action(ctx, "Поспать на подушке", false);
        test.setExperience(1);
        test.set(Resources.KEY_FOOD, Utils.rand(5));
        test.set(Indicators.KEY_ENERGY, -1);
        test.set(Indicators.KEY_SATIETY, 2);
        test.set(Indicators.KEY_MOOD, 3);

        cat.doTick(test);
        updateIndicators(cat);

        Snackbar.make(toolbar, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    public void updateIndicators(Player player){
        pbMoon.setProgress(player.getCondition().get(Indicators.KEY_MOOD));
        pbSatiety.setProgress(player.getCondition().get(Indicators.KEY_SATIETY ));
        pbEnergy.setProgress(player.getCondition().get(Indicators.KEY_ENERGY));


    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActionsFragment(), getString(R.string.indicator_energy));
        adapter.addFragment(new ActionsFragment(), getString(R.string.indicator_satiety));
        adapter.addFragment(new ActionsFragment(), getString(R.string.indicator_mood));
        viewPager.setAdapter(adapter);
    }


}
