package com.example.amrappattempt2;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.amrappattempt2.adapter.ExerciseAdapter;
import com.example.amrappattempt2.entity.Exercise;
import com.example.amrappattempt2.entity.ExerciseList;
import com.example.amrappattempt2.enums.ExerciseType;

public class ExercisesActivity extends AppCompatActivity {
    ExerciseList exerciseList;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        // Create the exercise list
        exerciseList = new ExerciseList(getPreferences(MODE_PRIVATE));

        // Set up the adapter
        ListView exerciseListView = findViewById(R.id.exercise_list);
        this.exerciseAdapter = new ExerciseAdapter(this, exerciseList);
        exerciseListView.setAdapter(exerciseAdapter);


        // Set up add exercise button
        Button addExercise = findViewById(R.id.add_exercise_button);
        addExercise.setOnClickListener(v -> addExercise());
    }

    // Add Exercise methods
    private void addExercise() {
        AlertDialog.Builder nameAlert = new AlertDialog.Builder(this);
        EditText nameEditText = new EditText(this);
        nameEditText.setSingleLine(true);
        nameAlert.setMessage("Enter Exercise Name");
        nameAlert.setTitle("New Exercise");

        // TODO lets add a dropdown that has - and the ExerciseType enum options for the exercise\
            // TODO this will mean creating an additional view that we add instead of the nameEditText

        nameAlert.setView(nameEditText);

        nameAlert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String exerciseName = nameEditText.getText().toString();
                Exercise exercise = new Exercise(exerciseName, ExerciseType.PUSH);
                exerciseList.add(exercise);
                exerciseAdapter.notifyDataSetChanged();
            }
        });

        nameAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        nameAlert.show();
    }

    /* TODO EXERCISES (Basics)
            - take type of workout as well (and then we can filter on type)
            - CURR - pedantic but - sort alphabetically
       TODO TEMPLATES
            and that should do for the basics of the exercise menu
            then we can move on to templates
            which we will set up and have add exercise popup (different from add activity if possible)
       TODO HEADER
            also we should add a header that's consistent with a back button for these screens
     */
}