package com.spring.Banking.Repository;

import com.spring.Banking.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // public  User findByEmailId(String emailId);

    public User findByEmail(String email);

    public boolean existsByEmail(String email);
}