package com.example.galarte_jonty;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.View;

import com.example.galarte_jonty.R;
import com.example.galarte_jonty.ui.login.LoginActivity;


public class SettingsFragment extends PreferenceFragment {



    private static final String PREF_DARK_MODE = "pref_dark_mode";
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);



    }
}


