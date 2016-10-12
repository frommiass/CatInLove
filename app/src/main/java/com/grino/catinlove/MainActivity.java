package com.grino.catinlove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.grino.catinlove.models.Player;
import com.grino.catinlove.rx.RxBus;

import butterknife.BindView;


public class MainActivity
        extends AppCompatActivity {

    @BindView(R.id.toolbar)     Toolbar toolbar;

    private RxBus bus = null;
    public RxBus getBus() {
        if (bus == null) bus = new RxBus();
        return bus;
    }

    private Player cat;
    public Player getCat() {
        if (cat == null) cat = new Player(this, "");
        return cat;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        //При первом запуске запросить имя у пользователя
        getCat().setName("Влюбленный кот");
    }



}
