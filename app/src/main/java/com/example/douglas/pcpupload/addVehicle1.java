package com.example.douglas.pcpupload;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class addVehicle1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle1);

        /////create shared preferences to be logged in.
        SharedPreferences.Editor editor = getSharedPreferences("InitialPrefs", MODE_PRIVATE).edit();
        Log.w("preferences", "setting up shared prefs");
        String username = "testing username";
        editor.putString("username", username);
        Toast.makeText(this, "shared prefs created", Toast.LENGTH_SHORT).show();
        editor.apply();


    }
}
