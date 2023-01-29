package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

//import com.example.finalqrencoder.R;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        ImageButton button = findViewById(R.id.campo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUserPage();
            }
        });

        Button button2 = findViewById(R.id.seeBundles);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNearBundles();
            }
        });
    }

    public void openUserPage() {
        Intent intent = new Intent(this, Campo.class);
        startActivity(intent);
    }

    public void openNearBundles() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    /*
    public void openRest(View v){
        Intent i = new Intent(this, Campo.class);
        startActivity(i);
    }
     */
}