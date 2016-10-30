package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.layouts.AttributeLayout;
import com.grino.catinlove.layouts.IndicatorLayout;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.models.Action.KeyInt;
import com.grino.catinlove.rxBus.BusActionClick;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndicatorsFragment
        extends BaseFragment {

    @BindView(R.id.ind_satiety)     IndicatorLayout satiety;
    @BindView(R.id.ind_mood)        IndicatorLayout mood;
    @BindView(R.id.ind_energy)      IndicatorLayout energy;
    @BindView(R.id.pb_exp)          ProgressBar pbExp;

    @BindView(R.id.level)   TextView tvLevel;
    @BindView(R.id.food)    TextView tvFood;
    @BindView(R.id.real)    TextView tvReal;

    @BindView(R.id.attribute_1) AttributeLayout paws;
    @BindView(R.id.attribute_2) AttributeLayout mustache;
    @BindView(R.id.attribute_3) AttributeLayout claws;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_indicators, container, false);
        unbinder = ButterKnife.bind(this, layout);

        updateIndicators();

        return layout;
    }

    public void updateIndicators(){
        mood.setProgress(cat.getContent(KEY.MOOD));
        satiety.setProgress(cat.getContent(KEY.SATIETY));
        energy.setProgress(cat.getContent(KEY.ENERGY));

        pbExp.setProgress(cat.getContent(KEY.EXP));
        pbExp.setMax(cat.getMaxExp());
        tvLevel.setText("" + cat.getLevel().get());

        tvFood.setText("" + cat.getContent(KEY.FOOD));
        tvReal.setText("" + cat.getContent(KEY.REAL));

        paws.setValue(cat.getContent(KEY.PAWS));
        mustache.setValue(cat.getContent(KEY.MUSTACHE));
        claws.setValue(cat.getContent(KEY.CLAWS));
    }

    @Override
    public void processEvent(Object event) {
        if (event instanceof BusActionClick) {
            Action action = ((BusActionClick) event).getAction();

            if (action != null) {
                TextView ind = null;
                KeyInt one = action.getOne();

                if (one != null) {
                    if (KEY.SATIETY.equals(one.getKey())) ind = satiety.getVName();
                    else if (KEY.ENERGY.equals(one.getKey())) ind = energy.getVName();
                    else if (KEY.MOOD.equals(one.getKey())) ind = mood.getVName();

                    if (ind != null)
                        YoYo.with(Techniques.Flash).duration(700).playOn(ind);
                }
            }

            cat.doTick(action);
            updateIndicators();
        }
    }

}
