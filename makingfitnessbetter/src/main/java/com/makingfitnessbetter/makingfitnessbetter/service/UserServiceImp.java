package com.makingfitnessbetter.makingfitnessbetter.service;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import com.makingfitnessbetter.makingfitnessbetter.exceptions.UserException;
import com.makingfitnessbetter.makingfitnessbetter.repositories.UserRepository;
import com.makingfitnessbetter.makingfitnessbetter.vo.SubmitRegistrationVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserLoginVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserSettingVO;
import com.makingfitnessbetter.makingfitnessbetter.vo.UserSettingsFormVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ValidationService validationService;

    @Autowired
    TransactionLogService transactionLogService;

    @Autowired
    PasswordEncoder encoder;

    //CREATE A NEW USER
    public User create(User user){
        try{
            log.info("User registration");
            user.setFailedAttempt(0);
            user.setAccountNotLocked(true);
            user.setPassword(encoder.encode(user.getPassword()));
            User userModel = userRepository.save(user);
            log.info("User registration : Returning the new the new user");
            return userModel;
        } catch (Exception e){
            log.error("User registration : Error when processing user, not validation related");
            throw new UserException("Make sure to fill out all fields");
        }
    }


    public User submitRegistration(SubmitRegistrationVO submitRegistrationVO){
        try{
            User user = new User();
            // validation layer --- found out if they have an already existing user
            user =  validationService.userValidation(submitRegistrationVO);
            log.info("User registration : Entering the user validation layer");
            User submitUser = create(user);
            log.info("User registration : entering the create user method");
            transactionLogService.createUserLog(user);
            log.info("User registration : Returning registered user");
            return submitUser;
        } catch(Exception e){
            log.error("User registration : user validation failed");
            throw new UserException("Missing field information, try again");
        }


    }

    public UserSettingVO userSettings(UserSettingsFormVO userSettingsFormVO, Integer memberId){

        UserSettingVO resultUser = new UserSettingVO();
        resultUser.setActionCd(userSettingsFormVO.getActionCd());
        resultUser.setMemberId(memberId);





        // validation phase
        // Check if the action code generated from the request is get or update
        //They make have this set

//        UserSettingVO fetchUserInfo = new UserSettingVO();


        if(resultUser.getActionCd().equals("FTC_USR_INFO")){
            // Enter the get user info
            resultUser =  getUserSettingDetails(resultUser);
            return resultUser;

        } else if(resultUser.getActionCd().equals("UPD_USR_INFO")) {
            resultUser =  updateUserSettings(resultUser, userSettingsFormVO);



            //Enter the update user info
        }

        //an if condition to : either get the information or update

        // add the transaction logs

        return null;

    }


    public UserSettingVO getUserSettingDetails(UserSettingVO resultUser){

        Optional<User> selectedUser = userRepository.findById(resultUser.getMemberId());
        if(selectedUser.isPresent()){
            resultUser.setEmail(selectedUser.get().getEmail());
            resultUser.setPassword(selectedUser.get().getPassword());
            resultUser.setFailedAttempt(selectedUser.get().getFailedAttempt());
            resultUser.setLockTime(selectedUser.get().getLockTime());
            resultUser.setAccountNotLocked(selectedUser.get().getAccountNotLocked());
            resultUser.setVerifcationCode(selectedUser.get().getVerifcationCode());

            return resultUser;
        } else {
            throw new UserException("User not found");
        }

    }

    public UserSettingVO updateUserSettings(UserSettingVO resultUser, UserSettingsFormVO userSettingsFormVO){
        UserSettingVO selectedUser =  getUserSettingDetails(resultUser);

        






        return null;
    }







    // ============== SECURITY  RELATED REQUESTS ==============

    // ***** GET ROLE OF USER BY EMAIL *****
    public String getRoleByEmail(String email){
        try{
            String role = userRepository.findByUsername(email).get().getRole();
            return role;
        } catch(Exception e){
            throw new UserException("NO ROLE OF THE USER FOUND. CHECK IF THE EMAIL IS CORRECT");
        }

    }

    // ***** GET ROLE OF USER BY USERNAME *****
    public String getRoleByUsername(String username){
        try{
            String role = userRepository.findByUsername(username).get().getRole();
            return role;
        }catch(Exception e){
            throw new UserException("NO ROLE OF THE USER FOUND. CHECK IF THE USERNAME IS CORRECT");
        }
    }

    // ***** GET USER BY EMAIL *****
    public User getUserByEmail(String email)  {
        try{
            User user= userRepository.findByEmail(email).get();
//            ModelMapper modelMapper=new ModelMapper();
//            UserResponse userresponse =modelMapper.map(user,UserResponse.class);
//            return userresponse;
            return user;
        } catch(Exception e){
            throw new UserException("NO USER FOUND. CHECK IF THE EMAIL IS CORRECT");
        }

    }

    // ***** GET USER BY USERNAME *****
    @Override
    public User getUserByUsername(String username) {
        try {
            Optional<User> user=userRepository.findByUsername(username);
            if (!user.isPresent()){
                throw new BadCredentialsException("user not found exception");
            }
            return user.get();
        }catch(Exception e){
            throw new UserException("NO USER FOUND. CHECK IF THE USERNAME IS CORRECT");
        }

    }

    @Override
    public UserLoginVO getUserVOByUsername(String username) {
        try {
            Optional<User> user=userRepository.findUserVOByUsername(username);
            UserLoginVO userLoginVO = new UserLoginVO();
            userLoginVO.setMemberId(user.get().getMemberId());
            userLoginVO.setUsername(user.get().getUsername());
            userLoginVO.setFailedAttempt(user.get().getFailedAttempt());
            userLoginVO.setLockTime(user.get().getLockTime());
            userLoginVO.setRole(user.get().getRole());

            if (!user.isPresent()){
                throw new BadCredentialsException("user not found exception");
            }
            return userLoginVO;
        }catch(Exception e){
            throw new UserException("NO USER FOUND. CHECK IF THE USERNAME IS CORRECT");
        }

    }

    // ***** UPDATE FAILED ATTEMPTS *****
    @Override
    public void updateFailedAttempts(int failAttempts, String email){
        try{
            User user=userRepository.findByEmail(email).get();
            user.setFailedAttempt(failAttempts);
            userRepository.save(user);
        }
        catch(Exception e){
            throw new UserException("UNABLE TO UPDATE FAILEDATTEMPTS");
        }

    }

    // ***** INCREASE FAILED ATTEMPTS FAILING TO LOGIN *****
    @Override
    public void increaseFailedAttempts(User user) {
        try{
            int newFailAttempts = user.getFailedAttempt() + 1;
            updateFailedAttempts(newFailAttempts, user.getEmail());
        }
        catch(Exception e){
            throw new UserException("UNABLE TO INCREASE FAILED ATTEMPTS");
        }
    }

    // ***** RESET FAILED ATTEMPTS *****
    @Override
    public void resetFailedAttempts(String email) {
        try{
            updateFailedAttempts(0, email);
        }
        catch(Exception e){
            throw new UserException("UNABLE TO RESEST THE FAILED ATTEMPTS");
        }
    }

    // ***** LOCK USER OUT WHEN EXCEEDING FAILED ATTEMPTS *****
    @Override
    public void lock(User user) {
        try{
            user.setAccountNotLocked(false);
            user.setLockTime(new Date());
            userRepository.save(user);
        }
        catch(Exception e){
            throw new UserException("UNABLE TO ACCESS ACCOUNT, YOU HAVE BEEN LOCKED");
        }
    }

    // ***** UNLOCK A USER WHEN TIME EXPIRES *****
    @Override
    public boolean unlockWhenTimeExpired(User user) {
        try{
            long lockTimeInMillis = user.getLockTime().getTime();
            long currentTimeInMillis = System.currentTimeMillis();

            if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
                user.setAccountNotLocked(true);
                user.setLockTime(null);
                user.setFailedAttempt(0);
                userRepository.save(user);
                return true;
            }
            return false;
        }
        catch(Exception e){
            throw new UserException("ERROR SETTING UP UNLOCK COUNTDOWN");
        }
    }






}
