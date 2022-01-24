package com.vijaykumar.user.controller;

import com.vijaykumar.user.dto.UserDto;
import com.vijaykumar.user.model.User;
import com.vijaykumar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email){
        return userService.getUserByEmail(email);
    }


}
