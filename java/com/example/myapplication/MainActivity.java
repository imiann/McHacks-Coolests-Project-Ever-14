package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    EditText edit_input;
    Button bt_generate;
    ImageView iv_qr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*edit_input = findViewById(R.id.edit_input);*/
        bt_generate = findViewById(R.id.bt_generate);
        iv_qr = findViewById(R.id.iv_qr);

        bt_generate.setOnClickListener(v-> generateQR());
    }

    private void generateQR() {

        Bundle extras = getIntent().getExtras();
        String value = null;
        if (extras != null) {
            value = extras.getString("key");
            //The key argument here must match that used in the other activity
        }
        String code = value; /* Enter here what the code is for qr code*/
        String text = code/*edit_input.getText().toString().trim()*/;
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, 400, 400);
            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            iv_qr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
    public void launchScanner(View v){
        Intent i = new Intent(this, QRScanner2.class);
        startActivity(i);
    }

}

