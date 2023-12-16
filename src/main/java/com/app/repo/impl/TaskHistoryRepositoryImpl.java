package com.app.repo.impl;

import com.app.model.TaskHistory;
import com.app.repo.generic.AbstractCrudRepository;
import com.app.repo.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskHistoryRepositoryImpl extends AbstractCrudRepository<TaskHistory, Long> implements CrudRepository<TaskHistory, Long> {
    public TaskHistoryRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
