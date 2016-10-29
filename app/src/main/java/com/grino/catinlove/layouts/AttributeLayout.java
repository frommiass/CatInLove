package com.grino.catinlove.layouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.grino.catinlove.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttributeLayout
        extends LinearLayout{

    @BindView(R.id.attribute_name)      TextView  vName;
    @BindView(R.id.attribute_value)     TextView  vValue;
    @BindView(R.id.attribute_icon)      ImageView vIcon;

    public AttributeLayout(Context context) {
        super(context);
        initializeViews(context);
    }

    public AttributeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public AttributeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context);
    }


    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_attribute, this);
        ButterKnife.bind(this, layout);
    }

    public void setValue(int value){
        vValue.setText(String.valueOf(value));
    }

    public void setName(String name){
        vName.setText(name);
    }

    public void setIcon(int id){
        vIcon.setImageResource(id);
    }
}
