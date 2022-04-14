package com.example.restInn.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.restInn.entity.UserModel;

public interface UserDao extends MongoRepository<UserModel, String> {

}
