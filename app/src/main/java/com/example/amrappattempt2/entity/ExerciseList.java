package com.example.amrappattempt2.entity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class ExerciseList {
    Context context;
    SharedPreferences sharedPreferences;
    public static final String EXERCISES = "EXERCISES";
    List<Exercise> exercises;

    public ExerciseList(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.exercises = readExercises();
    }

    public void add(Exercise exercise) {
        exercises.add(exercise);
        writeExercises();
    }

    public void delete(int position) {
        exercises.remove(position);
        writeExercises();
    }

    // Data Persistence methods
    public void writeExercises() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String exercisesJSONString = new Gson().toJson(exercises);
        editor.putString(EXERCISES, exercisesJSONString);
        editor.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<Exercise> readExercises() {
        String connectionsJSONString = sharedPreferences.getString(EXERCISES, null);
        Type type = new TypeToken<List<Exercise>>() {}.getType();
        List<Exercise> exercises = new Gson().fromJson(connectionsJSONString, type);
        return (exercises == null) ? new ArrayList() : exercises.stream().sorted().collect(Collectors.toList());
    }
}
