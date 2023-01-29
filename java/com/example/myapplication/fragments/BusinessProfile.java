package com.example.myapplication.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.CalendarActivity;
import com.example.myapplication.QRScanner;
import com.example.myapplication.QRScanner2;
import com.example.myapplication.R;

import java.nio.channels.CancelledKeyException;

public class BusinessProfile extends Fragment {

    Activity context;
    String[] items = {"10:00 - 10:30", "13:00 - 14:00"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_business_profile, container, false);

        autoCompleteTextView = rootView.findViewById(R.id.auto_complete_text);

        adapterItems = new ArrayAdapter<String>(rootView.getContext(), R.layout.list_item, items);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(rootView.getContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    public void onStart() {
        super.onStart();
        Button button = (Button) context.findViewById(R.id.toCalendar);
        Button button2 = (Button) context.findViewById(R.id.QrScan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CalendarActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QRScanner2.class);
                startActivity(intent);
            }
        });
    }
}
