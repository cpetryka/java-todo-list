package com.app.repository.impl;

import com.app.model.User;
import com.app.repository.UserRepository;
import com.app.repository.generic.AbstractCrudRepository;
import com.app.repository.generic.CrudRepository;
import com.app.repository.generic.EntityManagerWrapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl extends AbstractCrudRepository<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
