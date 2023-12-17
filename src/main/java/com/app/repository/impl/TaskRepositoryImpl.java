package com.app.repository.impl;

import com.app.model.Task;
import com.app.repository.TaskRepository;
import com.app.repository.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskRepositoryImpl extends AbstractCrudRepository<Task, Long> implements TaskRepository {
    public TaskRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
