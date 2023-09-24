package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.ExerciseLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.TransactionLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.ExerciseLogException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.EntryLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.repositories.ExerciseLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.repositories.TransactionLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.utility.transactionCode;
import com.makingfitnessbetter.makingfitnessbetter.vo.AddingEntryLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.EntryExecTransactionLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.ExerciseLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitExerciseLogVO;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
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

    @Autowired
    TransactionLogService transactionLogService;

    @Autowired
    TransactionLogRepository transactionLogRepository;

    //CREATE AN EXERCISELOG
    public User createEntryLog(Integer entryId, ExerciseLogVO exerciseLogVO, Integer id) {
        try {
            User findMemId = userRepository.findById(id).orElseThrow(() -> new EntryLogException("User not found"));
            EntryLog selectedEntry = entryLogRepository.findById(entryId).orElseThrow(() -> new EntryLogException("EntryLog not found"));

            // Create the new ExerciseLog.
            ExerciseLog newExerciseLog = new ExerciseLog();
            newExerciseLog.setExerciseName(exerciseLogVO.getExerciseName());
            newExerciseLog.setEntryId(selectedEntry.getEntryId());  // Assuming this method sets the EntryLog entity and not just an ID.
            newExerciseLog.setMemberId(findMemId.getMemberId());
            newExerciseLog.setSets(exerciseLogVO.getSets());
            newExerciseLog.setReps(exerciseLogVO.getReps());
            newExerciseLog.setComments(exerciseLogVO.getComments());

            // Link the ExerciseLog to the EntryLog.
            newExerciseLog.setEntryLog(selectedEntry);  // This is assuming that there's a setEntry() method in ExerciseLog entity.

            // Save the new ExerciseLog to the database.
            exerciseLogRepository.save(newExerciseLog);

            // If the EntryLog's ExerciseLogList is null, initialize it. Then, add the new ExerciseLog.
            if(selectedEntry.getExerciseLogList() == null) {
                selectedEntry.setExerciseLogList(new ArrayList<>());
            }
            selectedEntry.getExerciseLogList().add(newExerciseLog);

            // Update the EntryLog in the database.
            entryLogRepository.save(selectedEntry);

            // Update the user's entry logs.
            if(findMemId.getEntryLogList() == null) {
                findMemId.setEntryLogList(new ArrayList<>());
            }
            findMemId.getEntryLogList().add(selectedEntry);
            userRepository.save(findMemId);

            return findMemId;

        } catch (Exception e) {
            throw new EntryLogException("Some required information was missing. Please try again");
        }
    }

    // Create Exercise Flow
    public EntryLog createExerciseLog(SubmitExerciseLogVO submitExerciseLogVO){
        log.info("Submiting Exercise Set : Entering the creation flow");
        EntryLog submitEntry = new EntryLog();
        ExerciseLog submitExerciseLog = new ExerciseLog();
        EntryExecTransactionLogVO transLog = new EntryExecTransactionLogVO();

        try {
            submitEntry = entryLogRepository.findById(submitExerciseLogVO.getEntryId()).get();

            submitExerciseLog.setMemberId(submitExerciseLogVO.getMemberId());
            submitExerciseLog.setExerciseName(submitExerciseLogVO.getExerciseName());
            submitExerciseLog.setSets(submitExerciseLogVO.getSets());
            submitExerciseLog.setReps(submitExerciseLogVO.getReps());
            submitExerciseLog.setEntryId(submitExerciseLogVO.getEntryId());
            submitExerciseLog.setComments(submitExerciseLogVO.getComments());
            submitExerciseLog.setActionCd(transactionCode.CRE_EXE_LOG);

            log.info("Submiting Exercise Set : convering the list to the object");
            List<ExerciseLog> allExistingExeForIndivEntry = submitEntry.getExerciseLogList();
            allExistingExeForIndivEntry.add(submitExerciseLog);

            exerciseLogRepository.save(submitExerciseLog);
            submitEntry.setExerciseLogList(allExistingExeForIndivEntry);
            log.info("Submiting Exercise Set : Saving the newly exercise log");
            entryLogRepository.save(submitEntry);

            transLog.setMemberId(submitExerciseLogVO.getMemberId());
            transLog.setExerciseName(submitExerciseLogVO.getExerciseName());
            transLog.setSets(submitExerciseLogVO.getSets());
            transLog.setComments(submitExerciseLogVO.getComments());
            transLog.setActionCd(transactionCode.CRE_EXE_LOG);

            log.info("Submiting Exercise Set : Creating a transaction log for newly creately exervicse log");
            transactionLogService.createModifyExerciseTransactionLog(transLog);

            return submitEntry;
        } catch(Exception e){
            throw new ExerciseLogException("something");
        }
    }

    // Modify/Update Exercise Flow
    public EntryLog modifyExerciseLog(SubmitExerciseLogVO submitExerciseLogVO){
        log.info("Submiting Exercise Set : Entering the modify log flow ");
        EntryLog submitEntry = new EntryLog();
        ExerciseLog submitExerciseLog = new ExerciseLog();
        EntryExecTransactionLogVO transLog = new EntryExecTransactionLogVO();

        try {
            submitEntry = entryLogRepository.findById(submitExerciseLogVO.getEntryId()).get();
            submitExerciseLog = exerciseLogRepository.findById(submitExerciseLogVO.getExerciseId()).get();

            submitExerciseLog.setMemberId(submitExerciseLogVO.getMemberId());
            submitExerciseLog.setExerciseName(submitExerciseLogVO.getExerciseName());
            submitExerciseLog.setSets(submitExerciseLogVO.getSets());
            submitExerciseLog.setReps(submitExerciseLogVO.getReps());
            submitExerciseLog.setEntryId(submitExerciseLogVO.getEntryId());
            submitExerciseLog.setComments(submitExerciseLogVO.getComments());
            submitExerciseLog.setActionCd(transactionCode.CRE_EXE_LOG);
            submitExerciseLog.setExerciseId(submitExerciseLog.getExerciseId());

            List<ExerciseLog> allExistingExeForIndivEntry = submitEntry.getExerciseLogList();
            allExistingExeForIndivEntry.add(submitExerciseLog);

            exerciseLogRepository.save(submitExerciseLog);
            submitEntry.setExerciseLogList(allExistingExeForIndivEntry);
            log.info("Submiting Exercise Set : Saving the modified exercise log ");
            entryLogRepository.save(submitEntry);

            transLog.setMemberId(submitExerciseLogVO.getMemberId());
            transLog.setExerciseName(submitExerciseLogVO.getExerciseName());
            transLog.setSets(submitExerciseLogVO.getSets());
            transLog.setComments(submitExerciseLogVO.getComments());
            transLog.setActionCd(transactionCode.CRE_EXE_LOG);

            log.info("Submiting Exercise Set : Creating a log for the modify log ");
            transactionLogService.createModifyExerciseTransactionLog(transLog);
            return submitEntry;
        } catch(Exception e){
            log.error("Submiting Exercise Set : something");
            throw new ExerciseLogException("something");
        }
    }

    //Submit Exercise flow
    public SubmitExerciseLogVO submitExerciseLog(SubmitExerciseLogVO submitExerciseLogVO){
        log.info("Submiting Exercise Set : Central method intiation submit Exercise process");

        try {
            List<EntryLog> liExistingEntryLog = new ArrayList<>();

            log.info("Submiting Exercise Set : Gathering all records");
            liExistingEntryLog = entryLogService.fetchAllEntryRecords(submitExerciseLogVO.getMemberId());
            submitExerciseLogVO.setLiExistingEntryLog(liExistingEntryLog);

            log.info("Submiting Exercise Set : Validating the the exerice log and attachign action_cd");
            validationService.validateExerciseLog(submitExerciseLogVO);

            log.info("Submiting Exercise Set : Checking the flow using the newly added action_cd");
            if(submitExerciseLogVO.getActionCd().equals(transactionCode.CRE_EXE_LOG)){
                log.info("Submiting Exercise Set : Going through the creation flow");
                EntryLog processedEntry = createExerciseLog(submitExerciseLogVO);
            } else {
                log.info("Submiting Exercise Set : Going through the modify exercise flow");
                EntryLog processedExercise = modifyExerciseLog(submitExerciseLogVO);
            }

            log.info("Submiting Exercise Set : returning create/or modified exercise set");
            return submitExerciseLogVO;

        } catch (Exception e){
            log.error("error in updating excercice log");
            throw new EntryLogException("Unable to submit the exercise log");
        }
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
        } catch (Exception e){
            throw new ExerciseLogException("There was an issue, please try again");
        }
    }


}
