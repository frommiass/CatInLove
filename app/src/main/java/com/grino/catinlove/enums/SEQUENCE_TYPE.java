package com.grino.catinlove.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SEQUENCE_TYPE {
    CONSTANT  (100 + 0),
    NUMBERS   (100 + 1),
    LINEAR_DEPENDENCE (100 + 2);

    @Getter
    private final int type;
}
