package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.EntryLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.vo.CreateEntryLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryLogServiceImp implements EntryLogService {

    @Autowired
    EntryLogRepository entryLogRepository;

    //CREATE ENTRYLOG
    public EntryLog createEntry(CreateEntryLogVO entryLogVo){
        try{
            EntryLog newEntry = new EntryLog();
            newEntry.setEntryName(entryLogVo.getEntryName());
            newEntry.setOverallComments(entryLogVo.getOverallComments());
            entryLogRepository.save(newEntry);
            return newEntry;
        } catch(EntryLogException e){
            throw new EntryLogException("All indicated fields not properly filled in");
        }

    }


}
