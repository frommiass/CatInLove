package com.grino.catinlove.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grino.catinlove.R;
import com.grino.catinlove.adapters.ActionRecyclerViewAdapter;
import com.grino.catinlove.models.Action;
import com.grino.catinlove.models.Indicators;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionsFragment
        extends BaseFragment{

    @BindView(R.id.recycler_view) RecyclerView recycler;

    private List<Action> actions;
    private int actionsID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        if(getArguments() != null)
            actionsID = getArguments().getInt("actionsID");

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        actions = getActions();
        recycler.setAdapter(new ActionRecyclerViewAdapter(actions));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        subscriptions.add(
                bus.asObservable().subscribe
                        (event -> {if (event instanceof Integer)
                                        {actionsID = (int)event;}
                        }));
    }


    public List<Action> getActions(){
        actions = new ArrayList<Action>();

        Action action;
        String[] names = getResources().getStringArray(actionsID);
        int[] values = getResources().getIntArray(R.array.action_asc);
        for (int i=0; i<names.length; i++){
            action = new Action(getContext(), names[i], false);
            action.set(Indicators.KEY_ENERGY, values[i]);
            action.setExperience(1);
            action.setIconID(R.mipmap.ic_launcher);
            actions.add(action);
        }

        return actions;
    }
}
