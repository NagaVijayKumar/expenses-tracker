package com.vijaykumar.user.repository;

import com.vijaykumar.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
@Repository

public class UserRepositoryImpl implements UserRepository {



    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public User saveUser(User user) {
        return mongoTemplate.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        User user =  mongoTemplate.findById(email,User.class);

        return user;
    }

}
