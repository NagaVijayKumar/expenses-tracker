package com.vijaykumar.user.utils;

import com.vijaykumar.user.dto.UserDto;
import com.vijaykumar.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    public UserDto toUserDto(User user){

       UserDto userDto = new UserDto(user.getFirstName(),user.getLastName(), user.getEmail());

       return  userDto;
    }
}
