package com.app.repo.impl;

import com.app.model.TaskHistory;
import com.app.repo.generic.AbstractCrudRepository;
import jakarta.persistence.EntityManagerFactory;

public class TaskHistoryRepository extends AbstractCrudRepository<TaskHistory, Long> {
    public TaskHistoryRepository(EntityManagerFactory emf) {
        super(emf);
    }
}
