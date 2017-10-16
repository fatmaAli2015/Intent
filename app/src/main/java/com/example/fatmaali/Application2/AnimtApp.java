package com.example.fatmaali.Application2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AnimtApp extends AppCompatActivity {
    TextView txtAnimation;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animt_app);
        txtAnimation = (TextView) findViewById(R.id.txt_fade);
    }

    public void btn_fade_in(View view) {
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        txtAnimation.startAnimation(animation);
    }

    public void btn_fade_out(View view) {
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        txtAnimation.startAnimation(animation);
    }

    public void btn_zoom_in(View view) {
         animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
         txtAnimation.startAnimation(animation);
    }

    public void btn_zoom_out(View view) {
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        txtAnimation.startAnimation(animation);
    }

    public void btn_trans(View view) {
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
        txtAnimation.startAnimation(animation);
    }

    public void btn_Rotate(View view) {
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        txtAnimation.startAnimation(animation);
    }

    public void btn_bounce(View view) {
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        txtAnimation.startAnimation(animation);
    }

    public void btn_together(View view) {
        animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.together);
        txtAnimation.startAnimation(animation);
    }
}
