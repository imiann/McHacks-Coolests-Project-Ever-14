package com.example.myapplication.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.Campo;
import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateBundle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateBundle extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String[] item = {"Halal", "Vegan", "Vegetarian", "No dietary restrictions"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;

    Activity context;

    public CreateBundle() {
        // Required empty public constructor
    }

    public static CreateBundle newInstance(String param1, String param2) {
        CreateBundle fragment = new CreateBundle();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();

        View rootView = inflater.inflate(R.layout.fragment_create_bundle, container, false);
        autoCompleteTextView = rootView.findViewById(R.id.auto_complete_text2);
        adapterItems = new ArrayAdapter<String>(rootView.getContext(), R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(rootView.getContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        Button button = rootView.findViewById(R.id.addBundle);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserPage();
            }
        });


        // Inflate the layout for this
        return rootView;


    }

    public void openUserPage() {
        TextInputLayout textInputLayout = context.findViewById(R.id.itemName);
        String text = textInputLayout.getEditText().getText().toString();

        TextInputLayout textInputLayout2 = context.findViewById(R.id.itemAvailibility);
        String text2 = textInputLayout2.getEditText().getText().toString();

        TextInputLayout textInputLayout3 = context.findViewById(R.id.itemDietary);
        String text3 = textInputLayout3.getEditText().getText().toString();

        Intent intent = new Intent(context, Campo.class);
        intent.putExtra("itemName", text);
        intent.putExtra("itemAvailibility", text2);
        intent.putExtra("itemDietary", text3);

        Log.d("itemName", text2);

        startActivity(intent);
    }

    public void onStart() {
        super.onStart();
    }
}
