package com.grino.catinlove.enums;

import lombok.Getter;

public enum KEY {

        EXP   (100 + 1),

        SATIETY (1000 + 1),
        MOOD    (1000 + 2),
        ENERGY  (1000 + 3),

        FOOD   (2000 + 1),
        REAL   (2000 + 2);

        @Getter
        private final int key;

        KEY(int key) {
            this.key = key;
        }
}
