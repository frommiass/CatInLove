package com.grino.catinlove.adapters;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
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
import com.grino.catinlove.models.Action.KeyInt;
import com.grino.catinlove.models.Action.Project;
import com.grino.catinlove.models.Action.ProjectAction;
import com.grino.catinlove.models.Action.Projects;
import com.grino.catinlove.rxBus.BusActionClick;
import com.grino.catinlove.rxBus.BusMessage;
import com.grino.catinlove.tools.Px;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

;

public class ActionRecyclerViewAdapter
        extends RecyclerView.Adapter<ActionRecyclerViewAdapter.ActionViewHolder>{

    Game game;
    Projects list;
    Context ctx;

    public ActionRecyclerViewAdapter(Game game, DO d) {
        this.game = game;
        list = game.getProjectsTable().getProjectsList(d);
        this.ctx = game.ctx;
    }

    @Override
    public ActionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.action_card, parent, false);
        return new ActionViewHolder(v, game);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        ProjectAction action = list.get(position).getAction();
        holder.name.setText(action.getName());

        String description = "";
        String count = "";
        LayoutParams params = (LayoutParams) holder.icon.getLayoutParams();
        int color = R.color.colorWhite;

        int status = action.getProject().getStatus();

        if (status == Project.STATUS_RUN){
            params.setMargins(0, 0, 0, 0);
            KeyInt one = action.getOne();
            if (one != null)
                description = "Увеличивет " + one.getName() + " на " + one.getValInPercent();
            else description = action.toString();
        }else{
            count = action.getOne().getValWithSign();
            params.setMargins(Px.getPx(ctx, 8), Px.getPx(ctx, 8), Px.getPx(ctx, 8), Px.getPx(ctx, 24));
            if(action.getProbability() != 1.0)
                description = "Вероятность успеха " + action.getProbability()*100 + "%";

            if (status == Project.STATUS_NOT_ACTIVATE)
                color = R.color.colorNotActivate;
            else if (status == Project.STATUS_ACTIVATE)
                color = R.color.colorNeedRun;
        }

        holder.icon.setLayoutParams(params);
        holder.description.setText(description);
        holder.count.setText(count);
        holder.pic.setBackgroundColor(ctx.getResources().getColor(color));

        Picasso.with(game.ctx)
                .load(action.getIconID())
                .into(holder.icon);

        holder.bind(action);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.action_card)         CardView card;
        @BindView(R.id.action_pic)          CoordinatorLayout pic;
        @BindView(R.id.action_icon)         ImageView icon;
        @BindView(R.id.action_count)        TextView count;
        @BindView(R.id.action_name)         TextView name;
        @BindView(R.id.action_description)  TextView description;

        private Action action;
        Game game;

        ActionViewHolder(View view, Game game) {
            super(view);
            ButterKnife.bind(this, view);

            this.game = game;
        }

        public void bind(Action action){
            this.action = action;
        }

        @OnClick
        public void onClickCard(){
            if (game.getCat().satisfies(action))
                game.getBus().sendObservers(new BusActionClick(action));
            else
                game.getBus().sendObservers(new BusMessage(action.getOne().getFailString(game.ctx)));
        }

    }

}