package com.example.amrappattempt2.entity;

import lombok.Data;

@Data
public class Exercise {
    String name;
    String type;    // TODO make this an enum

    public Exercise(String name) {
        this.name = name.trim();
    }

    public Exercise(String name, String type) {
        this.name = name.trim();
        this.type = type;
    }
}
