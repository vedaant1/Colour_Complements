package com.example.colourcomplements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView myImage;
    TextView myDescription;
    View myView;

    Bitmap myBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = findViewById(R.id.image);
        myDescription = findViewById(R.id.description);
        myView = findViewById(R.id.view);

        myImage.setDrawingCacheEnabled(true);
        myImage.buildDrawingCache(true);

        myImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE ) {
                    myBitmap = myImage.getDrawingCache();

                    int pixels = myBitmap.getPixel((int)event.getX(), (int)event.getY());

                    int red = Color.red(pixels);
                    int green = Color.green(pixels);
                    int blue = Color.blue(pixels);

                    String hexCode = "#" + Integer.toHexString(pixels);

                    myView.setBackgroundColor(Color.rgb(red, green, blue ));
                    myDescription.setText(" RGB: " + red + "," + green + "," + blue
                    + "\n HEX: " + hexCode);
                }
                return true;
            }
        });
    }
}

