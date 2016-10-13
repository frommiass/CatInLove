package com.grino.catinlove;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.grino.catinlove.adapters.ViewPagerAdapter;
import com.grino.catinlove.fragments.ActionsFragment;
import com.grino.catinlove.fragments.IndicatorsFragment;
import com.grino.catinlove.models.Action;
import com.grino.catinlove.models.Indicators;
import com.grino.catinlove.models.Player;
import com.grino.catinlove.models.Resources;
import com.grino.catinlove.rx.RxBus;
import com.grino.catinlove.tools.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity
        extends AppCompatActivity {


    private RxBus bus = null;
    public RxBus getBus() {
        if (bus == null) bus = new RxBus();
        return bus;
    }

    private Player cat;
    public Player getCat() {
        if (cat == null) cat = new Player(this);
        return cat;
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
        getCat().setName("Влюбленный кот");
    }



    public void fabClick(){
        Action test = new Action(getApplicationContext(), "Поспать на подушке", false);
        test.setExperience(1);
        test.set(Resources.KEY_FOOD, Utils.rand(5));
        test.set(Indicators.KEY_ENERGY, -1);
        test.set(Indicators.KEY_SATIETY, 2);
        test.set(Indicators.KEY_MOOD, 3);

        cat.doTick(test);
        //    updateIndicators(cat);

        Snackbar.make(tabs, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ActionsFragment(), "Отдых", R.array.action_energy);
        adapter.addFragment(new ActionsFragment(), "Кушать", R.array.action_satiety);
        adapter.addFragment(new ActionsFragment(), "Играть", R.array.action_mood);
        adapter.addFragment(new ActionsFragment(), "Охота", R.array.action_hunting);
        adapter.addFragment(new ActionsFragment(), "Скот", R.array.action_cattle);
        viewPager.setAdapter(adapter);
    }

}
