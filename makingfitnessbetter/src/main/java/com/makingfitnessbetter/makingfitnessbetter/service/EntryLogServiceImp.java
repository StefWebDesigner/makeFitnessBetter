package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.ExerciseLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.EntryLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.vo.CreateEntryLogVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitEntryLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EntryLogServiceImp implements EntryLogService {

    @Autowired
    EntryLogRepository entryLogRepository;

    @Autowired
    UserRepository userRepository;

    //CREATE ENTRYLOG
    public EntryLog createEntry(CreateEntryLogVO entryLogVo, Integer id){
        log.info("Entry Log Creation : Entering the Entry Service");
        try{
            Optional<User> userOpt = userRepository.findById(id);
            if(userOpt.isPresent()) {
                User user = userOpt.get();
                log.info("Entry Log Creation : Getting the User information and saving the new entry");

                EntryLog newEntry = new EntryLog();
                newEntry.setUser(user);  // Setting the user relationship here
                newEntry.setEntryName(entryLogVo.getEntryName());
                newEntry.setOverallComments(entryLogVo.getOverallComments());
                newEntry.setMemberId(user.getMemberId());
                entryLogRepository.save(newEntry);
                return newEntry;
            } else {
                log.error("Entry Log Creation : User wasn't present");
                throw new EntryLogException("User not present");
            }
        } catch(Exception e){
            throw new EntryLogException("All indicated fields not properly filled in");
        }
    }

    public List<EntryLog> fetchAllEntryRecords(Integer id){
        try{
            log.info("Fetch All Exercises : Starting the process of finding all the user");
            List<EntryLog> allEntries = entryLogRepository.findAllByMemberId(id);
            return allEntries;
        } catch(Exception e){
            log.error("Fetch All Exercises : No records were found");
            throw new EntryLogException("No entries were found");
        }
    }

}
