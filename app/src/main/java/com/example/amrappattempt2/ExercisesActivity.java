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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExercisesActivity extends AppCompatActivity {
    public static final String EXERCISES = "EXERCISES";
    List<Exercise> exercises;
    ExerciseAdapter exerciseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        // Get exercises
        exercises = readExercises();

        // Set up the adapter
        ListView exerciseList = findViewById(R.id.exercise_list);
        this.exerciseAdapter = new ExerciseAdapter(getApplicationContext(), exercises);
        exerciseList.setAdapter(exerciseAdapter);

        // Set up add exercise button
        Button addExercise = findViewById(R.id.add_exercise_button);
        addExercise.setOnClickListener(v -> addExercise());
    }


    // Add Exercise methods
    private void addExercise() {
        AlertDialog.Builder nameAlert = new AlertDialog.Builder(this);
        EditText nameEditText = new EditText(this);
        nameAlert.setMessage("Enter Exercise Name");
        nameAlert.setTitle("New Exercise");

        nameAlert.setView(nameEditText);

        nameAlert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String exerciseName = nameEditText.getText().toString();
                Exercise exercise = new Exercise(exerciseName, "Test Type (Implement Later)");
                exercises.add(exercise);
                writeExercises();
                exerciseAdapter.notifyDataSetChanged();
            }
        });

        nameAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        nameAlert.show();
    }

    /* TODO when we delete it's not persisting -- maybe we create ExerciseList object
            This would allow us to encapsulate the read/write exercises methods
            And, chiefly, we would be able to update the list in SharedPreferences whenever we make a change
     */

    // Data Persistence methods
    private void writeExercises() {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        String exercisesJSONString = new Gson().toJson(exercises);
        editor.putString(EXERCISES, exercisesJSONString);
        editor.commit();
    }

    private List<Exercise> readExercises() {
        String connectionsJSONString = getPreferences(MODE_PRIVATE).getString(EXERCISES, null);
        Type type = new TypeToken<List<Exercise>>() {}.getType();
        List<Exercise> exercises = new Gson().fromJson(connectionsJSONString, type);
        return (exercises == null) ? new ArrayList() : exercises;
    }
    /* TODO EXERCISES (Basics)
            - take in a string when add exercise is hit to add
                need to do the type of workout eventually as well (and then we can filter on type)
            - add confirmation for the delete eventually
            - pedantic but - sort alphabetically
       TODO TEMPLATES
            and that should do for the basics of the exercise menu
            then we can move on to templates
            which we will set up and have add exercise popup (different from add activity if possible)
       TODO HEADER
            also we should add a header that's consistent with a back button for these screens
     */
}