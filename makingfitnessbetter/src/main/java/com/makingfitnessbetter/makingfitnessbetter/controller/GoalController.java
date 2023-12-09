package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.Goal;
import com.makingfitnessbetter.makingfitnessbetter.service.GoalService;
import com.makingfitnessbetter.makingfitnessbetter.vo.GoalCreationSubmit;
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

    public ResponseEntity<Object> goalCreation(@RequestBody GoalCreationSubmit goalCreationSubmit){
        log.info("Starting Goal Creation Flow");
        try{
            Goal result = goalService.goalCreation(goalCreationSubmit);
            if(goalCreationSubmit.getActionCd().equals("GlCr")){
                log.info("Goal Created Succesfully returned");
                return GoalVO.generateResponse("Goal created", HttpStatus.CREATED, result);
            }
            //Todo : Add the else if for the modify and delete methods

        }
    }





}
