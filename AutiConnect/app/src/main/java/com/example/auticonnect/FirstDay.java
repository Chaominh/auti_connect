package com.example.auticonnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class FirstDay extends AppCompatActivity implements Animation.AnimationListener{

    ImageView cat;
    Button btnPlay;
    Animation animation;
    MediaPlayer mediaPlayer;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_day);

//        mediaPlayer = MediaPlayer.create(this,R.raw.chaoban);
//        cat = findViewById(R.id.cat);
//        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
//        animation.setAnimationListener(this);
        btnPlay = findViewById(R.id.playBtn);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mediaPlayer.start();
                Intent intent = new Intent(FirstDay.this, SecondDay.class);
                startActivity(intent);
            }
        });

    }

    public void startAnimation(View view){
        // start the animation
        cat.startAnimation(animation);
    }
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
    


}