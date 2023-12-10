package com.makingfitnessbetter.makingfitnessbetter.vo;

import com.makingfitnessbetter.makingfitnessbetter.entities.GoalEntry;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GoalListDTO {
    private Integer goalListId;
    private String goalName;
    private Boolean isGoalCompleted;
    private List<GoalEntry> goalEntryEntryList;
    private String actionCd;
    private Date dateCreated;
    private User user;

}
