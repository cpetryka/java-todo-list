package com.app.repository;

import com.app.model.User;
import com.app.repository.generic.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
