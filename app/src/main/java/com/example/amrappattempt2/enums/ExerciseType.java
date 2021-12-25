package com.example.amrappattempt2.enums;

import lombok.Getter;

@Getter
public enum ExerciseType {
    /* TODO For the moment let's just do very basic groups
     *  - Idea -
     *  In the future we will have advanced exercise screen where you can add all tags that apply
     *  I'll have basic exercises listed out -- we can do subclasses or have all tags at the same level
     *      Is there definitive structure?
     *      Upper
     *          Push
     *              Chest
     *              Shoulders
     *                  Lateral/front/rear delt, traps (technically back but fine)
     *              Triceps
     *          Pull
     *              Biceps, Back
     *      Lower - Legs
     *          Quad, Ham, Calf
     *      Core
     *          Abs, Obliques
     *      Cardio
     */
    PUSH("Push"), PULL("Pull"), LEGS("Legs"), CORE("Core"), CARDIO("Cardio");

    public final String value;

    ExerciseType(String value) {
        this.value = value;
    }
}