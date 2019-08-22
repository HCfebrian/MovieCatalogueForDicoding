package com.example.moviecataloguefordicoding;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.moviecataloguefordicoding.Adapter.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {



    Fragment fragment;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.movie:
                    fragment = new MovieFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_fragment,fragment,getString(R.string.movie))
                            .commit();
                    return true;
                case R.id.tvShow:
                    fragment = new TvShowFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_fragment,fragment,getString(R.string.tv_series))
                            .commit();
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.btnNav);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        if (savedInstanceState == null){
            navigationView.setSelectedItemId(R.id.movie);
        }

//        ViewPager simpleFrameLayout = findViewById(R.id.container_fragment);
//        TabLayout tabLayout = findViewById(R.id.tl_main);
//
//        TabLayout.Tab firstTab = tabLayout.newTab();
//        firstTab.setText("Movie");
//        firstTab.setIcon(R.drawable.movie_tickets);
//        tabLayout.addTab(firstTab);
//        TabLayout.Tab secondTab = tabLayout.newTab();
//        secondTab.setText("TV Show"); // set the Text for the second Tab
//        secondTab.setIcon(R.drawable.live); // set an icon for the second tab
//        tabLayout.addTab(secondTab);


        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.container_fragment);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tl_main);
        tabs.setupWithViewPager(viewPager);





    }
}
