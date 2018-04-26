package com.antonfifindik.persistence;

import com.antonfifindik.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<User> findByUsername(String s) {
        return mongoTemplate.findOne()
    }
}
