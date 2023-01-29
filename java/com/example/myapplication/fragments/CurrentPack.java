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

import com.example.myapplication.QRScanner;
import com.example.myapplication.R;

public class CurrentPack extends Fragment {

    Activity context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_pack, container, false);
    }

    public void onStart() {
        super.onStart();
        Button button = (Button) context.findViewById(R.id.samplemeal);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, QRScanner.class);
                startActivity(intent);
            }
        });
    }

}