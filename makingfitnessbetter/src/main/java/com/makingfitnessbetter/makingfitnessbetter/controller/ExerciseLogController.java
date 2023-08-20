package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.ExerciseLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.service.EntryLogService;
import com.makingfitnessbetter.makingfitnessbetter.service.ExerciseLogService;
import com.makingfitnessbetter.makingfitnessbetter.vo.AddingEntryLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.ExerciseLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercise")
public class ExerciseLogController {
    @Autowired
    ExerciseLogService exerciseLogService;

    @Autowired
    EntryLogService entryLogService;

    @PostMapping("/create")
    public ResponseEntity<Object> createExerciseLog(@RequestParam Integer entryId, @RequestBody ExerciseLogVO exerciseLogVO, @RequestParam Integer id){
        try{
            User result = exerciseLogService.createEntryLog(entryId, exerciseLogVO, id);
            return ExerciseLogVO.generateResponse("Exercised was successfully logged", HttpStatus.CREATED, result);
        } catch(EntryLogException e){
            throw new EntryLogException("Entry fail to log, please try again");
        }
    }

    @GetMapping("/allExercisesInLog")
    public ResponseEntity<Object> findAllExerciseLogPerEntry(@RequestParam Integer id, @RequestParam Integer entryId){
        try{
            List<ExerciseLog> results = exerciseLogService.findAllExerciseLogPerEntry(id, entryId);
            return ExerciseLogVO.generateResponse("Retrieved all exercises", HttpStatus.OK, results);
        } catch(EntryLogException e){
            throw new EntryLogException("Unable to fetch your exercises for this entry. Please try again");
        }
    }


}
