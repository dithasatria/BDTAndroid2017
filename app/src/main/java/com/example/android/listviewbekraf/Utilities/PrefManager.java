package com.example.android.listviewbekraf.Utilities;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by DITHA on 28/06/2017.
 */

public class PrefManager {
    public PrefManager() {
    }

    public void saveString(Context context, String key, String value){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(key, value)
                .apply();
    }

    public void  saveBoolean(Context context, String key, boolean value){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(key, value)
                .apply();
    }

    public String getString(Context context, String key){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getString(key, null);
    }

    public boolean getBoolean(Context context, String key){
        return  PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(key, false);
    }
}
