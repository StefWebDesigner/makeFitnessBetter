package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitRegistrationVO;

public interface UserValidationService {

    public User userValidation( SubmitRegistrationVO submitRegistrationVO);

}
