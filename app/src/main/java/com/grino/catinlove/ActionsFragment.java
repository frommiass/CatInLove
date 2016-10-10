package com.grino.catinlove;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ActionsFragment
        extends Fragment{

    @BindView(R.id.recycler_view) RecyclerView recycler;

    private Unbinder unbinder;
    private List<Action> actions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.action_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        actions = getActions();
        recycler.setAdapter(new ActionRecyclerViewAdapter(actions));


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public List<Action> getActions(){
        actions = new ArrayList<Action>();

        Action action;
        String[] names = getResources().getStringArray(R.array.action_energy);
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
