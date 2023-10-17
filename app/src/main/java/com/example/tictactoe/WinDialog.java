package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {

    private final String messagee;
    private final  MainActivity mainActivity;
    public WinDialog(@NonNull Context context, String messagee, MainActivity mainActivity) {
        super(context);
        this.messagee = messagee;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);

        final TextView message = findViewById(R.id.message);
        final Button startAgain = findViewById(R.id.startAgain);
        final Button continuos = findViewById(R.id.contin);
        final ImageView img = findViewById(R.id.img);
        img.setImageResource(R.drawable.cross);
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                1.0f, 1.5f, // fromX, toX
                1.0f, 0.5f, // fromY, toY
                Animation.RELATIVE_TO_SELF, 0.5f, // pivotXType, pivotXValue
                Animation.RELATIVE_TO_SELF, 1.0f // pivotYType, pivotYValue
        );
        scaleAnimation.setDuration(1000); // 1 second
        scaleAnimation.setRepeatCount(1); // repeat once
        scaleAnimation.setRepeatMode(Animation.REVERSE); // reverse the animation
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.RESTART);

// Start the animation
        img.startAnimation(scaleAnimation);
        message.setText(messagee);

        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.restartMatch();
                dismiss();
            }
        });
        continuos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.continueMatch();
                dismiss();
            }
        });

    }
}
