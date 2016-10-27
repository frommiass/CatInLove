package com.grino.catinlove.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.grino.catinlove.MainActivity;
import com.grino.catinlove.MyApp;
import com.grino.catinlove.controlers.Game;
import com.grino.catinlove.controlers.Player;
import com.grino.catinlove.rx.RxBus;

import butterknife.Unbinder;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class BaseFragment
        extends Fragment {

    protected RxBus bus;
    protected Game game;
    protected Player cat;

    protected CompositeSubscription subscriptions;
    protected Unbinder unbinder;

    protected Context ctx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = getContext();
        game = MyApp.getGame();
        bus = game.getBus();
        cat = game.getCat();
        Log.d("Grino", "onCreate Base");
    }

    @Override
    public void onStart() {
        subscriptions = new CompositeSubscription();
        super.onStart();
        Log.d("Grino", "onStart Base");
        subscribeBus();
    }

    @Override
    public void onStop() {
        super.onStop();
        subscriptions.clear();
        Log.d("grino", "отписка onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public MainActivity getMainActivity(){
        return ((MainActivity)getActivity());
    }

    protected void subscribeBus(){
        Observable<Object> obs = bus.asObservable();
        Subscription sub = obs.subscribe(event -> processEvent(event));
        subscriptions.add(sub);
    }

    public void processEvent(Object event){
    }
}
