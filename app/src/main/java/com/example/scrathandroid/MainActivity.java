
package com.example.scrathandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button player1, player2, startBtn;
    private ImageView firstImage, secondImage;
    private TextView winnerText;

    final int[] diceArray = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };
    int scoreOne, scoreTwo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("WEW");
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        firstImage = findViewById(R.id.firstDice);
        secondImage = findViewById(R.id.SecondDice);
        winnerText = findViewById(R.id.winner);
        startBtn = findViewById(R.id.startBtn);



        player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                winnerText.setText("");
                Random rng1ST = new Random();
                int randonNum1 = rng1ST.nextInt(6);
                scoreOne = randonNum1;
                firstImage.setImageResource(diceArray[randonNum1]);
                getWinnerText(scoreOne,scoreTwo);
            }
        });
        player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rng2ND = new Random();
                int randonNum2 = rng2ND.nextInt(6);
                scoreTwo = randonNum2;
                secondImage.setImageResource(diceArray[randonNum2]);
                getWinnerText(scoreOne,scoreTwo);
            }
        });
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               winnerText.setText("");
               firstImage.setImageResource(R.drawable.dice);
               secondImage.setImageResource(R.drawable.dice);
                scoreOne = 0;
                scoreTwo = 0;
            }
        });

    }

    public void getWinnerText(int scoreOne, int scoreTwo){
        if (scoreOne > scoreTwo) {
            winnerText.setText(R.string.winnerOne);
        } else if (scoreTwo > scoreOne) {
            winnerText.setText(R.string.winnerTwo);
        } else  if(scoreOne == 1 || scoreTwo == 1){

        }else if (scoreOne == scoreTwo){
            winnerText.setText("Draw");
        }
    }


}