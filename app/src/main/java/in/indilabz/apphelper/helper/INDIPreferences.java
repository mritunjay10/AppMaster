package in.indilabz.apphelper.helper;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.Date;


public class INDIPreferences implements Constants{
private static SharedPreferences getPreferences() {
        return INDIMaster.applicationContext.getSharedPreferences(APP_NAME, Activity.MODE_PRIVATE);
    }

    //// Add following lines to store and retrive boolean

    public static void saveBoolean(boolean b, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putBoolean(key, b);   /// Always change key while creating other funtion to store boolean
        editor.commit();
    }

    public static boolean getBoolean(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getBoolean(key, false);
    }

    //// Add following lines to store and retrive String

    public static void saveString(String value, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(key, value);  /// Always change key while creating other funtion to store string
        editor.commit();
    }

    public static String getString(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getString(key, "");
    }

    //// Add following lines to store and retrive int

    public static void saveInt(int value, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putInt(key, value);  /// Always change key while creating other funtion to store int
        editor.commit();
    }

    public static int getInt(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getInt(key, 0);
    }

    //// Add following lines to store and retrive int

    public static void saveFloat(Float value, String key) {
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putFloat(key, value);  /// Always change key while creating other funtion to store int
        editor.commit();
    }

    public static Float getFloat(String key) {
        SharedPreferences mSharedPreferences = getPreferences();
        return mSharedPreferences.getFloat(key, 0);
    }
}