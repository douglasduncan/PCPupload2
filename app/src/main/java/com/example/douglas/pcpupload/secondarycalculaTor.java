package com.example.douglas.pcpupload;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class secondarycalculaTor {


    public String cc_Secondary(String[] listofcars, Context context ){///////need to pass the selected car to this method

Log.i("second calculator", "this is second calculator");

double total_status =0.00;
        long tsLong = System.currentTimeMillis()/1000;////current timestamp as a long
        int tsInteger = (int) tsLong;////current timestamp as an integer

        for (int i = 0; i < listofcars.length; i++) {
Log.i("loop", ""+i+" "+listofcars[i]);

            SharedPreferences SelectedCar = context.getSharedPreferences(listofcars[i], Context.MODE_PRIVATE);//connect securely to "prefs" file
            String status = SelectedCar.getString("status", "");
            //float floatI = Float.parseFloat(status);
            double doubleI = Double.parseDouble(status);
            Log.i("statuss", ""+status+" "+doubleI);
            total_status = total_status+doubleI;
        }

        return "overall calculator return"+listofcars.length+" "+listofcars[(listofcars.length)-1]+"--"+total_status;


    }
}
