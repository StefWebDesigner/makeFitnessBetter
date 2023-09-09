package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class SubmitExerciseLogVO {

    private Integer ExerciseId;
    private String ExerciseName;
    private Integer sets;
    private Integer reps;
    private String comments;
    private Integer memberId;
    private String actionCd;
    private List<EntryLog> liEntryExerciseLogs;



}

