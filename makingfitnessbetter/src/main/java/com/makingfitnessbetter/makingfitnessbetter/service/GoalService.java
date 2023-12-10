package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.GoalEntry;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalCreationSubmitVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalListDTO;

public interface GoalService {
    public GoalListDTO goalCreation(GoalCreationSubmitVO goalCreationSubmitVO);

    public GoalListDTO createNewGoal(GoalCreationSubmitVO goalCreationSubmitVO);
    public GoalEntry modifyExistingGoal(GoalCreationSubmitVO goalCreationSubmitVO);
    public GoalEntry deleteExistingGoal(GoalCreationSubmitVO goalCreationSubmitVO);
}
