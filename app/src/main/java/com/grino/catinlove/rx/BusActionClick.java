package com.grino.catinlove.rx;

import com.grino.catinlove.models.Action;

import lombok.Data;

@Data
public class BusActionClick
        extends BusEvent{
    private final Action action;
}
