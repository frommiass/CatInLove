package com.grino.catinlove.enums;

/**
 * Created by Grino on 13.10.2016.
 */
public enum SEQUENCE_TYPE {
    CONSTANT  (100 + 0),
    NUMBERS   (100 + 1),
    LINEAR_DEPENDENCE (100 + 2);

    private final int type;

    SEQUENCE_TYPE(int type) {
        this.type = type;
    }

    private int type() { return type; }
}
