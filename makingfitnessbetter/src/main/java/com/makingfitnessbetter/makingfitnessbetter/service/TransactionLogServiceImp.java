package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.TransactionLog;
import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.repositories.TransactionLogRepository;
import com.makingfitnessbetter.makingfitnessbetter.utility.transactionCode;
import com.makingfitnessbetter.makingfitnessbetter.vo.EntryExecTransactionLogVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TransactionLogServiceImp implements TransactionLogService {

    @Autowired
    private TransactionLogRepository transactionLogRepository;

    public TransactionLog createUserLog(User user) {
        TransactionLog transactionLog = new TransactionLog();

        if (user.getActionCd().equals("USER_EXISTS")) {
            log.info("User registration : Setting the translog for the user already existing");

            transactionLog.setMemberId(user.getMemberId());
            transactionLog.setEntryId(null);
            transactionLog.setExerciseId(null);
            transactionLog.setTransDescription(transactionCode.USR_EXT);
//            transactionLog.setLogDateMade(LocalTime.now());
            transactionLog.setLogDateMade(null);
            transactionLog.setUserMod(user.getUsername());

            TransactionLog sumbitedLog = transactionLogRepository.save(transactionLog);

            log.info("User registration : Returning the translog for the user already existing");
            return sumbitedLog;
        } else {
            log.info("User registration : Setting the translog for the new user");
            transactionLog.setMemberId(user.getMemberId());
            transactionLog.setEntryId(null);
            transactionLog.setExerciseId(null);
            transactionLog.setTransDescription(transactionCode.USR_CRE);
//            transactionLog.setLogDateMade(LocalTime.now());
            transactionLog.setLogDateMade(null);
            transactionLog.setUserMod(user.getUsername());

            log.info("User registration : Returning the translog for the new user");
            TransactionLog sumbitedLog = transactionLogRepository.save(transactionLog);
            return sumbitedLog;
        }
    }

    public TransactionLog createModifyExerciseTransactionLog(EntryExecTransactionLogVO transLog) {
        TransactionLog transactionLog = new TransactionLog();

        try {
                transactionLog.setMemberId(transLog.getMemberId());
                transactionLog.setEntryId(transLog.getEntryId());
                transactionLog.setExerciseId(transLog.getExerciseId());
                transactionLog.setTransCd(transLog.getActionCd());
                // leave out the userMod and date for now

            log.info("Submiting Exercise Set : Creating the transaction log ");
            return transactionLogRepository.save(transactionLog);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
