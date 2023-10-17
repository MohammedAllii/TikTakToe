package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);
        final EditText playerone = findViewById(R.id.palyerOne);
        final EditText playertwo = findViewById(R.id.playerTwo);
        final Button startButton = findViewById(R.id.buttonStart);
        TextView playerNames = findViewById(R.id.playersName);
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 1.0f, // fromXDelta
                Animation.RELATIVE_TO_PARENT, -1.0f, // toXDelta
                Animation.RELATIVE_TO_PARENT, 0f, // fromYDelta
                Animation.RELATIVE_TO_PARENT, 0f // toYDelta
        );
        animation.setDuration(5000); // 5 seconds
        animation.setRepeatCount(Animation.INFINITE); // repeat indefinitely
        animation.setRepeatMode(Animation.REVERSE); // reverse the animation
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.RESTART);
// Start the animation
        playerNames.startAnimation(animation);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getPlayerOneName = playerone.getText().toString();
                final String getPlayerTwoName = playertwo.getText().toString();

                if(getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()){
                    Toast.makeText(AddPlayers.this,"Please enter player name",Toast.LENGTH_LONG).show();
                }else {
                    Intent i = new Intent(AddPlayers.this,MainActivity.class);
                    i.putExtra("playerOne",getPlayerOneName);
                    i.putExtra("playerTwo",getPlayerTwoName);
                    startActivity(i);
                }
            }
        });
    }
}