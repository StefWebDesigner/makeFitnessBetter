package com.makingfitnessbetter.makingfitnessbetter.vo;


import com.makingfitnessbetter.makingfitnessbetter.entities.Goal;
import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GoalVO {

    private Integer goalId;
    private String goalName;
    private String actionCd;
    private List<GoalList> goalLists;
    private Integer goalListId;
    private String goalDescriptions;
    private Boolean isCompleted;
    private Goal goal;

     public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object objResponse){
         Map<String, Object> map = new HashMap<>();
         map.put("message", message);
         map.put("status", status.value());
         map.put("response", objResponse);
         return new ResponseEntity<Object>(map, status);
     }



}
