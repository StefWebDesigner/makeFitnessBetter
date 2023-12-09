package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.Goal;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalCreationSubmitVO;

public interface GoalService {
    public Goal goalCreation(GoalCreationSubmitVO goalCreationSubmitVO);

    public Goal createNewGoal(GoalCreationSubmitVO goalCreationSubmitVO);
    public Goal modifyExistingGoal(GoalCreationSubmitVO goalCreationSubmitVO);
    public Goal deleteExistingGoal(GoalCreationSubmitVO goalCreationSubmitVO);
}
