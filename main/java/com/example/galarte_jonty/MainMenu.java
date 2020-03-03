package com.example.galarte_jonty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

public class MainMenu extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    boolean darkMode;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        darkMode = prefs.getBoolean("pref_dark_mode", false);

        if (darkMode) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageButton settingsButton = findViewById(R.id.settingsButton);
        ImageButton takeQuizButton = findViewById(R.id.takeQuizButton);
        ImageButton favouritesButton = findViewById(R.id.favouritesButton);
        SearchView searchBar = findViewById(R.id.searchBar);

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });

        takeQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Quiz");
            }
        });

        favouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Favourites");
            }
        });

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                System.out.println(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });

//        prefs = PreferenceManager.getDefaultSharedPreferences(this);
//
//        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
//            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
//                if (key.equals("pref_dark_mode")) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            setTheme(R.style.DarkTheme);
//                        }
//                    });
//                    recreate();
//                    System.out.println("BOO");
//                }
//            }
//        };
//
//        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void openSettings(){
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

}
