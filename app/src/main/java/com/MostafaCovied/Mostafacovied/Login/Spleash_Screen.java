package com.MostafaCovied.Mostafacovied.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.MostafaCovied.Mostafacovied.Abd_Lab_admin.Lab_amdin_home;
import com.MostafaCovied.Mostafacovied.Activity.Home_Screen;
import com.MostafaCovied.Mostafacovied.Demerdash.Demerdash_Administration;
import com.MostafaCovied.Mostafacovied.Ministry.Health_of_egypt;
import com.MostafaCovied.Mostafacovied.Muradpharmacy.Muradpharmacy;
import com.MostafaCovied.Mostafacovied.R;
import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;

public class Spleash_Screen extends AppCompatActivity {
    Animation top_animtion, bottom_animtion;
    LottieAnimationView lo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spleash__screen);
        top_animtion = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_animtion = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        lo = findViewById(R.id.animation_view);
        lo.setAnimation(top_animtion);


        if (FirebaseAuth.getInstance().getCurrentUser() == null) {

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    startActivity(new Intent(getApplicationContext(), LoginScreen.class));
                    finish();
                }
            });

            thread.start();
        }
        else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("health_of_egypt@gmaill.com")){
            startActivity(new Intent(getApplicationContext(),Health_of_egypt.class));
            finish();
        }
        else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("muradpharmacy@gmaill.com")){
            startActivity(new Intent(getApplicationContext(), Muradpharmacy.class));
            finish();
        }
        else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("abdel_naby@gmaill.com")){
            startActivity(new Intent(getApplicationContext(), Lab_amdin_home.class));
            finish();
        }
        else if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equals("demerdash_administration@gmaill.com")){
            startActivity(new Intent(getApplicationContext(), Demerdash_Administration.class));
            finish();
        }
        else  {
            startActivity(new Intent(getApplicationContext(),Home_Screen.class));
            finish();

        }

    }
}
