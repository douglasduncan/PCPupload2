package com.example.douglas.pcpupload;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class calculaTor {


    public int dd(int varry){/////a testing method

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.i("message", "this is a message");
        int new_varry = varry*4;
        return new_varry;

    }
//////////////////////////////////////////////////////////
public String cc(int var2, String var1, String InitialTimestamp, String InitialMileage, String AnnualMileage, Context context ){///////calculate method var2 is miles, var1 is car

        long tsLong = System.currentTimeMillis()/1000;////current timestamp as a long
        int tsInteger = (int) tsLong;////current timestamp as an integer

        int tsInitialInt = Integer.parseInt(InitialTimestamp);//initial timestamp as integer
        int miles_per_year_int = Integer.parseInt(AnnualMileage);//annual mileage as integer
        int initialmileage = Integer.parseInt(InitialMileage);
        int timeframe = tsInteger-tsInitialInt;
        double milesPerSecond = miles_per_year_int/(365.25*24*60*60);
        double AllowedMilesinTimeframe = milesPerSecond*timeframe;
        double Allowed = AllowedMilesinTimeframe+initialmileage;
        double Status = var2-Allowed;

///////////////////////////////////////////////////////////////////////////////////////////update the shared preferences file
    SharedPreferences sharedPref = context.getSharedPreferences(var1, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("status", Double.toString(Status));
    editor.commit();
    Log.i("ddstatus", "saved status");



    return "timestamp"+tsInteger+"\ninitial timestamp"+tsInitialInt+"\ntimeframe"+timeframe+"\nallowed miles in timeframe"+AllowedMilesinTimeframe+"\nallowed"+Allowed+"\nstatus"+Status;
}
////////////////////////////////////////////////////////////////////////////////////////method to save status
    public static void saveStatus(Context context, String key, int value, String vehicle) {
        SharedPreferences sharedPref = context.getSharedPreferences(vehicle, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
        Log.i("ddstatus", "saved status");
    }
}
