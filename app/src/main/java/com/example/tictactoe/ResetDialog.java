package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ResetDialog extends Dialog  {



        private final  MainActivity mainActivity;
        public ResetDialog(@NonNull Context context, MainActivity mainActivity) {
            super(context);
            this.mainActivity = mainActivity;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.reset_dialog_layout);

            final Button resetYes = findViewById(R.id.resetYes);


            resetYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.restartMatch();
                    dismiss();
                }
            });


        }


}
