package com.app.repo.impl;

import com.app.model.Task;
import com.app.repo.generic.AbstractCrudRepository;
import com.app.repo.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskRepositoryImpl extends AbstractCrudRepository<Task, Long> implements CrudRepository<Task, Long> {
    public TaskRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
