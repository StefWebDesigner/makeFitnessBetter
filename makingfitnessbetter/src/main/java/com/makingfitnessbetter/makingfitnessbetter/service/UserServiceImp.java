package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    //CREATE A NEW USER
    public User create(UserVO userVO){
        User newUser = new User();
        newUser.setUsername(userVO.getUsername());
        newUser.setEmail(userVO.getEmail());
        newUser.setPassword(userVO.getPassword());

        userRepository.save(newUser);

        return newUser;

    }




}
