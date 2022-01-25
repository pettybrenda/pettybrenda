package com.access.control.service;
import com.access.control.models.User;
import com.access.control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository  userRepository;

@Autowired
    PasswordEncoder passwordEncoder;
    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    @Transactional(readOnly = true)
    public User findByUserName(String  userName) {
        return userRepository.findByUserName(userName);
    }


}
