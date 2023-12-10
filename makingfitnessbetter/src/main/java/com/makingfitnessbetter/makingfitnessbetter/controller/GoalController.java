package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.GoalEntry;
import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.GoalException;
import com.makingfitnessbetter.makingfitnessbetter.service.GoalService;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalCreationSubmitVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalListDTO;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalListVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goal")
@Slf4j
public class GoalController {

    @Autowired
    GoalService goalService;


//    public ResponseEntity<Object> goalCreation()

    // Flow :
    //    Validation and checking for actionCd
    //    Create Goals method
    //    Modify Goals methods
    //    Delete Goals methods
    //    Transaction goals

    public ResponseEntity<Object> goalCreation(@RequestBody GoalCreationSubmitVO goalCreationSubmitVO){
        log.info("Starting Goal Creation Flow");
        try{
            GoalListDTO result = goalService.goalCreation(goalCreationSubmitVO);
            if(goalCreationSubmitVO.getActionCd().equals("GlCr")){
                log.info("Goal Created Succesfully returned");
                return GoalListVO.generateResponse("Goal created", HttpStatus.CREATED, result);

                //Todo : Add the else if for the modify and delete methods
            } else {
                throw new GoalException("Goal was not accessible. Please try again");
            }
            //Todo : Add the else if for the modify and delete methods

        } catch (GoalException e){
            throw new GoalException(e.getMessage());
        }

    }





}
