package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.layouts.AttributeLayout;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.rxBus.BusActionClick;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndicatorsFragment
        extends BaseFragment {

    @BindView(R.id.pb_satiety) ProgressBar pbSatiety;
    @BindView(R.id.pb_mood) ProgressBar pbMoon;
    @BindView(R.id.pb_energy) ProgressBar pbEnergy;
    @BindView(R.id.pb_exp) ProgressBar pbExp;

    @BindView(R.id.level) TextView tvLevel;
    @BindView(R.id.food) TextView tvFood;
    @BindView(R.id.real) TextView tvReal;

    @BindView(R.id.attribute_1) AttributeLayout att1;
    @BindView(R.id.attribute_2) AttributeLayout att2;
    @BindView(R.id.attribute_3) AttributeLayout att3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_indicators, container, false);
        unbinder = ButterKnife.bind(this, layout);

        att1.setName(KEY.PAWS.getName());
        att2.setName(KEY.MUSTACHE.getName());
        att3.setName(KEY.CLAWS.getName());

        att1.setIcon(R.drawable.paws);
        att2.setIcon(R.drawable.mustache);
        att3.setIcon(R.drawable.claws);

        updateIndicators();

        return layout;
    }

    public void updateIndicators(){
        pbMoon.setProgress(cat.getContent(KEY.MOOD));
        pbSatiety.setProgress(cat.getContent(KEY.SATIETY));
        pbEnergy.setProgress(cat.getContent(KEY.ENERGY));

        pbExp.setProgress(cat.getContent(KEY.EXP));
        pbExp.setMax(cat.getMaxExp());
        tvLevel.setText("" + cat.getLevel().get());

        tvFood.setText("" + cat.getContent(KEY.FOOD));
        tvReal.setText("" + cat.getContent(KEY.REAL));

        att1.setValue(cat.getContent(KEY.CLAWS));
        att2.setValue(cat.getContent(KEY.MUSTACHE));
        att3.setValue(cat.getContent(KEY.PAWS));
    }

    @Override
    public void processEvent(Object event) {
        if (event instanceof BusActionClick) {
            Action action = ((BusActionClick) event).getAction();
            cat.doTick(action);
            updateIndicators();
        }
    }

}
