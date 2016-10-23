package com.grino.catinlove.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;
import com.grino.catinlove.adapters.ViewPagerAdapter;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.rx.BusMessage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment
    extends BaseFragment{

    @BindView(R.id.tab_layout)  TabLayout tabs;
    @BindView(R.id.view_pager)  ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        setupViewPager(pager);
        tabs.setupWithViewPager(pager);

        MyApp.getCat().setName("Влюбленный кот");

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_indicators, new IndicatorsFragment())
                .commit();

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Resources res = getResources();
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new ActionsFragment(), res, DO.RELAX);
        adapter.addFragment(new ActionsFragment(), res, DO.PLAY);
        adapter.addFragment(new ActionsFragment(), res, DO.EAT);
        adapter.addFragment(new ActionsFragment(), res, DO.HUNT);
        adapter.addFragment(new ActionsFragment(), res, DO.CREATE);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void processEvent(Object event) {
        if (event instanceof BusMessage) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Важное сообщение!")
                    .setMessage(((BusMessage) event).getMsg())
                    .setIcon(R.drawable.eat)
                    .setCancelable(false)
                    .setNegativeButton("ИГРАТЬ!", null);
            AlertDialog alert = builder.create();
            alert.show();
        }
    }
}
