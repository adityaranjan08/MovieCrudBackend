package com.niit.repo;

import com.niit.entity.Movie;
import com.niit.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<User,String> {
    /**
     *
     * @param email Email of the user
     * @return User entity for this particular email
     */
    public User findByEmail(String email);



}
