package com.grino.catinlove.tools;

import com.grino.catinlove.enums.SEQUENCE_TYPE;

public class Sequence{

    private SEQUENCE_TYPE type;
    private int a, b;

    public Sequence(SEQUENCE_TYPE type) {
        this.type = type;
        this.a = 0;
        this.b = 1;
    }

    public Sequence(SEQUENCE_TYPE type, int constant) {
        this.type = type;
        this.a = constant;
        this.b = 0;
    }

    public Sequence(SEQUENCE_TYPE type, int a, int b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    public int get(int n) {
        if (SEQUENCE_TYPE.CONSTANT.equals(type))
            return a;
        else if (SEQUENCE_TYPE.NUMBERS.equals(type))
            return n + 1;
        else if (SEQUENCE_TYPE.LINEAR_DEPENDENCE.equals(type))
            return (a + b*n);
        return 0;
    }

}
