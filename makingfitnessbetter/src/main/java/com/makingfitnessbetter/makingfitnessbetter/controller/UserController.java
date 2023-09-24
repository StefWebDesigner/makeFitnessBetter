package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.UserException;
import com.makingfitnessbetter.makingfitnessbetter.service.UserService;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitRegistrationVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserLoginVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUser")
    public UserLoginVO getUserViaUsername(@RequestParam String username){
        UserLoginVO user = userService.getUserVOByUsername(username);
        return user;
    }

    @PostMapping("/submitRegistration")
    public ResponseEntity<Object> sumbitRegistration(@RequestBody SubmitRegistrationVO submitRegistrationVO){
        log.info("Registration Flow : Intializing");
        try{
            User result = userService.submitRegistration(submitRegistrationVO);
            return UserVO.generateResponse("User created", HttpStatus.CREATED, result);
        } catch(UserException e){
            log.error("Registration Flow : Error trigger and unable to register the user");
            throw new UserException(e.getMessage());
        }
    }

}
