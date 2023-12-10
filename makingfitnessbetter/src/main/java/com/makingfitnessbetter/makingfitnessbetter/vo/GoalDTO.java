package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import lombok.Data;

import java.util.List;

@Data
public class GoalDTO {
    private Integer goalId;
    private String goalName;
    private String actionCd;
    private List<GoalList> goalLists;

}
