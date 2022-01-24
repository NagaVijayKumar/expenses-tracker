package com.vijaykumar.user.repository;

import com.vijaykumar.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository{

    User saveUser(User user);

    User getUserByEmail(String email);
}
