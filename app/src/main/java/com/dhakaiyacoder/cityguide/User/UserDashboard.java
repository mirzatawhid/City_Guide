package com.dhakaiyacoder.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.dhakaiyacoder.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.dhakaiyacoder.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.dhakaiyacoder.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    RecyclerView featuredRecycler;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecycler();
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdonald,"McDonald's","saofhesafhehfhfhadsofhafh ihsiphgsipdghipdsghfkahhafh gsdgjipg"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1,"London","saofhesafhehfhfhadsofhafh ihsiphgsipdghipdsghfkahhafh gsdgjipg"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2,"Mexico","saofhesafhehfhfhadsofhafh ihsiphgsipdghipdsghfkahhafh gsdgjipg"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

    }
}