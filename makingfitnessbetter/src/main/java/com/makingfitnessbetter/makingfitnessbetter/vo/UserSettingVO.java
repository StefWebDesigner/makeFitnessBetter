package com.makingfitnessbetter.makingfitnessbetter.vo;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserSettingVO {

    private Integer memberId;
    private String username;
    private String password;
    private String email;

}
