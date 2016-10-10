package com.grino.catinlove;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActionRecyclerViewAdapter
        extends RecyclerView.Adapter<ActionRecyclerViewAdapter.ActionViewHolder>{

    private List<Action> actions;

    public ActionRecyclerViewAdapter(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_card, parent, false);
        return new ActionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        holder.name.setText(actions.get(position).getName());
        holder.description.setText(actions.get(position).toString());
        holder.icon.setImageResource(actions.get(position).getIconID());
    }

    @Override
    public int getItemCount() {
        return actions.size();
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.action_card)         CardView card;
        @BindView(R.id.action_icon)         ImageView icon;
        @BindView(R.id.action_name)         TextView name;
        @BindView(R.id.action_description)  TextView description;

        ActionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}