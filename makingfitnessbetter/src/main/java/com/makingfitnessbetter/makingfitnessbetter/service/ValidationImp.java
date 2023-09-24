package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.ExerciseLogException;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.UserException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.utility.transactionCode;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitExerciseLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitRegistrationVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ValidationImp implements ValidationService {

    @Autowired
    private UserRepository userRepository;

    public User userValidation(SubmitRegistrationVO submitRegistrationVO){

        log.info("Going through user registration validation");

        User user = new User();
        user.setUsername(submitRegistrationVO.getUsername());
        user.setPassword(submitRegistrationVO.getPassword());
        user.setEmail(submitRegistrationVO.getEmail());
        user.setRole(submitRegistrationVO.getRole());

        if(
                user.getUsername()== null || user.getUsername().equals("")
                || user.getPassword()== null || user.getPassword().equals("")
                || user.getEmail()== null || user.getEmail().equals("")
                || user.getRole()== null || user.getRole().equals("")
        ) {
            log.error("Invalid entry, all fields need to be inputed");
            throw new UserException("Invalid entry, all fields need to be inputed");
        }
        if(user != null) {
            Optional<User> formUser = userRepository.findByUsername(user.getUsername());
            if(formUser.isPresent()) {
                user.setActionCd("USER_EXISTS");
                log.error("User regsistration : User already exists exists");
                throw new UserException("Account already exist, please log in to existing account");
            }
            user.setActionCd("USER_CREATED");
            log.info("User regsistration : User was created");
        }
        return user;
    }

    public SubmitExerciseLogVO validateExerciseLog(SubmitExerciseLogVO submitExerciseLogVO){

        log.info("Exercise Validation : starting");
        SubmitExerciseLogVO validationResults = new SubmitExerciseLogVO();
        List<EntryLog> finalList = new ArrayList<>();

        try{
            List<EntryLog> checkingList = submitExerciseLogVO.getLiExistingEntryLog();
            finalList = checkingList.stream().filter(valCheck -> Objects.equals(valCheck.getEntryId(), submitExerciseLogVO.getExerciseId())).collect(Collectors.toList());

            log.info("Exercise Validation : filtering out the the list of existing entry logs");
            if(submitExerciseLogVO.getExerciseId() == null){
                submitExerciseLogVO.setActionCd(transactionCode.CRE_EXE_LOG);
                log.info("Exercise Validation : Creating the entry log");
            } else {
                submitExerciseLogVO.setActionCd(transactionCode.EXE_EXE_LOG);
                log.info("Exercise Validation : Finding out the entry log is already existing");
            }
            log.info("Exercise Validation : Return positive validation result");
            return  validationResults;
        } catch (Exception e){
            log.error("Exercise Validation : Validation failed for exercise log");
            throw new ExerciseLogException("Error validation Exercise");
        }
    }

}
