package com.grino.catinlove.enums;


public enum DO {
    PLAY   (2000 + 1),
    EAT    (2000 + 2),
    RELAX  (2000 + 3),

    HUNT   (2000 + 1),
    CREATE (2000 + 2);

    private final int action;

    DO(int action) {
        this.action = action;
    }

    private int action() { return action; }
}
