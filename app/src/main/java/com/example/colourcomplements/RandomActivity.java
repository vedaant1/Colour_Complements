package com.example.colourcomplements;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


@SuppressLint("Registered")
public class RandomActivity extends AppCompatActivity {

    Button myButton2;
    View myRandomColourView;
    View myResultColourView;
    TextView myRandomColour;
    TextView myInputDescription;
    TextView myOutputDescription;
    TextView myOutputColour;


    Random myRandom;
    int r;
    int g;
    int b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        myButton2 = findViewById(R.id.button2);
        myRandomColourView = findViewById(R.id.randomColourView);
        myResultColourView = findViewById(R.id.resultColourView);
        myRandomColour = findViewById(R.id.randomColour);
        myInputDescription  = findViewById(R.id.inputDescription);
        myOutputColour =  findViewById(R.id.outputColour);
        myOutputDescription = findViewById(R.id.outputDescription);
        myRandom = new Random();

        myRandomColour.setPaintFlags(myRandomColour.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        myOutputColour.setPaintFlags(myOutputColour.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        myButton2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                r = myRandom.nextInt(256);
                g = myRandom.nextInt(256);
                b = myRandom.nextInt(256);

                int myRed = 255 - r;
                int myBlue = 255 - b;
                int myGreen = 255 - g;

                String hexCode = String.format("#ff%02x%02x%02x", myRed, myGreen, myBlue);
                String hex = String.format("#ff%02x%02x%02x", r, g, b);

                myRandomColourView.setBackgroundColor(Color.argb(255, r, g, b));
                myInputDescription.setText(" RGB: " + r + "," + g + "," + b
                        + "\n HEX: " + hex);

                myResultColourView.setBackgroundColor((Color.argb(255, myRed, myGreen, myBlue)));
                myOutputDescription.setText(" RGB: " + myRed + "," + myGreen + "," + myBlue
                        + "\n HEX: " + hexCode);

            }
        });





    }
}
