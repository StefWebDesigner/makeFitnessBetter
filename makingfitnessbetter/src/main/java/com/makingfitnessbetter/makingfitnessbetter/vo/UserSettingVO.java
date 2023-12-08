package com.makingfitnessbetter.makingfitnessbetter.vo;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.Column;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public class UserSettingVO {

    private Integer memberId;
    private String username;
    private String password;
    private String email;
    private Integer failedAttempt;
    private Boolean accountNotLocked;
    private Date lockTime;
    @Column(name = "verifcation_code", length = 64)
    private String verifcationCode;
    private String actionCd;

}
