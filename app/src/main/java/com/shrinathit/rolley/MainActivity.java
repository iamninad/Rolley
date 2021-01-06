package com.shrinathit.rolley;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mpl = MediaPlayer.create(this,R.raw.dice_rolling);
        Button btn = findViewById(R.id.rollBtn);
        Button aboutBtn = findViewById(R.id.aboutBtn);
        LottieAnimationView rollanim = findViewById(R.id.diceAnim);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rollanim.isAnimating()){
                    btn.setText("Roll");
                    mpl.start();
                    rollanim.cancelAnimation();
                }
                else{
                    btn.setText("Stop");
                    rollanim.setSpeed(2);
                    rollanim.playAnimation();
                }

            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

    }
    public void openAbout(){
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
    }
}