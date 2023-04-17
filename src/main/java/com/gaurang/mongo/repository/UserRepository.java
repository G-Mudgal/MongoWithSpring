package com.gaurang.mongo.repository;

import com.gaurang.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    User deleteByEmail(String email);

}
