package com.example.amrappattempt2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.amrappattempt2.R;
import com.example.amrappattempt2.entity.Exercise;
import com.example.amrappattempt2.holder.ExerciseHolder;

import java.util.List;

public class ExerciseAdapter extends ArrayAdapter<Exercise> {
    private final Context context;
    private final List<Exercise> exercises;

    public ExerciseAdapter(Context context, List<Exercise> exerciseArrayList) {
        super(context, R.layout.exercise, exerciseArrayList);
        this.context = context;
        this.exercises = exerciseArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View exerciseView = convertView;
        ExerciseHolder holder = null;

        Exercise exercise = exercises.get(position);

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
        holder.getType().setText("("+exercise.getType()+")");
        holder.getDelete().setTag(position);

        // Set up Delete Button
        holder.getDelete().setOnClickListener(v -> deleteExercise(v));

        return exerciseView;
    }

    private void deleteExercise(View v) {
        int position = (int) v.getTag();
        exercises.remove(position);
        notifyDataSetChanged();
    }
}
