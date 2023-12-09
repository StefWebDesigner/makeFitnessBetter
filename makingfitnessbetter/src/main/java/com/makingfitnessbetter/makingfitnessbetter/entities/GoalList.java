package com.makingfitnessbetter.makingfitnessbetter.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class GoalList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer goalListId;
    private String goalDescriptions;
    private Boolean isCompleted;
    private Integer goalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goal_goalId")
    @JsonBackReference
    private Goal goal;

}
