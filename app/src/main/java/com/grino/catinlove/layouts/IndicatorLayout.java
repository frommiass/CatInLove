package com.grino.catinlove.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.grino.catinlove.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IndicatorLayout
        extends LinearLayout {

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
    }
}
