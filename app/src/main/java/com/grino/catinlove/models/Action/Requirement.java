package com.grino.catinlove.models.Action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Requirement {

    private int level;

    @Override
    public String toString() {
        return "Требуется " +
                level + " уровень" +
                '!';
    }
}
