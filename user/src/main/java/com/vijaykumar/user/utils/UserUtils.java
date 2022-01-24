package com.vijaykumar.user.utils;

import com.vijaykumar.user.dto.UserDto;
import com.vijaykumar.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;


public class UserUtils {
    private UserUtils userUtils;

    @Autowired
    public void setUserUtils(UserUtils userUtils){
        this.userUtils = userUtils;
    }
    public User toUser(UserDto userDto){

        User user = new User(userDto.getFirstName(),userDto.getLastName(),userDto.getEmail());

        return user;
    }
}
