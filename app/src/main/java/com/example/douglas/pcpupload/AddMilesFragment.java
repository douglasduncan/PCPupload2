package com.example.douglas.pcpupload;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class AddMilesFragment extends Fragment {




    public AddMilesFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_miles, container, false);

        Spinner spinnerCarSelector = (Spinner) v.findViewById(R.id.car_selector_spinner);

        File prefsdir = new File(getActivity().getApplicationInfo().dataDir,"shared_prefs");

        if(prefsdir.exists() && prefsdir.isDirectory()){
            String  listofCars[] = prefsdir.list();

            for (int i = 0; i < listofCars.length; i++) {
                //listofCars.set(i, "D");
                listofCars[i]="what";
             Log.i("looping", "looping"+listofCars[i]);
            }


            // Create an ArrayAdapter using the string array and a default spinner layout
           //ArrayAdapter<String> adapter = ArrayAdapter.createFromResource(this,
              //    R.string.listofCars, android.R.layout.simple_spinner_item);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listofCars);
            spinnerCarSelector.setAdapter(arrayAdapter);



            Toast.makeText(getContext(), "aaaaaaaa"+listofCars[0], Toast.LENGTH_SHORT).show();
            Integer itemCount =  listofCars.length;
            Toast.makeText(getContext(), "aaaaaaaa"+listofCars[0]+"--"+itemCount, Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getContext(), "NOOOOOOOOOOOOOOOOOO", Toast.LENGTH_SHORT).show();
        }




        return v;
    }




}
