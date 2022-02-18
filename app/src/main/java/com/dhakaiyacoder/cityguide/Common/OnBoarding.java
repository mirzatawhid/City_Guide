package com.dhakaiyacoder.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dhakaiyacoder.cityguide.HelperClasses.SliderAdapter;
import com.dhakaiyacoder.cityguide.R;
import com.dhakaiyacoder.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    Button getStartedBTN;
    Animation animation;

    TextView[] dots;

    SliderAdapter sliderAdapter;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.viewPagerID);
        dotsLayout = findViewById(R.id.dots);
        getStartedBTN = findViewById(R.id.get_started_btnID);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    public void next(View view){
        viewPager.setCurrentItem(currentPos+1);
    }

    private void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                addDots(position);
                currentPos=position;
                if (position != 3){
                    getStartedBTN.setVisibility(View.INVISIBLE);
                }else{
                    animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                    getStartedBTN.setVisibility(View.VISIBLE);
                    getStartedBTN.setAnimation(animation);
                    getStartedBTN.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(getApplicationContext(),UserDashboard.class));
                        }
                    });
                }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}