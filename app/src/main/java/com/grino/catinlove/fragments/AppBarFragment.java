package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grino.catinlove.R;
import com.grino.catinlove.adapters.ViewPagerAdapter;
import com.grino.catinlove.models.Action;
import com.grino.catinlove.models.Indicators;
import com.grino.catinlove.models.Resources;
import com.grino.catinlove.tools.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppBarFragment
        extends BaseFragment {

    @BindView(R.id.tab_layout)  TabLayout tabs;
    @BindView(R.id.view_pager)  ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_main, container, false);
        unbinder = ButterKnife.bind(this, layout);

        setupViewPager(pager);
        tabs.setupWithViewPager(pager);

        return layout;
    }

    public void fabClick(){
        Action test = new Action(ctx, "Поспать на подушке", false);
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
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new ActionsFragment(), "Отдых", R.array.action_energy);
        adapter.addFragment(new ActionsFragment(), "Кушать", R.array.action_satiety);
        adapter.addFragment(new ActionsFragment(), "Играть", R.array.action_mood);
        adapter.addFragment(new ActionsFragment(), "Охота", R.array.action_hunting);
        adapter.addFragment(new ActionsFragment(), "Скот", R.array.action_cattle);
        viewPager.setAdapter(adapter);
    }
}
