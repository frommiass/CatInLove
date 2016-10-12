package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.grino.catinlove.MainActivity;
import com.grino.catinlove.rx.RxBus;

import butterknife.Unbinder;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Grino on 12.10.2016.
 */
public class BaseFragment
        extends Fragment {

    protected RxBus bus;
    protected CompositeSubscription subscriptions;
    protected Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = ((MainActivity) getActivity()).getBus();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        subscriptions.clear();
        Log.d("grino", "отписка");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
