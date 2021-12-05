package com.example.amrappattempt2;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ExercisesActivity extends AppCompatActivity {
    // TODO read in the list of exercises from a file -- just txt file? at least for now
    List<String> exercises = new ArrayList();
    ArrayAdapter<String> exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        // Set up the adapter
        ListView exerciseList = findViewById(R.id.exercise_list);
        exerciseAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exercises);
        exerciseList.setAdapter(exerciseAdapter);

        // Set up add exercise button
        Button addExercise = findViewById(R.id.add_exercise_button);
        addExercise.setOnClickListener(v -> addExercise());
    }

    private void addExercise() {
        exercises.add("Test String");
        exerciseAdapter.notifyDataSetChanged();
    }

    /* TODO EXERCISES (Basics)
            add an x to delete the exercises
            take in a strong when add exercise is hit to add
            read in a text file -- look up how we're supposed to do this
            save to text file
       TODO TEMPLATES
            and that should do for the basics of the exercise menu
            then we can move on to templates
            which we will set up and have add exercise popup (different from add activity if possible)
       TODO HEADER
            also we should add a header that's consistent with a back button for these screens
     */
}