package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.models.Player.Player;
import com.grino.catinlove.rx.BusActionClick;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_indicators, container, false);
        unbinder = ButterKnife.bind(this, layout);

        updateIndicators(cat);

        return layout;
    }

    public void updateIndicators(Player player){
        pbMoon.setProgress(player.getContent(KEY.MOOD));
        pbSatiety.setProgress(player.getContent(KEY.SATIETY));
        pbEnergy.setProgress(player.getContent(KEY.ENERGY));
        pbExp.setProgress(player.getContent(KEY.EXP));
        pbExp.setMax(player.getMaxExp());
        tvLevel.setText("" + player.getLevel().get());
        tvFood.setText("" + player.getContent(KEY.FOOD));
        tvReal.setText("" + player.getContent(KEY.REAL));
    }

    @Override
    public void processEvent(Object event) {
        if (event instanceof BusActionClick) {
            Action action = ((BusActionClick) event).getAction();
            cat.doTick(action);
            updateIndicators(cat);
        }
    }
}
