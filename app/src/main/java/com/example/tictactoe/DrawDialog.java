package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class DrawDialog extends Dialog {
    private final String messagee;
    private final  MainActivity mainActivity;
    public DrawDialog(@NonNull Context context, String messagee, MainActivity mainActivity) {
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
        img.setImageResource(R.drawable.nulll);
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 1.0f, // fromXDelta
                Animation.RELATIVE_TO_PARENT, -1.0f, // toXDelta
                Animation.RELATIVE_TO_PARENT, 0f, // fromYDelta
                Animation.RELATIVE_TO_PARENT, 0f // toYDelta
        );
        animation.setDuration(5000); // 5 seconds
        animation.setRepeatCount(Animation.INFINITE); // repeat indefinitely

// Start the animation
        animation.setRepeatMode(Animation.REVERSE); // reverse the animation
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.RESTART);

// Start the animation
        img.startAnimation(animation);
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
