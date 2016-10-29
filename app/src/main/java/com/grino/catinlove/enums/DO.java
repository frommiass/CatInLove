package com.grino.catinlove.enums;

import com.grino.catinlove.R;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum DO {
    PLAY   (R.string.do_play, 2000 + 1, R.array.do_play, R.string.do_play_ru, R.string.do_play_activate, R.array.do_play_activate, R.drawable.claws),
    EAT    (R.string.do_eat, 2000 + 2, R.array.do_eat, R.string.do_eat_ru, R.string.do_eat_activate, R.array.do_eat_activate, R.drawable.mustache),
    RELAX  (R.string.do_relax, 2000 + 3, R.array.do_relax, R.string.do_relax_ru, R.string.do_relax_activate, R.array.do_relax_activate, R.drawable.paws),

    HUNT   (R.string.do_hunt, 2000 + 4, R.array.do_hunt, R.string.do_hunt_ru, R.string.do_hunt_activate, R.array.do_hunt_activate, R.drawable.eat),
    CREATE (R.string.do_create, 2000 + 5, R.array.do_create, R.string.do_create_ru, R.string.do_create_activate, R.array.do_create_activate, R.drawable.eat),

    ERROR  (R.string.do_error, 2000 + 0, R.array.do_error, R.string.do_error_ru, R.string.do_error_ru, R.array.do_error, R.drawable.placeholder);

    @Getter      private final int drawableName;
    @Getter      private final int key;
    @Getter      private final int stringsID;
    @Getter      private final int titleID;
    @Getter      private final int activateID;
    @Getter      private final int startID;
    @Getter      private final int iconID;

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

    public static ArrayList<DO> getAll(){
        ArrayList<DO> res = new ArrayList<>();
        res.add(DO.PLAY);
        res.add(DO.EAT);
        res.add(DO.RELAX);
        res.add(DO.HUNT);
        res.add(DO.CREATE);
        return res;
    }

}
