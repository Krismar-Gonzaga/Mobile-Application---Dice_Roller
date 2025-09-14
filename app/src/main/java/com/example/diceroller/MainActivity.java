package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    ImageView diceImage;
    ImageView diceImage2;
    Button rollButton;
    TextView texttoRoll;
    Random random = new Random();
    RelativeLayout dice1background, dice2background, background;

    List<Integer> colors = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.YELLOW);
        colors.add(Color.CYAN);
        colors.add(Color.MAGENTA);
        colors.add(Color.BLACK);
        colors.add(Color.WHITE);
        colors.add(Color.GRAY);
        colors.add(Color.DKGRAY);
        colors.add(Color.LTGRAY);

        // Add custom colors using RGB or ARGB values
        colors.add(Color.rgb(255, 165, 0)); // Orange
        colors.add(Color.argb(255, 128, 0, 128)); // Purple with full opacity
        colors.add(Color.parseColor("#FF4081")); // Accent color from hex string
        diceImage = (ImageView) findViewById(R.id.diceImage);
        diceImage2 = (ImageView) findViewById(R.id.diceImage2);
        rollButton = (Button) findViewById(R.id.rollButton);
        texttoRoll = (TextView) findViewById(R.id.texttoRoll);

        dice1background = ((RelativeLayout) findViewById(R.id.dice1background));
        dice2background = ((RelativeLayout) findViewById(R.id.dice2background));
        background = ((RelativeLayout) findViewById(R.id.background));

        dice1background.setBackgroundColor(Color.RED);
        dice2background.setBackgroundColor(Color.GREEN);

        rollButton();
    }

    public void rollButton(){
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRollingForTenSeconds();

            }
        });
    }

    public void rollingProcess(){
        int randomizedNumber1 = random.nextInt(6) + 1;
        int randomizedNumber2 = random.nextInt(6) + 1;
        int randomColor = random.nextInt(colors.size());
        dice1background.setBackgroundColor(colors.get(randomColor));
        dice2background.setBackgroundColor(colors.get(randomColor));
        background.setBackgroundColor(colors.get(randomColor));
        setDiceImage(diceImage, randomizedNumber1);
        setDiceImage(diceImage2, randomizedNumber2);
        android.view.animation.Animation shake = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.shake);
        dice2background.startAnimation(shake);
        dice1background.startAnimation(shake);

    }

    private void startRollingForTenSeconds(){
        rollButton.setEnabled(false);
        texttoRoll.setText("Rolling...");
        new CountDownTimer(5000, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                rollingProcess();
            }

            @Override
            public void onFinish() {
                rollingProcess();
                rollButton.setEnabled(true);
                android.view.animation.Animation bounce = android.view.animation.AnimationUtils.loadAnimation(getBaseContext(), R.anim.bounce);
                dice2background.startAnimation(bounce);
                dice1background.startAnimation(bounce);
                background.setBackgroundColor(Color.WHITE);
                texttoRoll.setText("Please top the Button.");
                
            }
        }.start();


    }

    private void setDiceImage(ImageView targetImageView, int number){
        switch (number){
            case 1:
                targetImageView.setImageResource(R.drawable.dice1);
                break;
            case 2:
                targetImageView.setImageResource(R.drawable.dice2);
                break;
            case 3:
                targetImageView.setImageResource(R.drawable.dice3);
                break;
            case 4:
                targetImageView.setImageResource(R.drawable.dice4);
                break;
            case 5:
                targetImageView.setImageResource(R.drawable.dice5);
                break;
            case 6:
                targetImageView.setImageResource(R.drawable.dice6);
                break;
        }
    }
}