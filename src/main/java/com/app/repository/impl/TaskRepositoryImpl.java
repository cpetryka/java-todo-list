package com.app.repository.impl;

import com.app.model.Task;
import com.app.repository.generic.AbstractCrudRepository;
import com.app.repository.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskRepositoryImpl extends AbstractCrudRepository<Task, Long> implements CrudRepository<Task, Long> {
    public TaskRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
