package com.bitbyte.blog.repository;

import com.bitbyte.blog.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {



}
