package com.antonfifindik.persistence;

import com.antonfifindik.domain.User;
import com.antonfifindik.domain.UserField;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(mongoTemplate.findOne(Query.query(Criteria.where(UserField.USER_NAME.getField()).is(username)), User.class));

    }

    public void save(@NonNull User user) {
        mongoTemplate.save(user);
    }
}
