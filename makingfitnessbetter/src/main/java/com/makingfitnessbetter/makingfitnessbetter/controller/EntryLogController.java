package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.exceptions.EntryLogException;
import com.makingfitnessbetter.makingfitnessbetter.service.EntryLogService;
import com.makingfitnessbetter.makingfitnessbetter.vo.CreateEntryLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entry")
public class EntryLogController {

    @Autowired
    EntryLogService entryLogService;

    //CREATE AN ENTRY
    @PostMapping("/create")
    public ResponseEntity<Object> createEntryLog(@RequestBody CreateEntryLogVO createEntryLogVo){
        try{
            Object result = entryLogService.createEntry(createEntryLogVo);
            return CreateEntryLogVO.generateResponse("Entry creation was sucessful", HttpStatus.OK, result);
        } catch(EntryLogException e) {
            throw new EntryLogException("Missing required information");
        }
    }

}
