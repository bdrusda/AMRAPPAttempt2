package com.example.amrappattempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;

import com.example.amrappattempt2.entity.HomeScreenButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout homeGrid = findViewById(R.id.home_grid);

        HomeScreenButton templatesButton = new HomeScreenButton(this, "Templates");
        homeGrid.addView(templatesButton.getButton());
        HomeScreenButton previousButton = new HomeScreenButton(this, "Previous Workouts");
        homeGrid.addView(previousButton.getButton());
        HomeScreenButton exercisesButton = new HomeScreenButton(this, "Exercises");
        homeGrid.addView(exercisesButton.getButton());
        HomeScreenButton newButton = new HomeScreenButton(this, "New Workout");
        homeGrid.addView(newButton.getButton());
        HomeScreenButton settingsButton = new HomeScreenButton(this, "Settings");
        homeGrid.addView(settingsButton.getButton());
    }

}