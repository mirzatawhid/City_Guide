package com.dhakaiyacoder.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhakaiyacoder.cityguide.R;
import com.dhakaiyacoder.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER=5000;

    //variable
    ImageView backgroundImage;
    TextView poweredbyText;

    Animation sideAnim,bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //hooks
        backgroundImage = findViewById(R.id.background_imageID);
        poweredbyText = findViewById(R.id.powered_byID);

        //animation
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //set animation to elements
        backgroundImage.setAnimation(sideAnim);
        poweredbyText.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);

    }
}