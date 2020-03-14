package com.example.battirtourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {


    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_splash);

        timer = new Timer();
        timer.schedule (new TimerTask (){
            @Override
            public void run() {
               Intent Intent = new Intent (splash.this, MainActivity.class);
                startActivity (Intent);
                finish ();
            }
        }, 2000);
    }
}