package com.example.amrappattempt2.entity;

import com.example.amrappattempt2.enums.ExerciseType;

import lombok.Data;

@Data
public class Exercise implements Comparable {
    String name;
    ExerciseType type;

    public Exercise(String name) {
        this.name = name.trim();
    }

    public Exercise(String name, ExerciseType type) {
        this.name = name.trim();
        this.type = type;
    }

    @Override
    public int compareTo(Object o) {
        return name.toLowerCase().compareTo(((Exercise) o).name.toLowerCase());
    }
}
