package com.grino.catinlove.rxBus;

import com.grino.catinlove.models.Action.Action;

import lombok.Data;

@Data
public class BusActionClick
        extends BusEvent{
    private final Action action;
}
