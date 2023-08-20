package com.makingfitnessbetter.makingfitnessbetter.service;


import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserVO;

public interface UserService {

    //CREATE A NEW USER
    User create(UserVO userVO);
}
