package com.app.repo.impl;

import com.app.model.User;
import com.app.repo.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class UserRepository extends AbstractCrudRepository<User, Long> {
    public UserRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
