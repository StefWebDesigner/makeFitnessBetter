package com.makingfitnessbetter.makingfitnessbetter.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Data
@Entity
public class ExerciseLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ExerciseId;
    private Integer entryId;
    private Integer memberId;
    private String ExerciseName;
    private Integer sets;
    private Integer reps;
    private String comments;
//    private List<ExerciseLog> ExerciseId;
//    private List<ExerciseLog> ExerciseName;
//    private List<ExerciseLog> sets;
//    private List<ExerciseLog> reps;
//    private List<ExerciseLog> comments;

}