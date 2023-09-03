package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.TransactionLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;

public interface TransactionLogService {

    public TransactionLog createUserLog(User user);


}
