package com.example.hp.htask;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    int time_delay = 3000 ;

    ImageView imageView ;
    Animation animation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(SplashActivity.this ,Cources.class);
                startActivity(intent);
            }
        },time_delay);

        imageView = (ImageView)findViewById(R.id.logo);
        animation = AnimationUtils.loadAnimation(this,R.anim.fadein);
        imageView.startAnimation(animation);
    }
}
