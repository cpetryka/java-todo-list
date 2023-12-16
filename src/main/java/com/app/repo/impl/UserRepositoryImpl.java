package com.app.repo.impl;

import com.app.model.User;
import com.app.repo.generic.AbstractCrudRepository;
import com.app.repo.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class UserRepositoryImpl extends AbstractCrudRepository<User, Long> implements CrudRepository<User, Long> {
    public UserRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
