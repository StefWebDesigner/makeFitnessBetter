package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.Goal;
import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import lombok.Data;

import java.util.List;

@Data
public class GoalCreationSubmitVO {

    private Integer goalId;
    private String goalName;
    private String actionCd;
    private Integer memberId;
    private List<GoalList> goalLists;
    private Integer goalListId;
    private String goalDescriptions;
    private Boolean isCompleted;
    private Goal goal;
    private User user;

}
