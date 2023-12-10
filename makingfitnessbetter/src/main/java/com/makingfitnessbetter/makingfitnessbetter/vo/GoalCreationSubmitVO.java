package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.GoalEntry;
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
    private GoalEntry goalEntry;
    private User user;
    private List<String> enteredGoalsList;

}
