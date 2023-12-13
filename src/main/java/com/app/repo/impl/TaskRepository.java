package com.app.repo.impl;

import com.app.model.Task;
import com.app.repo.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskRepository extends AbstractCrudRepository<Task, Long> {
    public TaskRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
