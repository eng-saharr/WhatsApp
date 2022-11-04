package com.example.mya.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mya.R;
import com.example.mya.ui.adapter.MainViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 mainViewpager;
    private MainViewPagerAdapter viewPagerAdapter;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
    }




        private void initViewPager(){
        viewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager(),
                this.getLifecycle(),4);
        mainViewpager=findViewById(R.id.view_pager);
        mainViewpager.setAdapter(viewPagerAdapter);
        tabLayout=findViewById(R.id.tab_layout);
        tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



     mainViewpager.registerOnPageChangeCallback(onPageChangeCallback);
    }


     private ViewPager2.OnPageChangeCallback onPageChangeCallback=new ViewPager2.OnPageChangeCallback() {
         @Override
         public void onPageSelected(int position) {
             super.onPageSelected(position);
             tabLayout.selectTab(tabLayout.getTabAt(position));
         }
     };



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewpager.unregisterOnPageChangeCallback(onPageChangeCallback);
    }




}