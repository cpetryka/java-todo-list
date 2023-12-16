package com.app.repository.impl;

import com.app.model.User;
import com.app.repository.generic.AbstractCrudRepository;
import com.app.repository.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class UserRepositoryImpl extends AbstractCrudRepository<User, Long> implements CrudRepository<User, Long> {
    public UserRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
