package com.grino.catinlove.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.grino.catinlove.R;
import com.grino.catinlove.controlers.Player;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.models.Action.SequenceActions;
import com.grino.catinlove.rx.BusActionClick;
import com.grino.catinlove.rx.RxBus;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActionRecyclerViewAdapter
        extends RecyclerView.Adapter<ActionRecyclerViewAdapter.ActionViewHolder>{

    private SequenceActions list;
    private Player cat;
    private Context ctx;
    private RxBus bus;

    public ActionRecyclerViewAdapter(Context ctx, Player cat, SequenceActions list, RxBus bus) {
        this.ctx = ctx;
        this.cat = cat;
        this.list = list;
        this.bus = bus;
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_card, parent, false);
        return new ActionViewHolder(v, bus);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Action action = list.get(position);
        if (cat.satisfies(action.getRequirement().getLevel())){

            Log.d("Grino", "onBindViewHolder");
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
            Picasso.with(ctx)
                    .load(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(holder.icon);
            holder.description.setText("");
            holder.unbind();
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

        private Action action;
        private boolean enabled;
        RxBus bus;

        ActionViewHolder(View view, RxBus bus) {
            super(view);
            ButterKnife.bind(this, view);

            this.bus = bus;
            enabled = false;
        }

        public void bind(Action action){
            this.action = action;
            this.enabled = true;
        }
        public void unbind(){
            enabled = false;
        }

        @OnClick
        public void onClickCard(){
            if (enabled)
                bus.sendObservers(new BusActionClick(action));
        }

    }

}