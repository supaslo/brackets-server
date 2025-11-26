package com.wilzsoft.brackets.brackets_server.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wilzsoft.brackets.brackets_server.dao.repository.UserInfoRepository;
import com.wilzsoft.brackets.brackets_server.domain.entity.UserInfo;
import com.wilzsoft.brackets.brackets_server.model.request.UserRequest;
import com.wilzsoft.brackets.brackets_server.model.response.UserResponse;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    public String deleteUser(Integer userId) {

        userInfoRepository.deleteById(userId);
        return("Successful Delete");
    }

    public ArrayList<UserResponse> getUsers() {
        
        ArrayList<UserResponse> userResponses = new ArrayList<>();
        Iterable<UserInfo> users = new ArrayList<>();

        users = userInfoRepository.findAll();
        for(UserInfo user : users) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.getId());
            userResponse.setUserId(user.getUserId());
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setRole(user.getRole());
            userResponse.setCreatedDate(user.getCreatedDate());
            userResponse.setUpdatedDate(user.getUpdatedDate());

            userResponses.add(userResponse);
        }

        return userResponses;

    }

    public UserResponse getUserByUserId(Integer userId) {

        UserInfo user = new UserInfo();
        Optional<UserInfo> dbUser = userInfoRepository.findById(userId);
        if (dbUser.isPresent()) {
            user = dbUser.get();
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUserId(user.getUserId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setRole(user.getRole());
        userResponse.setCreatedDate(user.getCreatedDate());
        userResponse.setUpdatedDate(user.getUpdatedDate());

        return userResponse;

    }

    public UserResponse createUser(UserRequest user) {

        UserInfo newUser = new UserInfo();

        newUser.setUserId(user.getUserId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setRole(user.getRole());
        newUser.setCreatedDate(user.getCreatedDate());
        newUser.setUpdatedDate(user.getUpdatedDate());

        UserInfo savedUserInfo = new UserInfo();
        UserResponse newUserResponse = new UserResponse();

        savedUserInfo = userInfoRepository.save(newUser);

        newUserResponse.setUserId(savedUserInfo.getUserId());
        newUserResponse.setFirstName(savedUserInfo.getFirstName());
        newUserResponse.setLastName(savedUserInfo.getLastName());
        newUserResponse.setRole(savedUserInfo.getRole());
        newUserResponse.setCreatedDate(savedUserInfo.getCreatedDate());
        newUserResponse.setUpdatedDate(savedUserInfo.getUpdatedDate());

        return newUserResponse;

    }

    public UserResponse updateUser(UserRequest user) {

        UserInfo modifiedUser = new UserInfo();

        modifiedUser.setId(user.getId());
        modifiedUser.setUserId(user.getUserId());
        modifiedUser.setFirstName(user.getFirstName());
        modifiedUser.setLastName(user.getLastName());
        modifiedUser.setRole(user.getRole());
        modifiedUser.setCreatedDate(user.getCreatedDate());
        modifiedUser.setUpdatedDate(user.getUpdatedDate());

        UserInfo savedUserInfo = new UserInfo();
        UserResponse newUserResponse = new UserResponse();

        savedUserInfo = userInfoRepository.save(modifiedUser);

        newUserResponse.setUserId(savedUserInfo.getUserId());
        newUserResponse.setFirstName(savedUserInfo.getFirstName());
        newUserResponse.setLastName(savedUserInfo.getLastName());
        newUserResponse.setRole(savedUserInfo.getRole());
        newUserResponse.setCreatedDate(savedUserInfo.getCreatedDate());
        newUserResponse.setUpdatedDate(savedUserInfo.getUpdatedDate());

        return newUserResponse;
    }
}
