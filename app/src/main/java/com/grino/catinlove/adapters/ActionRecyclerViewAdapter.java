package com.grino.catinlove.adapters;

import android.content.Context;
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
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActionRecyclerViewAdapter
        extends RecyclerView.Adapter<ActionRecyclerViewAdapter.ActionViewHolder>{

    private SequenceActions list;
    private Context ctx;

    public ActionRecyclerViewAdapter(Context ctx, SequenceActions list) {
        this.ctx = ctx;
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
        if (MyApp.getCat().satisfies(action.getRequirement().getLevel())){
            holder.name.setText(action.getName());
            holder.description.setText(action.toString());
            Picasso.with(ctx)
                    .load(action.getIconID())
                    .placeholder(R.drawable.placeholder)
                    .into(holder.icon);
            holder.bind(action);
        }
        else{
            holder.name.setText(action.getRequirement().toString());
        }
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
        boolean enabled;

        ActionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

            enabled = false;

        }

        public void bind(Action action){
            this.action = action;
            this.enabled = true;
        }

        @OnClick
        public void onClickCard(){
            if (enabled)
                MyApp.getBus().sendObservers(new BusActionClick(action));
        }

    }

}