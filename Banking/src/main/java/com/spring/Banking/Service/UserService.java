package com.spring.Banking.Service;


import com.spring.Banking.Entity.User;
import com.spring.Banking.Model.UserModel;

public interface UserService {
    public User registerUser(UserModel userModel);

    public  boolean existsByEmail(String email);
}