package com.app.repo;

import com.app.model.User;
import com.app.repo.generic.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
