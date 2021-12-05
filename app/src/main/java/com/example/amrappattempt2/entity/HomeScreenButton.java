package com.example.amrappattempt2.entity;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.amrappattempt2.R;
import com.google.android.material.card.MaterialCardView;

public class HomeScreenButton {
    Context context;

    MaterialCardView button;
    LayoutInflater inflater;

    public HomeScreenButton(Context context, String labelText) {
        this.context = context;

        // Create the Button
        inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.button = (MaterialCardView) inflater.inflate(R.layout.home_screen_button, null, false);

        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
        param.columnSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
        param.width = 0;
        param.setMargins(15,15,15,15);
        this.button.setLayoutParams(param);

        // Set the Text
        TextView label = button.findViewById(R.id.label);
        label.setText(labelText);
    }

    public MaterialCardView getButton() {
        return button;
    }
}

