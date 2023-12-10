package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.GoalEntry;
import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.GoalException;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalCreationSubmitVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalListDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GoalServiceImp implements GoalService{

    @Autowired
    ValidationService validationService;

    public GoalListDTO goalCreation(GoalCreationSubmitVO goalCreationSubmitVO){

        //    Validation and checking for actionCd
        validationService.validateGoal(goalCreationSubmitVO);

        String selectActionCd = goalCreationSubmitVO.getActionCd();

        if(selectActionCd.equals("GlCr")){
            //    Create Goals method
        } else if (selectActionCd.equals("GlMod")){
            //Modify Goals methods
        } else if (selectActionCd.equals("GlDl")){
            //Delete Goals methods
        }

        //    Transaction goals



        return null;
    }

    public GoalListDTO createNewGoal(GoalCreationSubmitVO goalCreationSubmitVO){
        log.info("Entered in the create new goal flow");




        try{






            log.info("Leaving in the create new goal flow");
            return null;


        } catch (GoalException e){
            throw new GoalException("Error in creating the new goal");
        }

    }
    public GoalEntry modifyExistingGoal(GoalCreationSubmitVO goalCreationSubmitVO){
        return null;
    }
    public GoalEntry deleteExistingGoal(GoalCreationSubmitVO goalCreationSubmitVO){
        return null;
    }



}
