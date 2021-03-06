
package com.example.scrathandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button playerOne, playerTwo;
    private ImageView firstImage, secondImage;
    private TextView winnerText;
    int scoreOne, scoreTwo = 0;

    final int[] diceArray = {
            0,
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("WEW");
        playerOne = findViewById(R.id.player1);
        playerTwo = findViewById(R.id.player2);
        firstImage = findViewById(R.id.firstDice);
        secondImage = findViewById(R.id.SecondDice);
        winnerText = findViewById(R.id.winner);


        playerOne.setOnClickListener(v -> {
            winnerText.setText("");
            scoreOne = getRandomNumber();
            firstImage.setImageResource(diceArray[scoreOne]);
            getWinner();
            playerOne.setEnabled(false);

        });

        playerTwo.setOnClickListener(v -> {
            winnerText.setText("");
            scoreTwo = getRandomNumber();
            secondImage.setImageResource(diceArray[scoreTwo]);
            getWinner();
            playerTwo.setEnabled(false);
        });

    }


    public int getRandomNumber(){
        Random random = new Random();
        int randomNumber = random.nextInt(6-1)+1;
        return randomNumber;
    }


    public void getWinner() {
        System.out.println(scoreOne +" | " + scoreTwo);
        if (scoreOne == 0 || scoreTwo == 0){
            winnerText.setText("");
            return;
        }else if(scoreOne == scoreTwo){
            winnerText.setText(R.string.draw);
        }else if(scoreOne > scoreTwo){
            winnerText.setText(R.string.winnerOne);
        }else {
            winnerText.setText(R.string.winnerTwo);
        }
        MediaPlayer mp = MediaPlayer.create(this, R.raw.win_sound);
        mp.start();
        restartDelay();

    }

    public void restartAll(){
        scoreOne = 0;
        scoreTwo = 0;
        firstImage.setImageResource(R.drawable.dice);
        secondImage.setImageResource(R.drawable.dice);
        winnerText.setText("");
        playerTwo.setEnabled(true);
        playerOne.setEnabled(true);
    }

    public void restartDelay() {
        new Thread(() -> {
            SystemClock.sleep(1500);
            runOnUiThread(() -> {
                restartAll();
            });
        }).start();
    }



}






