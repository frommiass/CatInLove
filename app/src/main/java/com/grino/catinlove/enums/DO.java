package com.grino.catinlove.enums;


import com.grino.catinlove.R;

public enum DO {
    PLAY   (R.string.do_play, 2000 + 1, R.array.do_play),
    EAT    (R.string.do_eat, 2000 + 2, R.array.do_eat),
    RELAX  (R.string.do_relax, 2000 + 3, R.array.do_relax),

    HUNT   (R.string.do_hunt, 2000 + 1, R.array.do_hunt),
    CREATE (R.string.do_create, 2000 + 2, R.array.do_create);

    private final int titleID;
    private final int key;
    private final int stringsID;

    DO(int titleID, int key, int stringsID) {
        this.titleID = titleID;
        this.key = key;
        this.stringsID = stringsID;
    }

    public int getTitleID() { return titleID; }
    public int getKey() { return key; }
    public int getStringsID() { return stringsID; }
}
