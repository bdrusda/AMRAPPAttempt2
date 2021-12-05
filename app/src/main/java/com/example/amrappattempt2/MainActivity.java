package com.example.amrappattempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import com.example.amrappattempt2.entity.HomeScreenButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout homeGrid = findViewById(R.id.home_grid);

        // Create the buttons
        HomeScreenButton templatesButton = new HomeScreenButton(this, "Templates");
        HomeScreenButton previousButton = new HomeScreenButton(this, "Previous Workouts");
        HomeScreenButton exercisesButton = new HomeScreenButton(this, "Exercises");
        HomeScreenButton newButton = new HomeScreenButton(this, "New Workout");
        HomeScreenButton settingsButton = new HomeScreenButton(this, "Settings");

        // On Click listeners
        exercisesButton.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ExercisesActivity.class);
                startActivity(intent);
            }
        });

        // Add the buttons to the grid
        homeGrid.addView(templatesButton.getButton());
        homeGrid.addView(previousButton.getButton());
        homeGrid.addView(exercisesButton.getButton());
        homeGrid.addView(newButton.getButton());
        homeGrid.addView(settingsButton.getButton());
    }

}