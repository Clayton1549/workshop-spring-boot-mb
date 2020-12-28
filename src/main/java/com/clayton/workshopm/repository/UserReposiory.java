package com.clayton.workshopm.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.clayton.workshopm.domain.User;

@Repository
public interface UserReposiory extends MongoRepository<User, String>{

}



