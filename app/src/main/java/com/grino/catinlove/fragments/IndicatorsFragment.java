package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grino.catinlove.R;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.Player;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndicatorsFragment
        extends BaseFragment {

    @BindView(R.id.pb_1) ProgressBar pbSatiety;
    @BindView(R.id.pb_2) ProgressBar pbMoon;
    @BindView(R.id.pb_3) ProgressBar pbEnergy;

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
        pbMoon.setProgress(player.getCondition().get(KEY.MOOD));
        pbSatiety.setProgress(player.getCondition().get(KEY.SATIETY));
        pbEnergy.setProgress(player.getCondition().get(KEY.ENERGY));
        tvFood.setText("" + player.getCondition().get(KEY.FOOD));
        tvReal.setText("" + player.getCondition().get(KEY.REAL));
    }

}
