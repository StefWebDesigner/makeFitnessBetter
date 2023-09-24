package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.ExerciseLog;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.service.EntryLogService;
import com.makingfitnessbetter.makingfitnessbetter.vo.CreateEntryLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.ExerciseLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitEntryLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/entry")
@Slf4j
public class EntryLogController {

    @Autowired
    EntryLogService entryLogService;

    //CREATE AN ENTRY
    @PostMapping("/create")
    public ResponseEntity<Object> createEntryLog(@RequestBody CreateEntryLogVO createEntryLogVo, @RequestParam Integer id){
        log.info("Entry Log Creation : Intalizing");
        try{
            Object result = entryLogService.createEntry(createEntryLogVo, id);
            return CreateEntryLogVO.generateResponse("Entry creation was sucessful", HttpStatus.CREATED, result);
        } catch(EntryLogException e) {
            log.error("Entry Log Creation : Missing required information");
            throw new EntryLogException("Missing required information");
        }
    }

    @GetMapping("fetchAllExercises")
    public ResponseEntity<Object>fetchAllEntryRecords(@RequestParam Integer id){
        try{
            List<EntryLog> result = entryLogService.fetchAllEntryRecords(id);
            return ExerciseLogVO.generateResponse("Retrieved all exercises", HttpStatus.OK, result);
        }catch(EntryLogException e){
            throw new EntryLogException("Unable to fetch your all your exercise records. Please try again");
        }
    }

}
