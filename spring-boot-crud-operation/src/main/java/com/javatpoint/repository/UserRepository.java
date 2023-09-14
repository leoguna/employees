package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
