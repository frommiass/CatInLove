package com.grino.catinlove.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grino.catinlove.MyApp;
import com.grino.catinlove.R;
import com.grino.catinlove.models.Action;
import com.grino.catinlove.models.SequenceActions;
import com.grino.catinlove.rx.BusActionClick;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActionRecyclerViewAdapter
        extends RecyclerView.Adapter<ActionRecyclerViewAdapter.ActionViewHolder>{

    private SequenceActions list;

    public ActionRecyclerViewAdapter(SequenceActions list) {
        this.list = list;
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_card, parent, false);
        return new ActionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Action action = list.get(position);
        holder.name.setText(action.getName());
        holder.description.setText(action.toString());
        holder.icon.setImageResource(action.getIconID());
        holder.bind(action);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.action_card)         CardView card;
        @BindView(R.id.action_icon)         ImageView icon;
        @BindView(R.id.action_name)         TextView name;
        @BindView(R.id.action_description)  TextView description;

        Action action;

        ActionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        public void bind(Action action){
            this.action = action;
        }

        @OnClick
        public void onClickCard(){
            MyApp.getBus().sendObservers(new BusActionClick(action));
        }

    }

}