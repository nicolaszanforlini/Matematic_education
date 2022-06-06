package com.example.matematic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.matematic.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment frag = new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frame, frag).commit();

    }
}