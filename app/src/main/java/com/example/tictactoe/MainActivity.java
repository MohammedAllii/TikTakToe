package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private final List<int[]> combinationsList = new ArrayList<>();

    private static int [] boxPositions = {0,0,0,0,0,0,0,0,0};
    private static int playerTurn = 1;
    private static int totalSelectedBoxes = 1;
    private  LinearLayout playeroneLayout,playertwoLayout;
    public  TextView playerone,playertwo;
    public static int player1=0;
    public static int player2=0;
    public static int draw=0;
    private static ImageView image1;
    private static ImageView image2;
    private static ImageView image3;
    private static ImageView image4;
    private static ImageView image5;
    private static ImageView image6;
    private static ImageView image7;
    private static ImageView image8;
    private static ImageView image9;
    private static ImageView imagePlayer1,imagePlayer2;
    public static TextView play1;
    public static TextView play2;
    public static TextView drawplay;
    public static Button reset,change;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         playerone = findViewById(R.id.playerOneName);
         playertwo = findViewById(R.id.playerTwoName);

        imagePlayer1 = findViewById(R.id.imagePlayer1);
        imagePlayer2 = findViewById(R.id.imagePlayer2);

          playeroneLayout = findViewById(R.id.playerOneLayout);
          playertwoLayout = findViewById(R.id.playerTwoLayout);

         play1 = findViewById(R.id.playerOne);
         play2 = findViewById(R.id.playerTwo);
        drawplay = findViewById(R.id.draw);

        reset = findViewById(R.id.restart);
        change = findViewById(R.id.changePlayer);

         image1 = findViewById(R.id.image1);
         image2 = findViewById(R.id.image2);
         image3 = findViewById(R.id.image3);
         image4 = findViewById(R.id.image4);
         image5 = findViewById(R.id.image5);
         image6 = findViewById(R.id.image6);
         image7 = findViewById(R.id.image7);
         image8 = findViewById(R.id.image8);
         image9 = findViewById(R.id.image9);

         combinationsList.add(new int[]{0,1,2});
        combinationsList.add(new int[]{3,4,5});
        combinationsList.add(new int[]{6,7,8});
        combinationsList.add(new int[]{0,3,6});
        combinationsList.add(new int[]{1,4,7});
        combinationsList.add(new int[]{2,5,8});
        combinationsList.add(new int[]{2,4,6});
        combinationsList.add(new int[]{0,4,8});

        final String getPlayerOneName = getIntent().getStringExtra("playerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerone.setText(getPlayerOneName);
        playertwo.setText(getPlayerTwoName);
        //animation
        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setRepeatMode(Animation.RESTART);
        imagePlayer1.startAnimation(rotate);
        imagePlayer2.startAnimation(rotate);




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetDialog myDialog = new ResetDialog(MainActivity.this,MainActivity.this);
                myDialog.show();
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1=0;
                player2=0;
                draw =0 ;
                Intent i = new Intent(MainActivity.this,AddPlayers.class);
                startActivity(i);
            }
        });

         playeroneLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });

         playertwoLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });

         image1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(isBoxSelectable(0)){
                     performAction((ImageView)view,0);

                 }

             }
         });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    performAction((ImageView)view,1 );

                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    performAction((ImageView)view,2 );
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                    performAction((ImageView)view,3 );
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    performAction((ImageView)view,4 );
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    performAction((ImageView)view,5 );
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView)view,6 );
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    performAction((ImageView)view,7 );
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    performAction((ImageView)view,8 );
                }
            }
        });
    }

    private void performAction(ImageView imageView,int selectedBoxPosition){

        Animation rotate = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageView.startAnimation(rotate);

        boxPositions[selectedBoxPosition] = playerTurn;
        if(playerTurn ==1){
            imageView.setImageResource(R.drawable.cross);
            if(checkPlayerWin()){
                WinDialog winDialog = new WinDialog(MainActivity.this,playerone.getText().toString()+" HAS WON !",MainActivity.this);
                winDialog.setCancelable(false);
                winDialog.show();
                player1++;

            }
            else if(totalSelectedBoxes == 9){
                DrawDialog drawDialog = new DrawDialog(MainActivity.this,"it is a draw !",MainActivity.this);
                drawDialog.setCancelable(false);
                drawDialog.show();
                draw++;
            }else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.zero);
            if(checkPlayerWin()){
                WinODialog winODialog = new WinODialog(MainActivity.this,playertwo.getText().toString()+" HAS WON !",MainActivity.this);
                winODialog.setCancelable(false);
                winODialog.show();
                player2++;

            }else if(selectedBoxPosition == 9){
                DrawDialog drawDialog = new DrawDialog(MainActivity.this,"it is a draw !",MainActivity.this);
                drawDialog.setCancelable(false);
                drawDialog.show();
                draw++;
            }else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
        String pl1= String.valueOf(player1);
        String pl2=String.valueOf(player2);
        String dr=String.valueOf(draw);
        play1.setText(pl1);
        play2.setText(pl2);
        drawplay.setText(dr);

        
    }



    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn == 1){
            playeroneLayout.setBackgroundResource(R.drawable.round_back_line_border);
            playertwoLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }else {
            playertwoLayout.setBackgroundResource(R.drawable.round_back_line_border);
            playeroneLayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
    }

    private boolean checkPlayerWin(){
        boolean response = false;
        for(int i=0;i<combinationsList.size();i++){
            final int [] combination = combinationsList.get(i);
            if(boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn ){
                response = true;

            }
        }
        return response;
    }
    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition] ==0){
            response = true;
        }
        return  response;
    }

    public static void restartMatch(){
        player1=0;
        player2=0;
        draw=0;
        play1.setText("0");
        play2.setText("0");
        drawplay.setText("0");
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;
        image1.setImageResource(R.drawable.transparent);
        image2.setImageResource(R.drawable.transparent);
        image3.setImageResource(R.drawable.transparent);
        image4.setImageResource(R.drawable.transparent);
        image5.setImageResource(R.drawable.transparent);
        image6.setImageResource(R.drawable.transparent);
        image7.setImageResource(R.drawable.transparent);
        image8.setImageResource(R.drawable.transparent);
        image9.setImageResource(R.drawable.transparent);
    }
    public static void continueMatch(){
        boxPositions = new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn = 1;
        totalSelectedBoxes = 1;
        image1.setImageResource(R.drawable.transparent);
        image2.setImageResource(R.drawable.transparent);
        image3.setImageResource(R.drawable.transparent);
        image4.setImageResource(R.drawable.transparent);
        image5.setImageResource(R.drawable.transparent);
        image6.setImageResource(R.drawable.transparent);
        image7.setImageResource(R.drawable.transparent);
        image8.setImageResource(R.drawable.transparent);
        image9.setImageResource(R.drawable.transparent);
    }
}