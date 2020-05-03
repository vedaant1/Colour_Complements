package com.example.colourcomplements;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView myImage;
    TextView myDescription;
    TextView myColourComplement;
    TextView myColour;
    View myView;
    View myResultView;



    Bitmap myBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myImage = findViewById(R.id.image);
        myDescription = findViewById(R.id.description);
        myView = findViewById(R.id.view);
        myResultView = findViewById(R.id.resultView);
        myColourComplement = findViewById(R.id.colourComplement);
        myColour = findViewById(R.id.colour);

        myColour.setPaintFlags(myColour.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        myColourComplement.setPaintFlags(myColourComplement.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

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

                    int myRed = 255 - red;
                    int myBlue = 255 - blue;
                    int myGreen = 255 - green;


                    String hexCode = "#" + Integer.toHexString(pixels);
                    
                    myView.setBackgroundColor(Color.rgb(red, green, blue ));
                    myDescription.setText(" RGB: " + red + "," + green + "," + blue
                    + "\n HEX: " + hexCode);
                    myResultView.setBackgroundColor((Color.rgb(myRed, myGreen, myBlue)));

                }
                return true;
            }
        });
    }
}

