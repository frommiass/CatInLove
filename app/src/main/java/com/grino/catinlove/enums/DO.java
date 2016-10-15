package com.grino.catinlove.enums;


import com.grino.catinlove.R;

import lombok.Getter;

public enum DO {
    PLAY   (R.string.do_play, 2000 + 1, R.array.do_play),
    EAT    (R.string.do_eat, 2000 + 2, R.array.do_eat),
    RELAX  (R.string.do_relax, 2000 + 3, R.array.do_relax),

    HUNT   (R.string.do_hunt, 2000 + 4, R.array.do_hunt),
    CREATE (R.string.do_create, 2000 + 5, R.array.do_create),

    ERROR(R.string.do_error, 2000 + 0, R.array.do_error);

    @Getter      private final int titleID;
    @Getter      private final int key;
    @Getter      private final int stringsID;

    DO(int titleID, int key, int stringsID) {
        this.titleID = titleID;
        this.key = key;
        this.stringsID = stringsID;
    }

    public static DO getDO(int key){
        DO result = DO.ERROR;
        for (DO one: DO.values()) {
            if (one.getKey() == key){
                result = one;
                break;
            }
        }
        return result;
    }


}
