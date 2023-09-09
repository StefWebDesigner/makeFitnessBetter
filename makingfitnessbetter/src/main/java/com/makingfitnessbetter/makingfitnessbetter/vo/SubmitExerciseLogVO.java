package com.makingfitnessbetter.makingfitnessbetter.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Data
public class SubmitExerciseLogVO {

    private Integer ExerciseId;
    private String ExerciseName;
    private Integer sets;
    private Integer reps;
    private String comments;


}
