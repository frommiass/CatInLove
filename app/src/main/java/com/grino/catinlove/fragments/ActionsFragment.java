package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grino.catinlove.R;
import com.grino.catinlove.adapters.ActionRecyclerViewAdapter;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.models.Action.SequenceActions;
import com.grino.catinlove.rx.BusUpdatePlayer;

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

        list = actions.get(key);

        recycler.setLayoutManager(new LinearLayoutManager(ctx));
        recycler.setAdapter(new ActionRecyclerViewAdapter(ctx, cat, list, bus));

        return view;
    }

    @Override
    public void processEvent(Object event) {
        Log.d("Grino", "update Actions");
        if (event instanceof BusUpdatePlayer) {
            Log.d("Grino", "update Actions -notifyDataSetChanged");
            recycler.getAdapter().notifyDataSetChanged();
        }
    }

}
