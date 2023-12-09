package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.Goal;
import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import lombok.Data;

import java.util.List;

@Data
public class GoalCreationSubmit {

    private Integer goalId;
    private String goalName;
    private String actionCd;
    private List<GoalList> goalLists;
    private Integer goalListId;
    private String goalDescriptions;
    private Boolean isCompleted;
    private Goal goal;

}
