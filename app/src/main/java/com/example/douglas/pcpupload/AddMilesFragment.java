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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
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

        final Spinner spinnerCarSelector = (Spinner) v.findViewById(R.id.car_selector_spinner);
        final TextView CurrentMiles = (TextView) v.findViewById(R.id.currentMileage);
        Button addButton = (Button)v.findViewById(R.id.addMilesButton);
        final TextView statusTextview = (TextView)v.findViewById(R.id.status);

        File prefsdir = new File(getActivity().getApplicationInfo().dataDir,"shared_prefs");

        if(prefsdir.exists() && prefsdir.isDirectory()){
            String  listofCars[] = prefsdir.list();

            for (int i = 0; i < listofCars.length; i++) {
                //listofCars.set(i, "D");
                int length = listofCars[i].length( ); // length == whatever
               // listofCars[i]="what";////take off the .xml part of the filename

                String substr= listofCars[i].substring(0,length-4);
                 listofCars[i]=substr;////take off the .xml part of the filename
             Log.i("looping", "looping"+substr);
            }


            // Create an ArrayAdapter using the string array and a default spinner layout
           //ArrayAdapter<String> adapter = ArrayAdapter.createFromResource(this,
              //    R.string.listofCars, android.R.layout.simple_spinner_item);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, listofCars);
            spinnerCarSelector.setAdapter(arrayAdapter);



            //Toast.makeText(getContext(), "aaaaaaaa"+listofCars[0], Toast.LENGTH_SHORT).show();
            Integer itemCount =  listofCars.length;
            //Toast.makeText(getContext(), "aaaaaaaa"+listofCars[0]+"--"+itemCount, Toast.LENGTH_SHORT).show();

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {






                    String var2 = CurrentMiles.getText().toString();/////////the entered miles as STRING
                    int var2_int = Integer.parseInt(var2);//the entered miles as an INTEGER
                    String var1 = spinnerCarSelector.getSelectedItem().toString();////////the selected vehicle

                    /////need to get first_mileage and annual_mileage and first_timestamp from shared preferences
                    Context context = getActivity();
                    SharedPreferences SelectedCar = context.getSharedPreferences(var1, Context.MODE_PRIVATE);//connect securely to "prefs" file
                    String initial_mileage = SelectedCar.getString("first_mileage", "");////first mileage
                    String initial_timestamp = SelectedCar.getString("first_timestamp", "");////first timestamp
                    String annual_mileage = SelectedCar.getString("annual_mileage", "");////annual mileage

                    Toast.makeText(getContext(), "clicked"+var1+var2, Toast.LENGTH_SHORT).show();
                    calculaTor calculate = new calculaTor();/////call the calculaTor class

                   String returned =  calculate.cc(var2_int, var1, initial_timestamp, initial_mileage, annual_mileage, getActivity());//the MILES + vehicle + initial timestamp + initial mileage
                    //Toast.makeText(getContext(), "this is from ccalculate"+returned, Toast.LENGTH_SHORT).show();
                    statusTextview.setText(returned);

                    //////////////////////////////////////////////////////////////use method to save status
                    //calculaTor.saveStatus(getActivity(), "status", 15, var1);


                }
            });

        }
        else{
            Toast.makeText(getContext(), "NOOOOOOOOOOOOOOOOOO", Toast.LENGTH_SHORT).show();
        }




        return v;
    }




}
