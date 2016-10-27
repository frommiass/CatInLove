package com.grino.catinlove.rxBus;

import com.jakewharton.rxrelay.PublishRelay;
import com.jakewharton.rxrelay.Relay;

import rx.Observable;

public class RxBus {

    private final Relay<Object, Object> _bus = PublishRelay.create().toSerialized();

    public void send(Object o) {
        _bus.call(o);
    }

    public Observable<Object> asObservable() {
        return _bus.asObservable();
    }

    public boolean hasObservers() {
        return _bus.hasObservers();
    }

    public void sendObservers(Object o) {
        if (hasObservers()) send(o);
    }

}