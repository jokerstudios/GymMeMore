package com.dhbw.lh.Controler;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;

/**
 * Created by niewierra on 22.03.2016.
 */
public class ImageHelper{

    //region TIMER
    public void setCurrentBackgroundID(int id,Context context){
        SharedPreferences.Editor editor = context.getSharedPreferences("example.com.gymmemore", Context.MODE_PRIVATE).edit();
        editor.putInt("timer",id);
        editor.apply();
    }
    public int getCurrentBackgroundID(Context context){
        SharedPreferences prefs = context.getSharedPreferences("example.com.gymmemore", Context.MODE_PRIVATE);
        return prefs.getInt("timer",0);
    }
    //endregion

}
