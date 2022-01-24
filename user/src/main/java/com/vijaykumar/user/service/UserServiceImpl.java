package com.vijaykumar.user.service;

import com.vijaykumar.user.dto.UserDto;
import com.vijaykumar.user.model.User;
import com.vijaykumar.user.repository.UserRepository;
import com.vijaykumar.user.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserUtils userUtils;

    @Override
    public String createUser(User user) {
        userRepository.saveUser(user);
        return "User Created Successfully";
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
//        return null;
    }

}
