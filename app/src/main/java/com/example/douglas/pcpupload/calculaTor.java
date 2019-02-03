package com.example.douglas.pcpupload;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class calculaTor {

    public int dd(int varry){

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        Log.i("message", "this is a message");
        int new_varry = varry*4;
        return new_varry;

    }


}
