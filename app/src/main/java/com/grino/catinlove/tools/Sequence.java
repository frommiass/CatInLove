package com.grino.catinlove.tools;

import com.grino.catinlove.enums.SEQUENCE_TYPE;

public class Sequence{

    private SEQUENCE_TYPE type;

    public Sequence(SEQUENCE_TYPE type) {
        this.type = type;
    }

    public int get(int n) {
        if (SEQUENCE_TYPE.NUMBERS.equals(type))
            return n;
        return n;
    }

}
