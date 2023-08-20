package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import com.makingfitnessbetter.makingfitnessbetter.vo.CreateEntryLogVO;

public interface EntryLogService{

    //CREATE ENTRYLOG
    EntryLog createEntry(CreateEntryLogVO entryLogVo);
}
