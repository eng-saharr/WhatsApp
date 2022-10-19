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


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

        private void initViewPager(){
        viewPagerAdapter=new MainViewPagerAdapter(getSupportFragmentManager(),
                this.getLifecycle(),3);
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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.group_btn){
            Toast.makeText(this,"new group",Toast.LENGTH_SHORT).show();

        }else if(item.getItemId()==R.id.new_btn) {
            Toast.makeText(this, "new broadcast", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.linked_btn) {
            Toast.makeText(this, "linked devices", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.starred_message_btn) {
            Toast.makeText(this, "start messsage", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==R.id.setting_btn) {
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }



}