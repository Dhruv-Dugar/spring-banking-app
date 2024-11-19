package com.spring.Banking.Service;

import com.spring.Banking.Entity.User;
import com.spring.Banking.Model.UserModel;
import com.spring.Banking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserModel userModel) {
        // TODO Auto-generated method stub
        User user = new User();
        user.setEmail(userModel.getEmail());
        user.setFullName(userModel.getFullName());
        // user.setLastName(userModel.getLastName());
        user.setRole(userModel.getRole());
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        try {
            userRepository.save(user);
            return user;
        } catch (DataIntegrityViolationException e) {
            // TODO: handle exception
            throw new DataIntegrityViolationException(null);
        }

    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}