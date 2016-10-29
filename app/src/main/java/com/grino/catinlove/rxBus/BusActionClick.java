package com.grino.catinlove.rxBus;

import com.grino.catinlove.models.Action.Action;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BusActionClick
        extends BusEvent{
    private final Action action;
}
