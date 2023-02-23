package com.example.superquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.superquiz.ui.WelcomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, WelcomeFragment.newInstance())
                    .commitNow();
        }
    }
}