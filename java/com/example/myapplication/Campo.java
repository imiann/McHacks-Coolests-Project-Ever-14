package com.example.myapplication;

import static android.graphics.Typeface.SANS_SERIF;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Formatter;


public class Campo extends AppCompatActivity {
    LinearLayout layout;
    LinearLayout.LayoutParams layoutParam;

    public int dist = 90;

    public String namein = "Brick sammy";
    public String desin = "A brick for the prince! A brick!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campo);
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(StrictMode.getVmPolicy())
                .detectLeakedClosableObjects()
                .build());

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("itemName");
        String itemAvailibility = intent.getStringExtra("itemAvailibility");
        String itemDietary = intent.getStringExtra("itemDietary");

        namein = itemName;
        desin = itemAvailibility;

        TextView v = findViewById(R.id.campoDist);
        v.setText(String.valueOf(dist) + "km");

        if (itemName != null) {
            generateOrder();
        }
    }

    public void openCreateListing(View view) {
        Intent intent = new Intent(this, EditBundle.class);
        startActivity(intent);
    }

    public class Order {
        String name;
        String time;
        String des;

        public Order(String name, String des){
            this.name = name;
            Formatter format = new Formatter();

            // Creating a calendar
            Calendar gfg_calender = Calendar.getInstance();

            // Displaying hour using Format class using  format
            // specifiers
            // '%tl' for hours and '%tM' for minutes
            format = new Formatter();
            format.format("%tl:%tM", gfg_calender, gfg_calender);
            this.time = format.toString();
            this.des = des;
        }
    }


    public void generateOrder() {
        //the layout on which you are working
        LinearLayout layout = (LinearLayout) findViewById(R.id.buttonContainer);

        Order Ord1 = new Order(namein, desin);

        TextView txt = new TextView(this);
        txt.setText(Ord1.name + "  •  " + Ord1.time);

        TextView txt2 = new TextView(this);
        txt2.setText(Ord1.des);


        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(60, 0, 60, 20);
        txt2.setLayoutParams(params);
        params.setMargins(60, 0, 60, 20);
        txt.setLayoutParams(params);

        txt.setTextColor(Color.BLACK);
        txt2.setTextColor(Color.BLACK);

        txt.setTypeface(Typeface.DEFAULT_BOLD);
        txt2.setTypeface(Typeface.DEFAULT_BOLD);

        txt.setTextSize(28);
        txt2.setTextSize(28);


        txt.setTypeface(SANS_SERIF, Typeface.NORMAL);
        txt2.setTypeface(SANS_SERIF, Typeface.NORMAL);



        layout.addView(txt);
        layout.addView(txt2);

        params.setMargins(60, 40, 60, 40);
        //set the properties for button
        Button btnTag = new Button(this);
        btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        btnTag.setText("Claim");

        btnTag.setBackgroundColor(Color.parseColor("#573b96"));
        btnTag.setTextColor(Color.WHITE);

        params.setMargins(60, 40, 60, 40);
        btnTag.setLayoutParams(params);

        //add button to the layout
        layout.addView(btnTag);
        Log.d("Plus","3");

        btnTag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Campo.this, MainActivity.class ));
                String value="232200";
                Intent i = new Intent(Campo.this, MainActivity.class);
                i.putExtra("key",value);
                startActivity(i);

            }
        });
    }
}
