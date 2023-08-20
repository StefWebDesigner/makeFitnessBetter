package com.makingfitnessbetter.makingfitnessbetter.controller;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.UserException;
import com.makingfitnessbetter.makingfitnessbetter.service.UserService;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //CREATE A USER
    @PostMapping("/create")
    public ResponseEntity<Object> createNewUser(@RequestBody User user){
        try{
            User result = userService.create(user);
            return UserVO.generateResponse("User created", HttpStatus.OK, result);
        } catch(UserException e){
            throw new UserException("Make sure to enter all information");
        }

    }

    @GetMapping("/getUser")
    public User getUserViaUsername(@RequestParam String username){
        User user = userService.getUserByUsername(username);
        return user;

    }

}
