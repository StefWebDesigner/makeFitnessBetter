package com.makingfitnessbetter.makingfitnessbetter.vo;


import com.makingfitnessbetter.makingfitnessbetter.entities.GoalEntry;
import com.makingfitnessbetter.makingfitnessbetter.entities.GoalList;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class GoalListVO {

    private Integer goalListId;
    private String goalName;
    private Boolean isGoalCompleted;
    private List<GoalEntry> goalEntryEntryList;
    private String actionCd;
    private Date dateCreated;

     public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object objResponse){
         Map<String, Object> map = new HashMap<>();
         map.put("message", message);
         map.put("status", status.value());
         map.put("response", objResponse);
         return new ResponseEntity<Object>(map, status);
     }



}
