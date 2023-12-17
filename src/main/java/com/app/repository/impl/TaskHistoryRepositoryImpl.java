package com.app.repository.impl;

import com.app.model.TaskHistory;
import com.app.repository.TaskHistoryRepository;
import com.app.repository.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskHistoryRepositoryImpl extends AbstractCrudRepository<TaskHistory, Long> implements TaskHistoryRepository {
    public TaskHistoryRepositoryImpl(EntityManagerFactory emf) {
        super(emf);
    }
}
