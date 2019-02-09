package com.example.douglas.pcpupload;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class addVehicleFragment2 extends Fragment {





    public addVehicleFragment2() {
        // Required empty public constructor
    }

    private TextView mselectDate;
    private DatePickerDialog.OnDateSetListener mdateSetListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View v = inflater.inflate(R.layout.fragment_add_vehicle2, container, false);

       //////////////////////////////////////////////////////////////////////////////////////////////////create spinners DAY
        Spinner spinner_day = (Spinner)v.findViewById(R.id.spinnerDay);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_day = ArrayAdapter.createFromResource(getContext(),
                R.array.days_array, android.R.layout.simple_selectable_list_item);
// Specify the layout to use when the list of choices appears
        adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_day.setAdapter(adapter_day);

        /////////////////////////////////////////////////////////////////////////////////////////create spinners MONTH
        Spinner spinner_month = (Spinner)v.findViewById(R.id.spinnerMonth);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_month = ArrayAdapter.createFromResource(getContext(),
                R.array.months_array, android.R.layout.simple_selectable_list_item);
// Specify the layout to use when the list of choices appears
        adapter_month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_month.setAdapter(adapter_month);

        /////////////////////////////////////////////////////////////////////////////////////////create spinners YEARS
        Spinner spinner_year = (Spinner)v.findViewById(R.id.spinnerYear);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter_year = ArrayAdapter.createFromResource(getContext(),
                R.array.years_array, android.R.layout.simple_selectable_list_item);
// Specify the layout to use when the list of choices appears
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner_year.setAdapter(adapter_year);

        //////////////////////////////////////////////////////////////////////////////////////////////////////



Button submitter = (Button) v.findViewById(R.id.SubmitButton);
final TextView  findvehiclename = (TextView)v.findViewById(R.id.enterVehicleName);
final TextView finddatebought = (TextView)v.findViewById(R.id.textSelectDate);
submitter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "clicked submit", Toast.LENGTH_SHORT).show();


    }
});

       return v;
    }





}
