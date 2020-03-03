package com.example.galarte_jonty;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.galarte_jonty.ui.login.LoginActivity;

public class SettingsActivity extends AppCompatActivity {


    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    private SharedPreferences.Editor editor;
    private SharedPreferences prefs;
    boolean darkMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        darkMode = prefs.getBoolean("pref_dark_mode", false);

        if (darkMode) {
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        if(findViewById(R.id.settings) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getFragmentManager().beginTransaction().add(R.id.settingsGrid, new SettingsFragment()).commit();
        }

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();

        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                if (key.equals("pref_dark_mode")) {
                    restart();
                }
            }
        };
        prefs.registerOnSharedPreferenceChangeListener(listener);
    }

    public void restart(){
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
        finish();
    }

    public void backToMainMenu(View view){
        Intent mainMenuIntent = new Intent(this, MainMenu.class);
        startActivity(mainMenuIntent);
    }

    public void goToLogin(View view){
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }

}