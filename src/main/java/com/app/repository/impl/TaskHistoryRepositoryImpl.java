package com.app.repository.impl;

import com.app.model.TaskHistory;
import com.app.repository.generic.AbstractCrudRepository;
import com.app.repository.generic.CrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskHistoryRepositoryImpl extends AbstractCrudRepository<TaskHistory, Long> implements CrudRepository<TaskHistory, Long> {
    public TaskHistoryRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
