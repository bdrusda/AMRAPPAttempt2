package com.example.amrappattempt2.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.amrappattempt2.ExercisesActivity;
import com.example.amrappattempt2.R;
import com.example.amrappattempt2.entity.Exercise;
import com.example.amrappattempt2.entity.ExerciseList;
import com.example.amrappattempt2.enums.ExerciseType;
import com.example.amrappattempt2.holder.ExerciseHolder;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {
    private final Context context;
    private final ExercisesActivity exercisesActivity;
    private ExerciseList exerciseList;

    public ExerciseAdapter(ExercisesActivity exercisesActivity, ExerciseList exerciseList) {
        super(exercisesActivity.getApplicationContext(), R.layout.exercise, exerciseList.getExercises());
        this.context = exercisesActivity.getApplicationContext();
        this.exerciseList = exerciseList;
        this.exercisesActivity = exercisesActivity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View exerciseView = convertView;
        ExerciseHolder holder = null;

        Exercise exercise = exerciseList.getExercises().get(position);

        if (exerciseView == null) {
            exerciseView = LayoutInflater.from(getContext()).inflate(R.layout.exercise, parent, false);
            holder = new ExerciseHolder();
            holder.setLogo(exerciseView.findViewById(R.id.logo));
            holder.setName(exerciseView.findViewById(R.id.name));
            holder.setType(exerciseView.findViewById(R.id.type));
            holder.setDelete(exerciseView.findViewById(R.id.delete));
            exerciseView.setTag(holder);
        } else {
            holder = (ExerciseHolder) exerciseView.getTag();
        }

        // Set the Exercise Info
        holder.getLogo().setText(exercise.getName().substring(0,1));
        holder.getName().setText(exercise.getName());
        holder.getType().setText(exercise.getType().getValue());
        holder.getDelete().setTag(position);

        // Set up Delete Button
        holder.getDelete().setOnClickListener(v -> deleteExercise(v));

        return exerciseView;
    }

    private void deleteExercise(View v) {
        AlertDialog.Builder deleteAlert = new AlertDialog.Builder(exercisesActivity);
        deleteAlert.setTitle("Delete Exercise");
        deleteAlert.setMessage("Are you sure you want to delete this exercise?");

        deleteAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int position = (int) v.getTag();
                exerciseList.delete(position);
                notifyDataSetChanged();
            }
        });

        deleteAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });

        deleteAlert.show();
    }
}
