package com.grino.catinlove.models.Action;

import com.grino.catinlove.enums.KEY;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeySeq {

    private KEY key;
    private Sequence value;
}
