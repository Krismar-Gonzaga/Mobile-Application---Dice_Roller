package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView diceImage;
    Button rollButton;
    TextView texttoRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        diceImage = (ImageView) findViewById(R.id.diceImage);
        rollButton = (Button) findViewById(R.id.rollButton);
        texttoRoll = (TextView) findViewById(R.id.texttoRoll);
        rollButton();
    }

    public void rollButton(){
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollingProcess();
                texttoRoll.setText("Please top the Button.");
            }
        });
    }

    public void rollingProcess(){
        texttoRoll.setText("");
        Random rand = new Random();
        int randomizedNumber = rand.nextInt(6) + 1;
        switch (randomizedNumber){
            case 1:
                diceImage.setImageResource(R.drawable.dice1);
                break;
            case 2:
                diceImage.setImageResource(R.drawable.dice2);
                break;
            case 3:
                diceImage.setImageResource(R.drawable.dice3);
                break;
            case 4:
                diceImage.setImageResource(R.drawable.dice4);
                break;
            case 5:
                diceImage.setImageResource(R.drawable.dice5);
                break;
            case 6:
                diceImage.setImageResource(R.drawable.dice6);
                break;

        }
    }
}