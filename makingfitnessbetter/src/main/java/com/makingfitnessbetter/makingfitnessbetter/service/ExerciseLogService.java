package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.ExerciseLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.vo.AddingEntryLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.ExerciseLogVO;

import java.util.List;
import java.util.Optional;

public interface ExerciseLogService {
    //CREATE AN EXERCISELOG
    User createEntryLog(Integer entryId, ExerciseLogVO exerciseLogVO, Integer id);

    //Find All Exercise logS FOR A SINGLE ENTRY
    public List<ExerciseLog> findAllExerciseLogPerEntry(Integer id, Integer entryId);

}
