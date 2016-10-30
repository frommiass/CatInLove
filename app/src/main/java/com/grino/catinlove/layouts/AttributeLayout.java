package com.grino.catinlove.layouts;

import android.content.Context;
import android.content.res.TypedArray;
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
        initializeViews(context, null);
    }

    public AttributeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context, attrs);
    }

    public AttributeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context, attrs);
    }


    private void initializeViews(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.layout_attribute, this);
        ButterKnife.bind(this, layout);

        if (attrs != null){
            TypedArray att = context.obtainStyledAttributes(attrs, R.styleable.AttributeLayout);
            vName.setText(att.getString(R.styleable.AttributeLayout_att_name));
            vIcon.setImageResource(att.getResourceId(R.styleable.AttributeLayout_att_icon, R.drawable.claws));
        }
    }

    public void setValue(int value){
        vValue.setText(String.valueOf(value));
    }
}
