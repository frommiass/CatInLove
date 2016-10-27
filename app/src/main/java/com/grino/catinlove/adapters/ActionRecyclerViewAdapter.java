package com.grino.catinlove.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grino.catinlove.R;
import com.grino.catinlove.controlers.Game;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.models.Action.Projects;
import com.grino.catinlove.rxBus.BusActionClick;
import com.grino.catinlove.rxBus.RxBus;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActionRecyclerViewAdapter
        extends RecyclerView.Adapter<ActionRecyclerViewAdapter.ActionViewHolder>{

    Game game;
    Projects list;

    public ActionRecyclerViewAdapter(Game game, DO d) {
        this.game = game;
        list = game.getProjectsTable().getProjectsList(d);
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_card, parent, false);
        return new ActionViewHolder(v, game.getBus());
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Action action = list.get(position).getAction();
        holder.name.setText(action.getName());
        holder.description.setText(action.toString());
        Picasso.with(game.ctx)
                .load(action.getIconID())
                .placeholder(R.drawable.placeholder)
                .into(holder.icon);
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

        private Action action;
        RxBus bus;

        ActionViewHolder(View view, RxBus bus) {
            super(view);
            ButterKnife.bind(this, view);

            this.bus = bus;
        }

        public void bind(Action action){
            this.action = action;
        }

        @OnClick
        public void onClickCard(){
            bus.sendObservers(new BusActionClick(action));
        }

    }

}