package com.grino.catinlove.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grino.catinlove.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

public class IndicatorLayout
        extends LinearLayout {

    @Getter
    @BindView(R.id.indicator_name)      TextView    vName;
    @BindView(R.id.indicator_progress)  ProgressBar vProgress;

    public IndicatorLayout(Context context) {
        super(context);
        initializeViews(context, null);
    }

    public IndicatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context, attrs);
    }

    public IndicatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context, attrs);
    }


    private void initializeViews(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_indicator, this);
        ButterKnife.bind(this, layout);

        if (attrs != null){
            TypedArray att = context.obtainStyledAttributes(attrs, R.styleable.IndicatorLayout);
            vName.setText(att.getString(R.styleable.IndicatorLayout_ind_name));
        }
    }

    public void setProgress(int value){
        vProgress.setProgress(value);

        int colorStart = R.color.colorWhite;

             if ((value >= 0)  & (value <= 200))    colorStart = R.color.colorInt1;
        else if ((value > 200) & (value <= 400))    colorStart = R.color.colorInt2;
        else if ((value > 400) & (value <= 600))    colorStart = R.color.colorInt3;
        else if ((value > 600) & (value <= 800))    colorStart = R.color.colorInt4;
        else if ((value > 800) & (value <= 1000))   colorStart = R.color.colorInt5;

        vProgress.getProgressDrawable().setColorFilter(getResources().getColor(colorStart), PorterDuff.Mode.SCREEN);
    }

}
