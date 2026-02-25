package com.example.fragmentsapp;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.tabs.TabLayout;

public class AvtivityTab extends AppCompatActivity {

    TabLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avtivity_tab);

        tableLayout = findViewById(R.id.tabs);

        FragmentManager fragmentManager = getSupportFragmentManager();

        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, new Fragment1()).commit();
                } else if (tab.getPosition() == 1) {
                    fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, new Fragment2()).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}