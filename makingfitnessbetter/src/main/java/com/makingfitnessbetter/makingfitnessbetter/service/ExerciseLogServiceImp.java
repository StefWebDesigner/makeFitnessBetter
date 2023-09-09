package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.ExerciseLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.ExerciseLogException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.EntryLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.repositories.ExerciseLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.utility.transactionCode;
import com.makingfitnessbetter.makingfitnessbetter.vo.AddingEntryLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.ExerciseLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitExerciseLogVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExerciseLogServiceImp implements ExerciseLogService{

    @Autowired
    ExerciseLogRepository exerciseLogRepository;

    @Autowired
    EntryLogRepository entryLogRepository;

    @Autowired
    ValidationService validationService;

    @Autowired
    EntryLogService entryLogService;

    @Autowired
    UserRepository userRepository;

    //CREATE AN EXERCISELOG
    public User createEntryLog(Integer entryId, ExerciseLogVO exerciseLogVO, Integer id) {
        try {
            User findMemId = userRepository.findById(id).get();
            EntryLog selectedEntry = entryLogRepository.findById(entryId).get();
            List<EntryLog> entryLogList = new ArrayList<>(Collections.singleton(selectedEntry));

            findMemId.setEntryLogList(entryLogList);

            ExerciseLog newExerciseLog = new ExerciseLog();
            newExerciseLog.setExerciseName(exerciseLogVO.getExerciseName());
            newExerciseLog.setEntryId(selectedEntry.getEntryId());
            newExerciseLog.setMemberId(findMemId.getMemberId());
            newExerciseLog.setSets(exerciseLogVO.getSets());
            newExerciseLog.setReps(exerciseLogVO.getReps());
            newExerciseLog.setComments(exerciseLogVO.getComments());
            exerciseLogRepository.save(newExerciseLog);

            List<ExerciseLog> allExerciseLog = selectedEntry.getExerciseLogList();
                allExerciseLog.add(newExerciseLog);

            selectedEntry.setExerciseLogList(allExerciseLog);
            entryLogRepository.save(selectedEntry);

            userRepository.save(findMemId);

            return findMemId;
        } catch (EntryLogException e) {
            throw new EntryLogException("Some required information was missing. Please try again");
        }
    }

    // Create Exercise Flow

    public SubmitExerciseLogVO createExerciseLog(SubmitExerciseLogVO submitExerciseLogVO){
        return null;
    }


    // Modify/Update Exercise Flow
    public SubmitExerciseLogVO modifyExerciseLog(SubmitExerciseLogVO submitExerciseLogVO){
        return null;
    }

    //Submit Exercise flow
    public SubmitExerciseLogVO submitExerciseLog(SubmitExerciseLogVO submitExerciseLogVO, Integer id){

        List<EntryLog> liEntryExerciseLog = new ArrayList<>();

        submitExerciseLogVO.setMemberId(id);

        // Find all the entry/Exercise logs and add the to the object
        liEntryExerciseLog = entryLogService.fetchAllEntryRecords(submitExerciseLogVO.getMemberId());
        submitExerciseLogVO.setLiEntryExerciseLogs(liEntryExerciseLog);


        // PUSHING TO A MODIFY OR CREATE FLOW - VALIDATION FLOW
        validationService.validateExerciseLog(submitExerciseLogVO);

        if(submitExerciseLogVO.getActionCd().equals(transactionCode.CRE_EXE_LOG)){
            // Go through the creation flow
        } else {
            // Go through the modifdy flow
        }

        // 4) create a transaction log for it


        return null;
    }














    //Find All Exercise logS FOR A SINGLE ENTRY
    public List<ExerciseLog> findAllExerciseLogPerEntry(Integer id, Integer entryId) {
        try {
            Optional<User> seletedUser = userRepository.findById(id);
            if (seletedUser.isPresent()) {
                Optional<EntryLog> selectedEntry = entryLogRepository.findById(entryId);
                if (selectedEntry.isPresent()) {
                    List<ExerciseLog> allExerLogs = selectedEntry.get().getExerciseLogList();
                    return allExerLogs;
                } else {
                    throw new ExerciseLogException("No entry exists");
                }
            } else {
                throw new ExerciseLogException("No user exists");
            }
        } catch (ExerciseLogException e){
            throw new ExerciseLogException("There was an issue, please try again");
        }
    }







}
