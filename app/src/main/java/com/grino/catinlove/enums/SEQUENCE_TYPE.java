package com.grino.catinlove.enums;

/**
 * Created by Grino on 13.10.2016.
 */
public enum SEQUENCE_TYPE {
    NUMBERS   (100 + 1);

    private final int type;

    SEQUENCE_TYPE(int type) {
        this.type = type;
    }

    private int type() { return type; }
}
