package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grino.catinlove.R;
import com.grino.catinlove.adapters.ActionRecyclerViewAdapter;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.models.Action;
import com.grino.catinlove.models.Indicators;
import com.grino.catinlove.models.SequenceActions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionsFragment
        extends BaseFragment{

    @BindView(R.id.recycler_view) RecyclerView recycler;

    private SequenceActions list;
    private DO key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        if(getArguments() != null)
            key = DO.getDO(getArguments().getInt("do_key"));

        list = getMainActivity().getActions().get(key);

        recycler.setLayoutManager(new LinearLayoutManager(ctx));
        recycler.setAdapter(new ActionRecyclerViewAdapter(list));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
/*
        subscriptions.add(
                bus.asObservable().subscribe
                        (event -> {if (event instanceof Integer)
                                        {actionsID = (int)event;}
                        }));*/
    }
}
