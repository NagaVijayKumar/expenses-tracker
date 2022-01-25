package com.vijaykumar.user.service;

import com.vijaykumar.user.dto.UserDto;
import com.vijaykumar.user.model.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {
    String createUser(User user);

    User getUserByEmail(String email);

    User updateUserByEmail(String email, User user);

}
