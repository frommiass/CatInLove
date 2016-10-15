package com.grino.catinlove.models;

import com.grino.catinlove.enums.KEY;

public interface Keyable {

    public int get(KEY key);
    public Integer put(KEY key, Integer value);
}
