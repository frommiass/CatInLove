package com.grino.catinlove.adapters;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.grino.catinlove.R;
import com.grino.catinlove.controlers.Game;
import com.grino.catinlove.enums.DO;
import com.grino.catinlove.enums.KEY;
import com.grino.catinlove.models.Action.Action;
import com.grino.catinlove.models.Action.KeyInt;
import com.grino.catinlove.models.Action.Project;
import com.grino.catinlove.models.Action.ProjectAction;
import com.grino.catinlove.models.Action.Projects;
import com.grino.catinlove.rxBus.BusActionClick;
import com.grino.catinlove.tools.Px;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.grino.catinlove.R.drawable;
import static com.grino.catinlove.R.id;
import static com.grino.catinlove.R.layout;

;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(layout.action_card, parent, false);
        return new ActionViewHolder(v, game);
    }

    @Override
    public void onBindViewHolder(ActionViewHolder holder, int position) {
        Context ctx = holder.card.getContext();

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

            if (status == Project.STATUS_NOT_ACTIVATE) {
                if (game.getCat().satisfies(action))
                    color = R.color.colorCanActivate;
                else color = R.color.colorNotActivate;
            } else if (status == Project.STATUS_ACTIVATE)
                color = R.color.colorNeedRun;
        }

        holder.icon.setLayoutParams(params);
        holder.description.setText(description);
        holder.count.setText(count);
        holder.pic.setBackgroundColor(ctx.getResources().getColor(color));

        Picasso.with(ctx)
                .load(action.getIconID())
                .into(holder.icon);

        holder.bind(action);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ActionViewHolder extends RecyclerView.ViewHolder {
        @BindView(id.action_card)         CardView card;
        @BindView(id.action_pic)          CoordinatorLayout pic;
        @BindView(id.action_icon)         ImageView icon;
        @BindView(id.action_count)        TextView count;
        @BindView(id.action_name)         TextView name;
        @BindView(id.action_description)  TextView description;

        private ProjectAction action;
        Game game;
        Context ctx;

        ActionViewHolder(View view, Game game) {
            super(view);
            ButterKnife.bind(this, view);

            this.game = game;
            this.ctx = card.getContext();
        }

        public void bind(ProjectAction action){
            this.action = action;
        }

        @OnClick
        public void onClickCard() {
            int status = action.getProject().getStatus();

            Action send = new Action(KEY.class);

            if (game.getCat().satisfies(action)) {
                if (action.isMade())
                    send = action;
                else {
                    if (status == Project.STATUS_ACTIVATE) {
                        YoYo.with(Techniques.Shake).duration(700).playOn(name);
                    } else if (status == Project.STATUS_RUN) {
                        action.getProject().Stop();
                        SuperActivityToast.create(ctx, new Style(), Style.TYPE_STANDARD)
                                .setIconResource(drawable.ic_launcher)
                                .setText("Сломалось! Ищи замену!")
                                .setDuration(Style.DURATION_VERY_SHORT)
                                .setFrame(Style.FRAME_STANDARD)
                                .setColor(ctx.getResources().getColor(R.color.colorAccent))
                                .setAnimations(Style.ANIMATIONS_POP)
                                .show();
                        //game.getBus().sendObservers(new BusMessage("Сломалось! Ищи замену!"));
                    }
                }
                game.getBus().sendObservers(new BusActionClick(send));
            }
            else {
                YoYo.with(Techniques.Flash).duration(700).playOn(pic);
                //game.getBus().sendObservers(new BusMessage(action.getOne().getFailString(ctx)));
                SuperActivityToast.create(card.getContext(), new Style(), Style.TYPE_STANDARD)
                        .setIconResource(drawable.ic_launcher)
                        .setText(action.getOne().getFailString(game.ctx))
                        .setDuration(Style.DURATION_SHORT)
                        .setFrame(Style.FRAME_STANDARD)
                        .setColor(ctx.getResources().getColor(R.color.colorAccent))
                        .setAnimations(Style.ANIMATIONS_POP)
                        .show();

                Log.d("Grino", "000");
/*
                Observable.just("").subscribe(
                        v -> {
                            Log.d("Grino", "111");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.d("Grino", "222");


                            SuperActivityToast.create(card.getContext(), new Style(), Style.TYPE_STANDARD)
                                    .setIconResource(drawable.ic_launcher)
                                    .setText("sdvsdvsdvsdv")
                                    .setDuration(Style.DURATION_SHORT)
                                    .setFrame(Style.FRAME_STANDARD)
                                    .setColor(ctx.getResources().getColor(R.color.colorAccent))
                                    .setAnimations(Style.ANIMATIONS_POP)
                                    .show();

                        });*/
            }

        }

    }

}