package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.UserException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitRegistrationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidationImp implements UserValidationService {

    @Autowired
    private UserRepository userRepository;

    public User userValidation(SubmitRegistrationVO submitRegistrationVO){

        User user = new User();
        user.setUsername(submitRegistrationVO.getUsername());
        user.setPassword(submitRegistrationVO.getPassword());
        user.setEmail(submitRegistrationVO.getEmail());
        user.setRole(submitRegistrationVO.getRole());

        //Checking if user already exists
        if(user != null) {
            Optional<User> formUser = userRepository.findByUsername(user.getUsername());
            if(formUser.isPresent()) {
                user.setActionCd("USER_EXISTS");
                throw new UserException("Account already exist, please log in to existing account");
            }
            user.setActionCd("USER_CREATED");
        }

        return user;
    }




}
