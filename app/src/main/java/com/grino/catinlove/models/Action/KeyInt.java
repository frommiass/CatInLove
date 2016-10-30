package com.grino.catinlove.models.Action;


import android.content.Context;

import com.grino.catinlove.enums.KEY;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyInt {

    private KEY key;
    private int val;

    public String getValWithSign(){
        if (val > 0)  return "+" + val;
        else return "" + val;
    }

    public String getValInPercent(){
        return (val / 10) + "%";
    }

    public String getName(){
        return key.getName();
    }

    public String getFailString(Context ctx){
        return ctx.getString(key.getFailStringID());
    }

}
