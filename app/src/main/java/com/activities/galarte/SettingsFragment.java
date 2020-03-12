package com.activities.galarte;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.View;

import com.activities.galarte.R;
import com.activities.galarte.ui.login.LoginActivity;


public class SettingsFragment extends PreferenceFragment {



    private static final String PREF_DARK_MODE = "pref_dark_mode";
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    private SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String username = prefs.getString("username", "");
        String defaultLocation = prefs.getString("default_location", "");
        String region = prefs.getString("Region", "");

        super.onCreate(savedInstanceState);

        if (username.equals("")){
            addPreferencesFromResource(R.xml.preferences);
        } else {
            addPreferencesFromResource(R.xml.preferences_logged_in);

            Preference accountName = findPreference("Logout");
            accountName.setSummary(username);
        }

        EditTextPreference defaultLocationPreference = (EditTextPreference) findPreference("default_location");
        defaultLocationPreference.setSummary(defaultLocation);

        ListPreference regionPreference = (ListPreference) findPreference("Region");
        regionPreference.setSummary(region);

    }
}


