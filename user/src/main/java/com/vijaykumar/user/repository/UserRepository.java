package com.vijaykumar.user.repository;

import com.vijaykumar.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
