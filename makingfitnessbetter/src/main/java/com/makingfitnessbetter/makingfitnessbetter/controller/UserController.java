package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.UserException;
import com.makingfitnessbetter.makingfitnessbetter.service.UserService;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserVO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //CREATE A USER
    @PostMapping("/create")
    public ResponseEntity<Object> createNewUser(@RequestBody UserVO userVO){
        try{
            User result = userService.create(userVO);
            return UserVO.generateResponse("User created", HttpStatus.OK, result);
        } catch(UserException e){
            throw new UserException("Make sure to enter all information");
        }

    }

}
