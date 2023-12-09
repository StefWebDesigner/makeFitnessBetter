package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.Goal;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalCreationSubmit;

public interface GoalService {
    public Goal goalCreation(GoalCreationSubmit goalCreationSubmit);
}
