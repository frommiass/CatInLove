package com.grino.catinlove;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.grino.catinlove.adapters.ViewPagerAdapter;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.fragments.ActionsFragment;
import com.grino.catinlove.fragments.IndicatorsFragment;
import com.grino.catinlove.models.Actions;
import com.grino.catinlove.models.Player;
import com.grino.catinlove.models.Resource;
import com.grino.catinlove.rx.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity
        extends AppCompatActivity {

    private Actions actions = null;
    public Actions getActions() {
        if (actions == null) {
            actions = new Actions(DO.class);
            actions.fillActions();
        }
        return actions;
    }

    @BindView(R.id.tab_layout)  TabLayout tabs;
    @BindView(R.id.view_pager)  ViewPager pager;
    @BindView(R.id.toolbar)     Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setupViewPager(pager);
        tabs.setupWithViewPager(pager);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_indicators, new IndicatorsFragment())
                .commit();

        //При первом запуске запросить имя у пользователя
        MyApp.getCat().setName("Влюбленный кот");
    }

    private void setupViewPager(ViewPager viewPager) {
        Resources res = getResources();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActionsFragment(), res, DO.RELAX);
        adapter.addFragment(new ActionsFragment(), res, DO.PLAY);
        adapter.addFragment(new ActionsFragment(), res, DO.EAT);
        adapter.addFragment(new ActionsFragment(), res, DO.HUNT);
        adapter.addFragment(new ActionsFragment(), res, DO.CREATE);
        viewPager.setAdapter(adapter);
    }
}
